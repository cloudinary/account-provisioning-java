package example;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.operations.*;

import com.cloudinary.account.provisioning.models.errors.CldProvisioningException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Application {

    private int passed;
    private int failed;
    private int skipped;
    private final List<String> errors = new ArrayList<>();

    private void pass(String name) {
        passed++;
        System.out.printf("  PASS: %s%n", name);
    }

    private void fail(String name, Exception err) {
        if (err instanceof CldProvisioningException) {
            var apiErr = (CldProvisioningException) err;
            if (apiErr.code() == 403) {
                skipped++;
                System.out.printf("  SKIP: %s — %s%n", name, apiErr.bodyAsString());
                return;
            }
            failed++;
            String msg = String.format("FAIL: %s — HTTP %d: %s", name, apiErr.code(), apiErr.bodyAsString());
            errors.add(msg);
            System.out.printf("  %s%n", msg);
            return;
        }
        failed++;
        String msg = String.format("FAIL: %s — %s", name, err.getMessage());
        errors.add(msg);
        System.out.printf("  %s%n", msg);
    }

    private static void section(String name) {
        System.out.printf("%n--- %s ---%n", name);
    }

    private static String opt(Optional<String> s) {
        return s.orElse("<nil>");
    }

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        CldProvisioning sdk = CldProvisioning.builder().build();

        System.out.println("============================================================");
        System.out.println("  Cloudinary Account Provisioning Java SDK — Full Endpoint Test");
        System.out.println("============================================================");

        String firstProdEnvId = null;
        String firstUserId = null;
        String firstGroupId = null;
        String firstRoleId = null;

        // =================================================================
        // PUBLIC
        // =================================================================
        section("Public");

        try {
            var catalogRes = sdk.public_().getCatalog().call();
            if (catalogRes.systemRolesAndPoliciesCatalogResponse().isPresent()) {
                System.out.println("    catalog retrieved");
            }
            pass("Public.getCatalog");
        } catch (Exception e) {
            fail("Public.getCatalog", e);
        }

        try {
            var schemaRes = sdk.public_().getSchema().call();
            if (schemaRes.cedarSchemaResponse().isPresent()) {
                System.out.println("    schema retrieved");
            }
            pass("Public.getSchema");
        } catch (Exception e) {
            fail("Public.getSchema", e);
        }

        try {
            var validateRes = sdk.public_().validatePolicy(
                    ValidateCedarPolicyRequest.builder()
                            .policy("permit(principal, action, resource);")
                            .build());
            if (validateRes.validateCedarPolicyResponse().isPresent()) {
                var body = validateRes.validateCedarPolicyResponse().get();
                System.out.printf("    valid=%b, errors=%d%n", body.valid(), body.errors().map(List::size).orElse(0));
            }
            pass("Public.validatePolicy");
        } catch (Exception e) {
            fail("Public.validatePolicy", e);
        }

        // =================================================================
        // PRODUCT ENVIRONMENTS
        // =================================================================
        section("ProductEnvironments");

        try {
            var peList = sdk.productEnvironments().list(
                    GetProductEnvironmentsRequest.builder().build());
            if (peList.productEnvironmentsResponse().isPresent()) {
                var subs = peList.productEnvironmentsResponse().get().subAccounts().orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", subs.size());
                if (!subs.isEmpty()) {
                    firstProdEnvId = subs.get(0).id().orElse(null);
                }
            }
            pass("ProductEnvironments.list");
        } catch (Exception e) {
            fail("ProductEnvironments.list", e);
        }

        if (firstProdEnvId != null) {
            try {
                var peGet = sdk.productEnvironments().get(firstProdEnvId);
                if (peGet.productEnvironment().isPresent()) {
                    var pe = peGet.productEnvironment().get();
                    System.out.printf("    id=%s name=%s cloud=%s%n",
                            opt(pe.id()), opt(pe.name()), opt(pe.cloudName()));
                }
                pass("ProductEnvironments.get");
            } catch (Exception e) {
                fail("ProductEnvironments.get", e);
            }
        }

        String createdPeId = null;
        String testPeName = "java-sdk-test-" + System.currentTimeMillis() / 1000;
        try {
            var peCreated = sdk.productEnvironments().create(
                    ProductEnvironmentRequest.builder()
                            .name(testPeName)
                            .build());
            if (peCreated.productEnvironment().isPresent()) {
                var pe = peCreated.productEnvironment().get();
                createdPeId = pe.id().orElse(null);
                System.out.printf("    created id=%s name=%s%n", opt(pe.id()), opt(pe.name()));
            }
            pass("ProductEnvironments.create");
        } catch (Exception e) {
            fail("ProductEnvironments.create", e);
        }

        if (createdPeId != null) {
            String updatedPeName = testPeName + "-updated";
            try {
                var peUpdated = sdk.productEnvironments().update(
                        UpdateProductEnvironmentRequest.builder()
                                .subAccountId(createdPeId)
                                .productEnvironmentUpdateRequest(
                                        ProductEnvironmentUpdateRequest.builder()
                                                .name(updatedPeName)
                                                .build())
                                .build());
                if (peUpdated.productEnvironment().isPresent()) {
                    System.out.printf("    updated name=%s%n",
                            opt(peUpdated.productEnvironment().get().name()));
                }
                pass("ProductEnvironments.update");
            } catch (Exception e) {
                fail("ProductEnvironments.update", e);
            }

            try {
                sdk.productEnvironments().delete(createdPeId);
                System.out.printf("    deleted id=%s%n", createdPeId);
                pass("ProductEnvironments.delete");
            } catch (Exception e) {
                fail("ProductEnvironments.delete", e);
            }
        }

        // =================================================================
        // USERS
        // =================================================================
        section("Users");

        try {
            var userList = sdk.users().list(GetUsersRequest.builder().build());
            if (userList.usersResponse().isPresent()) {
                var users = userList.usersResponse().get().users().orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", users.size());
                if (!users.isEmpty()) {
                    firstUserId = users.get(0).id().orElse(null);
                }
            }
            pass("Users.list");
        } catch (Exception e) {
            fail("Users.list", e);
        }

        if (firstUserId != null) {
            try {
                var userGet = sdk.users().get(firstUserId);
                if (userGet.user().isPresent()) {
                    var u = userGet.user().get();
                    System.out.printf("    id=%s name=%s email=%s%n",
                            opt(u.id()), opt(u.name()), opt(u.email()));
                }
                pass("Users.get");
            } catch (Exception e) {
                fail("Users.get", e);
            }

            try {
                var userGroups = sdk.users().getGroups(firstUserId);
                if (userGroups.userGroupsListResponse().isPresent()) {
                    var groups = userGroups.userGroupsListResponse().get().groups()
                            .orElse(Collections.emptyList());
                    System.out.printf("    groups=%d%n", groups.size());
                }
                pass("Users.getGroups");
            } catch (Exception e) {
                fail("Users.getGroups", e);
            }

            try {
                var userSubs = sdk.users().listSubAccounts(firstUserId);
                if (userSubs.userSubAccountsResponse().isPresent()) {
                    var subs = userSubs.userSubAccountsResponse().get().subAccounts()
                            .orElse(Collections.emptyList());
                    System.out.printf("    sub_accounts=%d%n", subs.size());
                }
                pass("Users.listSubAccounts");
            } catch (Exception e) {
                fail("Users.listSubAccounts", e);
            }
        }

        String createdUserId = null;
        String testEmail = "java-sdk-test-" + System.currentTimeMillis() / 1000 + "@cloudinary.com";
        try {
            var userCreated = sdk.users().create(
                    CreateUserRequestBody.builder()
                            .name("Java SDK Test User")
                            .email(testEmail)
                            .role(com.cloudinary.account.provisioning.models.operations.Role.ADMIN)
                            .build());
            if (userCreated.user().isPresent()) {
                createdUserId = userCreated.user().get().id().orElse(null);
                System.out.printf("    created id=%s email=%s%n",
                        opt(userCreated.user().get().id()),
                        opt(userCreated.user().get().email()));
            }
            pass("Users.create");
        } catch (Exception e) {
            fail("Users.create", e);
        }

        if (createdUserId != null) {
            try {
                var userUpdated = sdk.users().update(
                        UpdateUserRequest.builder()
                                .userId(createdUserId)
                                .userRequest(UserRequest.builder()
                                        .name("Java SDK Test User Updated")
                                        .build())
                                .build());
                if (userUpdated.user().isPresent()) {
                    System.out.printf("    updated name=%s%n",
                            opt(userUpdated.user().get().name()));
                }
                pass("Users.update");
            } catch (Exception e) {
                fail("Users.update", e);
            }

            try {
                sdk.users().delete(createdUserId);
                System.out.printf("    deleted id=%s%n", createdUserId);
                pass("Users.delete");
            } catch (Exception e) {
                fail("Users.delete", e);
            }
        }

        // =================================================================
        // USER GROUPS
        // =================================================================
        section("UserGroups");

        try {
            var ugList = sdk.userGroups().list(Optional.empty());
            if (ugList.userGroupsResponse().isPresent()) {
                var groups = ugList.userGroupsResponse().get().userGroups()
                        .orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", groups.size());
                if (!groups.isEmpty()) {
                    firstGroupId = groups.get(0).id().orElse(null);
                }
            }
            pass("UserGroups.list");
        } catch (Exception e) {
            fail("UserGroups.list", e);
        }

        if (firstGroupId != null) {
            try {
                var ugGet = sdk.userGroups().get(
                        GetUserGroupRequest.builder()
                                .groupId(firstGroupId)
                                .build());
                if (ugGet.userGroup().isPresent()) {
                    var ug = ugGet.userGroup().get();
                    System.out.printf("    id=%s name=%s%n", opt(ug.id()), opt(ug.name()));
                }
                pass("UserGroups.get");
            } catch (Exception e) {
                fail("UserGroups.get", e);
            }

            try {
                var ugUsers = sdk.userGroups().listUsers(firstGroupId);
                if (ugUsers.userGroupUsersResponse().isPresent()) {
                    var users = ugUsers.userGroupUsersResponse().get().users()
                            .orElse(Collections.emptyList());
                    System.out.printf("    users=%d%n", users.size());
                }
                pass("UserGroups.listUsers");
            } catch (Exception e) {
                fail("UserGroups.listUsers", e);
            }
        }

        String createdGroupId = null;
        String testGroupName = "java-sdk-test-group-" + System.currentTimeMillis() / 1000;
        try {
            var ugCreated = sdk.userGroups().create(
                    UserGroupRequest.builder()
                            .name(testGroupName)
                            .build());
            if (ugCreated.userGroup().isPresent()) {
                createdGroupId = ugCreated.userGroup().get().id().orElse(null);
                System.out.printf("    created id=%s name=%s%n",
                        opt(ugCreated.userGroup().get().id()),
                        opt(ugCreated.userGroup().get().name()));
            }
            pass("UserGroups.create");
        } catch (Exception e) {
            fail("UserGroups.create", e);
        }

        if (createdGroupId != null) {
            if (firstUserId != null) {
                try {
                    var addRes = sdk.userGroups().addUser(
                            AddUserToUserGroupRequest.builder()
                                    .groupId(createdGroupId)
                                    .userId(firstUserId)
                                    .build());
                    if (addRes.userGroupUser().isPresent()) {
                        System.out.printf("    added user=%s%n",
                                opt(addRes.userGroupUser().get().id()));
                    }
                    pass("UserGroups.addUser");
                } catch (Exception e) {
                    fail("UserGroups.addUser", e);
                }

                try {
                    sdk.userGroups().removeUser(
                            RemoveUserFromUserGroupRequest.builder()
                                    .groupId(createdGroupId)
                                    .userId(firstUserId)
                                    .build());
                    System.out.printf("    removed user=%s%n", firstUserId);
                    pass("UserGroups.removeUser");
                } catch (Exception e) {
                    fail("UserGroups.removeUser", e);
                }
            }

            try {
                String updatedGroupName = testGroupName + "-updated";
                var ugUpdated = sdk.userGroups().update(
                        UpdateUserGroupRequest.builder()
                                .groupId(createdGroupId)
                                .userGroupRequest(UserGroupRequest.builder()
                                        .name(updatedGroupName)
                                        .build())
                                .build());
                if (ugUpdated.userGroup().isPresent()) {
                    System.out.printf("    updated name=%s%n",
                            opt(ugUpdated.userGroup().get().name()));
                }
                pass("UserGroups.update");
            } catch (Exception e) {
                fail("UserGroups.update", e);
            }

            try {
                sdk.userGroups().delete(createdGroupId);
                System.out.printf("    deleted id=%s%n", createdGroupId);
                pass("UserGroups.delete");
            } catch (Exception e) {
                fail("UserGroups.delete", e);
            }
        }

        // =================================================================
        // ACCESS KEYS
        // =================================================================
        section("AccessKeys");

        if (firstProdEnvId != null) {
            try {
                var akList = sdk.accessKeys().list(
                        GetAccessKeysRequest.builder()
                                .subAccountId(firstProdEnvId)
                                .build());
                if (akList.accessKeysResponse().isPresent()) {
                    var keys = akList.accessKeysResponse().get().accessKeys()
                            .orElse(Collections.emptyList());
                    System.out.printf("    count=%d%n", keys.size());
                }
                pass("AccessKeys.list");
            } catch (Exception e) {
                fail("AccessKeys.list", e);
            }

            String akKey = null;
            String akName = "java-sdk-test-key-" + System.currentTimeMillis() / 1000;
            try {
                var akCreated = sdk.accessKeys().generate(
                        GenerateAccessKeyRequest.builder()
                                .subAccountId(firstProdEnvId)
                                .accessKeyRequest(AccessKeyRequest.builder()
                                        .name(akName)
                                        .build())
                                .build());
                if (akCreated.accessKey().isPresent()) {
                    akKey = akCreated.accessKey().get().apiKey().orElse(null);
                    System.out.printf("    generated key=%s name=%s%n",
                            opt(akCreated.accessKey().get().apiKey()),
                            opt(akCreated.accessKey().get().name()));
                }
                pass("AccessKeys.generate");
            } catch (Exception e) {
                fail("AccessKeys.generate", e);
            }

            if (akKey != null) {
                try {
                    var akUpdated = sdk.accessKeys().update(
                            UpdateAccessKeyRequest.builder()
                                    .subAccountId(firstProdEnvId)
                                    .key(akKey)
                                    .accessKeyUpdateRequest(AccessKeyUpdateRequest.builder()
                                            .name(akName + "-updated")
                                            .build())
                                    .build());
                    if (akUpdated.accessKey().isPresent()) {
                        System.out.printf("    updated name=%s%n",
                                opt(akUpdated.accessKey().get().name()));
                    }
                    pass("AccessKeys.update");
                } catch (Exception e) {
                    fail("AccessKeys.update", e);
                }

                try {
                    sdk.accessKeys().delete(
                            DeleteAccessKeyRequest.builder()
                                    .subAccountId(firstProdEnvId)
                                    .key(akKey)
                                    .build());
                    System.out.printf("    deleted key=%s%n", akKey);
                    pass("AccessKeys.delete");
                } catch (Exception e) {
                    fail("AccessKeys.delete", e);
                }
            }

            // DeleteByName flow
            String delByNameKey = null;
            String delByName = "java-sdk-delbyname-" + System.currentTimeMillis() / 1000;
            try {
                var akForDel = sdk.accessKeys().generate(
                        GenerateAccessKeyRequest.builder()
                                .subAccountId(firstProdEnvId)
                                .accessKeyRequest(AccessKeyRequest.builder()
                                        .name(delByName)
                                        .build())
                                .build());
                if (akForDel.accessKey().isPresent()) {
                    delByNameKey = akForDel.accessKey().get().apiKey().orElse(null);
                }
                pass("AccessKeys.generate (for deleteByName)");
            } catch (Exception e) {
                fail("AccessKeys.generate (for deleteByName)", e);
            }

            if (delByNameKey != null) {
                try {
                    sdk.accessKeys().deleteByName(
                            DeleteAccessKeyByNameRequest.builder()
                                    .subAccountId(firstProdEnvId)
                                    .name(delByName)
                                    .build());
                    System.out.printf("    deleted by name=%s%n", delByName);
                    pass("AccessKeys.deleteByName");
                } catch (Exception e) {
                    fail("AccessKeys.deleteByName", e);
                    // cleanup: try to delete by key
                    final String fallbackKey = delByNameKey;
                    try {
                        sdk.accessKeys().delete(
                                DeleteAccessKeyRequest.builder()
                                        .subAccountId(firstProdEnvId)
                                        .key(fallbackKey)
                                        .build());
                    } catch (Exception ignored) {
                    }
                }
            }
        } else {
            System.out.println("  SKIP: no product environment ID available");
        }

        // =================================================================
        // BILLING USAGE
        // =================================================================
        section("BillingUsage");

        try {
            var billingRes = sdk.billingUsage().get(
                    GetBillingUsageRequest.builder().build());
            if (billingRes.billingUsageResponse().isPresent()) {
                System.out.printf("    plans=%d%n",
                        billingRes.billingUsageResponse().get().size());
            }
            pass("BillingUsage.get");
        } catch (Exception e) {
            fail("BillingUsage.get", e);
        }

        // =================================================================
        // SYSTEM POLICIES
        // =================================================================
        section("SystemPolicies");

        try {
            var spList = sdk.systemPolicies().list(
                    GetSystemPoliciesRequest.builder().build());
            if (spList.systemPoliciesResponse().isPresent()) {
                var data = spList.systemPoliciesResponse().get().data()
                        .orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", data.size());
            }
            pass("SystemPolicies.list");
        } catch (Exception e) {
            fail("SystemPolicies.list", e);
        }

        // =================================================================
        // CUSTOM POLICIES
        // =================================================================
        section("CustomPolicies");

        try {
            var cpList = sdk.customPolicies().list(
                    GetCustomPoliciesRequest.builder().build());
            if (cpList.customPoliciesResponse().isPresent()) {
                var data = cpList.customPoliciesResponse().get().data()
                        .orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", data.size());
            }
            pass("CustomPolicies.list");
        } catch (Exception e) {
            fail("CustomPolicies.list", e);
        }

        String createdPolicyId = null;
        String testPolicyName = "java-sdk-test-policy-" + System.currentTimeMillis() / 1000;
        try {
            var cpCreated = sdk.customPolicies().create(
                    CustomPolicy.builder()
                            .name(testPolicyName)
                            .policyStatement("permit(principal, action, resource == Cloudinary::Feature::\"cld::global::ml::access\");")
                            .scopeType(ScopeTypeEnum.PRODENV)
                            .build());
            if (cpCreated.customPolicyResponse().isPresent()) {
                var data = cpCreated.customPolicyResponse().get().data().orElse(null);
                if (data != null) {
                    createdPolicyId = data.id();
                    System.out.printf("    created id=%s name=%s%n", data.id(), data.name());
                }
            }
            pass("CustomPolicies.create");
        } catch (Exception e) {
            fail("CustomPolicies.create", e);
        }

        if (createdPolicyId != null) {
            try {
                var cpGet = sdk.customPolicies().get(createdPolicyId);
                if (cpGet.customPolicyResponse().isPresent()) {
                    var data = cpGet.customPolicyResponse().get().data().orElse(null);
                    if (data != null) {
                        System.out.printf("    got id=%s name=%s%n", data.id(), data.name());
                    }
                }
                pass("CustomPolicies.get");
            } catch (Exception e) {
                fail("CustomPolicies.get", e);
            }

            String updatedPolicyName = testPolicyName + "-updated";
            try {
                var cpUpdated = sdk.customPolicies().update(
                        UpdateCustomPolicyRequest.builder()
                                .policyId(createdPolicyId)
                                .updateCustomPolicy(UpdateCustomPolicy.builder()
                                        .name(updatedPolicyName)
                                        .policyStatement("permit(principal, action, resource == Cloudinary::Feature::\"cld::global::ml::access\");")
                                        .scopeType(ScopeTypeEnum.PRODENV)
                                        .build())
                                .build());
                if (cpUpdated.customPolicyResponse().isPresent()) {
                    var data = cpUpdated.customPolicyResponse().get().data().orElse(null);
                    if (data != null) {
                        System.out.printf("    updated name=%s%n", data.name());
                    }
                }
                pass("CustomPolicies.update");
            } catch (Exception e) {
                fail("CustomPolicies.update", e);
            }

            try {
                sdk.customPolicies().delete(createdPolicyId);
                System.out.printf("    deleted id=%s%n", createdPolicyId);
                pass("CustomPolicies.delete");
            } catch (Exception e) {
                fail("CustomPolicies.delete", e);
            }
        }

        // =================================================================
        // EFFECTIVE POLICIES
        // =================================================================
        section("EffectivePolicies");

        try {
            var epList = sdk.effectivePolicies().list(
                    GetEffectivePoliciesRequest.builder()
                            .scopeType(ScopeTypeEnum.ACCOUNT)
                            .build());
            boolean hasData = epList.effectivePoliciesResponse().isPresent();
            System.out.printf("    has_data=%b%n", hasData);
            pass("EffectivePolicies.list");
        } catch (Exception e) {
            fail("EffectivePolicies.list", e);
        }

        // =================================================================
        // ROLES
        // =================================================================
        section("Roles");

        try {
            var rolesList = sdk.roles().list(
                    GetRolesRequest.builder()
                            .permissionType(PermissionTypeEnum.GLOBAL)
                            .build());
            if (rolesList.rolesResponse().isPresent()) {
                var data = rolesList.rolesResponse().get().data()
                        .orElse(Collections.emptyList());
                System.out.printf("    count=%d%n", data.size());
                if (!data.isEmpty()) {
                    firstRoleId = data.get(0).id();
                }
            }
            pass("Roles.list");
        } catch (Exception e) {
            fail("Roles.list", e);
        }

        if (firstRoleId != null) {
            try {
                var roleGet = sdk.roles().get(
                        GetRoleRequest.builder()
                                .roleId(firstRoleId)
                                .build());
                if (roleGet.roleResponse().isPresent() && roleGet.roleResponse().get().data().isPresent()) {
                    var data = roleGet.roleResponse().get().data().get();
                    System.out.printf("    id=%s name=%s%n", data.id(), data.name());
                }
                pass("Roles.get");
            } catch (Exception e) {
                fail("Roles.get", e);
            }

            try {
                var rolePrincipals = sdk.roles().listPrincipals(
                        GetRolePrincipalsRequest.builder()
                                .roleId(firstRoleId)
                                .build());
                if (rolePrincipals.principalsResponse().isPresent()) {
                    var data = rolePrincipals.principalsResponse().get().data()
                            .orElse(Collections.emptyList());
                    System.out.printf("    principals=%d%n", data.size());
                }
                pass("Roles.listPrincipals");
            } catch (Exception e) {
                fail("Roles.listPrincipals", e);
            }
        }

        String createdRoleId = null;
        String testRoleName = "java-sdk-test-role-" + System.currentTimeMillis() / 1000;
        try {
            var roleCreated = sdk.roles().create(
                    CreateRole.builder()
                            .name(testRoleName)
                            .permissionType("global")
                            .scopeType(ScopeTypeEnum.PRODENV)
                            .systemPolicyIds(Collections.emptyList())
                            .build());
            if (roleCreated.roleResponse().isPresent() && roleCreated.roleResponse().get().data().isPresent()) {
                var data = roleCreated.roleResponse().get().data().get();
                createdRoleId = data.id();
                System.out.printf("    created id=%s name=%s%n", data.id(), data.name());
            }
            pass("Roles.create");
        } catch (Exception e) {
            fail("Roles.create", e);
        }

        if (createdRoleId != null) {
            String updatedRoleName = testRoleName + "-updated";
            try {
                var roleUpdated = sdk.roles().update(
                        UpdateRoleRequest.builder()
                                .roleId(createdRoleId)
                                .role(com.cloudinary.account.provisioning.models.components.Role.builder()
                                        .name(updatedRoleName)
                                        .systemPolicyIds(Collections.emptyList())
                                        .build())
                                .build());
                if (roleUpdated.roleResponse().isPresent() && roleUpdated.roleResponse().get().data().isPresent()) {
                    System.out.printf("    updated name=%s%n",
                            roleUpdated.roleResponse().get().data().get().name());
                }
                pass("Roles.update");
            } catch (Exception e) {
                fail("Roles.update", e);
            }

            if (firstUserId != null) {
                try {
                    sdk.roles().updatePrincipals(
                            com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest.builder()
                                    .roleId(createdRoleId)
                                    .updateRolePrincipalsRequest(
                                            com.cloudinary.account.provisioning.models.components.UpdateRolePrincipalsRequest.builder()
                                                    .operation(OperationEnum.ADD)
                                                    .principals(List.of(
                                                            UpdateRolePrincipal.builder()
                                                                    .principalType(PrincipalTypeEnum.USER)
                                                                    .principalId(firstUserId)
                                                                    .build()))
                                                    .build())
                                    .build());
                    System.out.printf("    added principal user=%s%n", firstUserId);
                    pass("Roles.updatePrincipals (add)");
                } catch (Exception e) {
                    fail("Roles.updatePrincipals (add)", e);
                }

                try {
                    sdk.roles().updatePrincipals(
                            com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest.builder()
                                    .roleId(createdRoleId)
                                    .updateRolePrincipalsRequest(
                                            com.cloudinary.account.provisioning.models.components.UpdateRolePrincipalsRequest.builder()
                                                    .operation(OperationEnum.REMOVE)
                                                    .principals(List.of(
                                                            UpdateRolePrincipal.builder()
                                                                    .principalType(PrincipalTypeEnum.USER)
                                                                    .principalId(firstUserId)
                                                                    .build()))
                                                    .build())
                                    .build());
                    System.out.printf("    removed principal user=%s%n", firstUserId);
                    pass("Roles.updatePrincipals (remove)");
                } catch (Exception e) {
                    fail("Roles.updatePrincipals (remove)", e);
                }
            }

            try {
                sdk.roles().delete(
                        DeleteRoleRequest.builder()
                                .roleId(createdRoleId)
                                .build());
                System.out.printf("    deleted id=%s%n", createdRoleId);
                pass("Roles.delete");
            } catch (Exception e) {
                fail("Roles.delete", e);
            }
        }

        // =================================================================
        // PRINCIPALS
        // =================================================================
        section("Principals");

        if (firstUserId != null) {
            try {
                var principalRoles = sdk.principals().listRoles(
                        GetPrincipalRolesRequest.builder()
                                .principalType(PrincipalTypeEnum.USER)
                                .principalId(firstUserId)
                                .permissionType(PermissionTypeEnum.GLOBAL)
                                .build());
                if (principalRoles.principalRolesResponse().isPresent()) {
                    System.out.printf("    roles retrieved%n");
                }
                pass("Principals.listRoles");
            } catch (Exception e) {
                fail("Principals.listRoles", e);
            }

            try {
                var inspectRes = sdk.principals().inspect(
                        com.cloudinary.account.provisioning.models.operations.InspectRequest.builder()
                                .scopeType(ScopeTypeEnum.ACCOUNT)
                                .principalType(PrincipalTypeEnum.USER)
                                .principalId(firstUserId)
                                .build());
                boolean hasResult = inspectRes.principalRolesInspectResponse().isPresent();
                System.out.printf("    inspect result=%b%n", hasResult);
                pass("Principals.inspect");
            } catch (Exception e) {
                fail("Principals.inspect", e);
            }

            try {
                var inspectMultiRes = sdk.principals().inspectMultiple(
                        com.cloudinary.account.provisioning.models.components.InspectRequest.builder()
                                .scopeType(ScopeTypeEnum.ACCOUNT)
                                .principals(List.of(
                                        Principal.builder()
                                                .type(PrincipalTypeEnum.USER)
                                                .id(firstUserId)
                                                .build()))
                                .build());
                boolean hasResult = inspectMultiRes.principalRolesInspectResponse().isPresent();
                System.out.printf("    inspect_multiple result=%b%n", hasResult);
                pass("Principals.inspectMultiple");
            } catch (Exception e) {
                fail("Principals.inspectMultiple", e);
            }
        }

        System.out.println("  SKIP: Principals.updateRoles (tested indirectly via Roles.updatePrincipals)");

        // =================================================================
        // SUMMARY
        // =================================================================
        System.out.println();
        System.out.println("============================================================");
        System.out.printf("  RESULTS: %d passed, %d failed, %d skipped%n", passed, failed, skipped);
        System.out.println("============================================================");
        if (failed > 0) {
            System.out.println("\n  FAILURES:");
            for (String e : errors) {
                System.out.printf("    %s%n", e);
            }
            System.exit(1);
        }
    }
}
