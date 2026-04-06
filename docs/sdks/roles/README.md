# Roles

## Overview

All roles include one or more predefined **system policies**, and can be applied to principals to enforce these policies.

You can **manage custom roles**, where you select the system policies.

You can **view system roles**, which contain a fixed set of system policies and are provided by Cloudinary.


### Available Operations

* [list](#list) - Get roles
* [create](#create) - Create custom role
* [get](#get) - Get role
* [update](#update) - Update custom role
* [delete](#delete) - Delete custom role
* [listPrincipals](#listprincipals) - Get a role's principals
* [updatePrincipals](#updateprincipals) - Assign principals to a role

## list

Retrieve all system and custom roles of a specific `permission_type` (global or content-specific). Optionally filter by `scope_type`, `management_type`, and `policy_parameters`.


### Example Usage

<!-- UsageSnippet language="java" operationID="getRoles" method="get" path="/v2/accounts/{account_id}/permissions/roles" example="GetRolesExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetRolesRequest;
import com.cloudinary.account.provisioning.models.operations.GetRolesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetRolesRequest req = GetRolesRequest.builder()
                .permissionType(PermissionTypeEnum.GLOBAL)
                .scopeType(ScopeTypeEnum.PRODENV)
                .managementType(ManagementTypeEnum.SYSTEM)
                .build();

        GetRolesResponse res = sdk.roles().list()
                .request(req)
                .call();

        if (res.rolesResponse().isPresent()) {
            System.out.println(res.rolesResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [GetRolesRequest](../../models/operations/GetRolesRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[GetRolesResponse](../../models/operations/GetRolesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403                               | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create a new custom role.

### Example Usage: createAcctRoleExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createAcctRoleExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.ACCOUNT)
                .name("Sensitive account details manager")
                .id("sensitive_account_details_manager_88825hl")
                .description("Responsible for managing users and account security.")
                .systemPolicyIds(List.of(
                    "cld::global::users_and_groups::manage",
                    "cld::policy::global::account_security::manage"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: createAcctRoleResponseExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createAcctRoleResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing upload presets and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: createContentRoleExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createContentRoleExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("content")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Marketing content contributor")
                .id("marketing_content_contributor_1357fhe")
                .description("View all assets in selected folders and contribute to those folders, without permission to download.")
                .systemPolicyIds(List.of(
                    "cld::policy::content::folder::view_download",
                    "cld::policy::content::folder::add_assets"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: createContentRoleResponseExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createContentRoleResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing upload presets and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: createGlobalRoleExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createGlobalRoleExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing uploads and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: createGlobalRoleResponseExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="createGlobalRoleResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing upload presets and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: invalidFieldErrorExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="invalidFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing upload presets and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: missingFieldsErrorExample

<!-- UsageSnippet language="java" operationID="createRole" method="post" path="/v2/accounts/{account_id}/permissions/roles" example="missingFieldsErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateRole req = CreateRole.builder()
                .permissionType("global")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Upload manager")
                .id("upload_manager_12334565")
                .description("Responsible for managing upload presets and uploading new assets.")
                .systemPolicyIds(List.of(
                    "cld::policy::global::upload_presets::manage",
                    "cld::policy::global::folder_and_asset_management::create_asset"))
                .build();

        CreateRoleResponse res = sdk.roles().create()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `request`                                       | [CreateRole](../../models/shared/CreateRole.md) | :heavy_check_mark:                              | The request object to use for the request.      |

### Response

**[CreateRoleResponse](../../models/operations/CreateRoleResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 409                     | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## get

Get a specific system or custom role.

### Example Usage

<!-- UsageSnippet language="java" operationID="getRole" method="get" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" example="GetRoleExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetRoleRequest;
import com.cloudinary.account.provisioning.models.operations.GetRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetRoleRequest req = GetRoleRequest.builder()
                .roleId("<id>")
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        GetRoleResponse res = sdk.roles().get()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [GetRoleRequest](../../models/operations/GetRoleRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[GetRoleResponse](../../models/operations/GetRoleResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403, 404                          | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update a specific custom role by providing all relevant details, including those you want to keep as-is.

*Note:* Updating a role with a name that already exists will trigger a 409 error.


### Example Usage: invalidPolicyIDFieldErrorExample

<!-- UsageSnippet language="java" operationID="updateRole" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" example="invalidPolicyIDFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Role;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateRoleRequest req = UpdateRoleRequest.builder()
                .roleId("<id>")
                .role(Role.builder()
                    .name("Upload manager")
                    .description("Responsible for managing upload presets and uploading new assets.")
                    .systemPolicyIds(List.of(
                        "cld::policy::global::upload_presets::manage",
                        "cld::policy::global::folder_and_asset_management::create_asset"))
                    .build())
                .build();

        UpdateRoleResponse res = sdk.roles().update()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: missingFieldsErrorExample

<!-- UsageSnippet language="java" operationID="updateRole" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" example="missingFieldsErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Role;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateRoleRequest req = UpdateRoleRequest.builder()
                .roleId("<id>")
                .role(Role.builder()
                    .name("Upload manager")
                    .description("Responsible for managing upload presets and uploading new assets.")
                    .systemPolicyIds(List.of(
                        "cld::policy::global::upload_presets::manage",
                        "cld::policy::global::folder_and_asset_management::create_asset"))
                    .build())
                .build();

        UpdateRoleResponse res = sdk.roles().update()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: updatePolicyResponse

<!-- UsageSnippet language="java" operationID="updateRole" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" example="updatePolicyResponse" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Role;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateRoleRequest req = UpdateRoleRequest.builder()
                .roleId("<id>")
                .role(Role.builder()
                    .name("Upload manager")
                    .description("Responsible for managing upload presets and uploading new assets.")
                    .systemPolicyIds(List.of(
                        "cld::policy::global::upload_presets::manage",
                        "cld::policy::global::folder_and_asset_management::create_asset"))
                    .build())
                .build();

        UpdateRoleResponse res = sdk.roles().update()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```
### Example Usage: updateRoleExample

<!-- UsageSnippet language="java" operationID="updateRole" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" example="updateRoleExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Role;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateRoleResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateRoleRequest req = UpdateRoleRequest.builder()
                .roleId("<id>")
                .role(Role.builder()
                    .name("Upload manager")
                    .description("Responsible for managing uploads and uploading new assets.")
                    .systemPolicyIds(List.of(
                        "cld::policy::global::upload_presets::manage",
                        "cld::policy::global::folder_and_asset_management::create_asset"))
                    .build())
                .build();

        UpdateRoleResponse res = sdk.roles().update()
                .request(req)
                .call();

        if (res.roleResponse().isPresent()) {
            System.out.println(res.roleResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [UpdateRoleRequest](../../models/operations/UpdateRoleRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[UpdateRoleResponse](../../models/operations/UpdateRoleResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 404, 409                | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a specific custom role.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteRole" method="delete" path="/v2/accounts/{account_id}/permissions/roles/{role_id}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteRoleRequest;
import com.cloudinary.account.provisioning.models.operations.DeleteRoleResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        DeleteRoleRequest req = DeleteRoleRequest.builder()
                .roleId("<id>")
                .build();

        DeleteRoleResponse res = sdk.roles().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [DeleteRoleRequest](../../models/operations/DeleteRoleRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[DeleteRoleResponse](../../models/operations/DeleteRoleResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403, 404                          | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## listPrincipals

Retrieve all principals associated with a specific role.

### Example Usage: GetRolePrincipalsExample

<!-- UsageSnippet language="java" operationID="getRolePrincipals" method="get" path="/v2/accounts/{account_id}/permissions/roles/{role_id}/principals" example="GetRolePrincipalsExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.ScopeTypeEnum;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetRolePrincipalsRequest;
import com.cloudinary.account.provisioning.models.operations.GetRolePrincipalsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetRolePrincipalsRequest req = GetRolePrincipalsRequest.builder()
                .roleId("<id>")
                .scopeType(ScopeTypeEnum.PRODENV)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        GetRolePrincipalsResponse res = sdk.roles().listPrincipals()
                .request(req)
                .call();

        if (res.principalsResponse().isPresent()) {
            System.out.println(res.principalsResponse().get());
        }
    }
}
```
### Example Usage: GetRolePrincipalsWithParamKeyValueExample

<!-- UsageSnippet language="java" operationID="getRolePrincipals" method="get" path="/v2/accounts/{account_id}/permissions/roles/{role_id}/principals" example="GetRolePrincipalsWithParamKeyValueExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.ScopeTypeEnum;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetRolePrincipalsRequest;
import com.cloudinary.account.provisioning.models.operations.GetRolePrincipalsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetRolePrincipalsRequest req = GetRolePrincipalsRequest.builder()
                .roleId("<id>")
                .scopeType(ScopeTypeEnum.PRODENV)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        GetRolePrincipalsResponse res = sdk.roles().listPrincipals()
                .request(req)
                .call();

        if (res.principalsResponse().isPresent()) {
            System.out.println(res.principalsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetRolePrincipalsRequest](../../models/operations/GetRolePrincipalsRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GetRolePrincipalsResponse](../../models/operations/GetRolePrincipalsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403, 404                          | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## updatePrincipals

Add or remove principals associated with a role.

### Example Usage: invalidOperationFieldErrorExample

<!-- UsageSnippet language="java" operationID="updateRolePrincipals" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}/principals" example="invalidOperationFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest req = com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest.builder()
                .roleId("<id>")
                .updateRolePrincipalsRequest(UpdateRolePrincipalsRequest.builder()
                    .operation(OperationEnum.ADD)
                    .principals(List.of(
                        UpdateRolePrincipal.builder()
                            .principalType(PrincipalTypeEnum.USER)
                            .principalId("1234abc")
                            .scopeId("975l29lz02jt0836fhwi")
                            .policyParameters(UpdateRolePrincipalPolicyParameters.builder()
                                .build())
                            .build()))
                    .build())
                .build();

        UpdateRolePrincipalsResponse res = sdk.roles().updatePrincipals()
                .request(req)
                .call();

        // handle response
    }
}
```
### Example Usage: missingFieldsErrorExample

<!-- UsageSnippet language="java" operationID="updateRolePrincipals" method="put" path="/v2/accounts/{account_id}/permissions/roles/{role_id}/principals" example="missingFieldsErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest req = com.cloudinary.account.provisioning.models.operations.UpdateRolePrincipalsRequest.builder()
                .roleId("<id>")
                .updateRolePrincipalsRequest(UpdateRolePrincipalsRequest.builder()
                    .operation(OperationEnum.ADD)
                    .principals(List.of(
                        UpdateRolePrincipal.builder()
                            .principalType(PrincipalTypeEnum.USER)
                            .principalId("1234abc")
                            .scopeId("975l29lz02jt0836fhwi")
                            .policyParameters(UpdateRolePrincipalPolicyParameters.builder()
                                .build())
                            .build()))
                    .build())
                .build();

        UpdateRolePrincipalsResponse res = sdk.roles().updatePrincipals()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [UpdateRolePrincipalsRequest](../../models/operations/UpdateRolePrincipalsRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[UpdateRolePrincipalsResponse](../../models/operations/UpdateRolePrincipalsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 404                     | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |