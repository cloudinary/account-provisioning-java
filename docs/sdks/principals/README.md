# Principals

## Overview

View roles associated with a specified principal, and add or remove a role associated with a principal.


### Available Operations

* [listRoles](#listroles) - Get a principal's roles
* [updateRoles](#updateroles) - Assign roles to a principal
* [inspect](#inspect) - Inspect
* [inspectMultiple](#inspectmultiple) - Inspect multiple

## listRoles

Retrieve all roles associated with a specific principal.

### Example Usage: GetPrincipalRolesExample

<!-- UsageSnippet language="java" operationID="getPrincipalRoles" method="get" path="/v2/accounts/{account_id}/permissions/principal_roles" example="GetPrincipalRolesExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetPrincipalRolesRequest;
import com.cloudinary.account.provisioning.models.operations.GetPrincipalRolesResponse;
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

        GetPrincipalRolesRequest req = GetPrincipalRolesRequest.builder()
                .principalType(PrincipalTypeEnum.USER)
                .principalId("<id>")
                .permissionType(PermissionTypeEnum.GLOBAL)
                .managementType(ManagementTypeEnum.SYSTEM)
                .scopeType(ScopeTypeEnum.PRODENV)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        GetPrincipalRolesResponse res = sdk.principals().listRoles()
                .request(req)
                .call();

        if (res.principalRolesResponse().isPresent()) {
            System.out.println(res.principalRolesResponse().get());
        }
    }
}
```
### Example Usage: GetPrincipalRolesWithParamKeyValueExample

<!-- UsageSnippet language="java" operationID="getPrincipalRoles" method="get" path="/v2/accounts/{account_id}/permissions/principal_roles" example="GetPrincipalRolesWithParamKeyValueExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetPrincipalRolesRequest;
import com.cloudinary.account.provisioning.models.operations.GetPrincipalRolesResponse;
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

        GetPrincipalRolesRequest req = GetPrincipalRolesRequest.builder()
                .principalType(PrincipalTypeEnum.USER)
                .principalId("<id>")
                .permissionType(PermissionTypeEnum.GLOBAL)
                .managementType(ManagementTypeEnum.SYSTEM)
                .scopeType(ScopeTypeEnum.PRODENV)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        GetPrincipalRolesResponse res = sdk.principals().listRoles()
                .request(req)
                .call();

        if (res.principalRolesResponse().isPresent()) {
            System.out.println(res.principalRolesResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetPrincipalRolesRequest](../../models/operations/GetPrincipalRolesRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GetPrincipalRolesResponse](../../models/operations/GetPrincipalRolesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 404                          | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## updateRoles

Add or remove roles associated with a principal.

### Example Usage: InvalidOperationFieldErrorExample

<!-- UsageSnippet language="java" operationID="updatePrincipalRoles" method="put" path="/v2/accounts/{account_id}/permissions/principal_roles" example="InvalidOperationFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdatePrincipalRolesResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdatePrincipalRolesRequest req = UpdatePrincipalRolesRequest.builder()
                .operation(OperationEnum.ADD)
                .principal(Principal.builder()
                    .type(PrincipalTypeEnum.USER)
                    .id("1234abc")
                    .build())
                .roles(List.of(
                    RoleToManage.builder()
                        .id("marketing_content_contributor_1357fhe")
                        .scopeId("975l29lz02jt0836fhwi")
                        .policyParameters(Map.ofEntries(
                        ))
                        .build()))
                .build();

        UpdatePrincipalRolesResponse res = sdk.principals().updateRoles()
                .request(req)
                .call();

        // handle response
    }
}
```
### Example Usage: missingPrincipalFieldsErrorExample

<!-- UsageSnippet language="java" operationID="updatePrincipalRoles" method="put" path="/v2/accounts/{account_id}/permissions/principal_roles" example="missingPrincipalFieldsErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdatePrincipalRolesResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdatePrincipalRolesRequest req = UpdatePrincipalRolesRequest.builder()
                .operation(OperationEnum.ADD)
                .principal(Principal.builder()
                    .type(PrincipalTypeEnum.USER)
                    .id("1234abc")
                    .build())
                .roles(List.of(
                    RoleToManage.builder()
                        .id("marketing_content_contributor_1357fhe")
                        .scopeId("975l29lz02jt0836fhwi")
                        .policyParameters(Map.ofEntries(
                        ))
                        .build()))
                .build();

        UpdatePrincipalRolesResponse res = sdk.principals().updateRoles()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [UpdatePrincipalRolesRequest](../../models/shared/UpdatePrincipalRolesRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[UpdatePrincipalRolesResponse](../../models/operations/UpdatePrincipalRolesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 404                     | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## inspect

Retrieves principals and their assigned roles within a specified scope, based on query filters.

Use this endpoint to determine which users, groups, API keys, or account API keys have roles applied at:
* A specific `scope_type` ("account" or "prodenv")
* A specific `scope_id` (for product environments)
* Optional content filters (such as `folder_id`, `collection_id`, or `param_key` / `param_value`)
* Optional `principal_type` (and `principal_id`)

The response includes all principals that match the specified filters, along with the roles applied to them within that context.

This endpoint is useful when you want to:
* Audit who has access within a given scope
* Identify all principals assigned to roles for a specific folder, collection, asset, or product environment
* Retrieve role assignments dynamically based on filtering criteria


### Example Usage: InspectExampleAllFolders

<!-- UsageSnippet language="java" operationID="inspect" method="get" path="/v2/accounts/{account_id}/permissions/principal_roles/inspect" example="InspectExampleAllFolders" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.InspectRequest;
import com.cloudinary.account.provisioning.models.operations.InspectResponse;
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

        InspectRequest req = InspectRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principalType(PrincipalTypeEnum.USER)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        InspectResponse res = sdk.principals().inspect()
                .request(req)
                .call();

        if (res.principalRolesInspectResponse().isPresent()) {
            System.out.println(res.principalRolesInspectResponse().get());
        }
    }
}
```
### Example Usage: InspectExampleFolder

<!-- UsageSnippet language="java" operationID="inspect" method="get" path="/v2/accounts/{account_id}/permissions/principal_roles/inspect" example="InspectExampleFolder" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.InspectRequest;
import com.cloudinary.account.provisioning.models.operations.InspectResponse;
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

        InspectRequest req = InspectRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principalType(PrincipalTypeEnum.USER)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        InspectResponse res = sdk.principals().inspect()
                .request(req)
                .call();

        if (res.principalRolesInspectResponse().isPresent()) {
            System.out.println(res.principalRolesInspectResponse().get());
        }
    }
}
```
### Example Usage: InspectExampleProdEnv

<!-- UsageSnippet language="java" operationID="inspect" method="get" path="/v2/accounts/{account_id}/permissions/principal_roles/inspect" example="InspectExampleProdEnv" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.InspectRequest;
import com.cloudinary.account.provisioning.models.operations.InspectResponse;
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

        InspectRequest req = InspectRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principalType(PrincipalTypeEnum.USER)
                .paramKey(List.of(
                    "folder_id"))
                .paramValue(List.of(
                    "asdfjkl12347890"))
                .build();

        InspectResponse res = sdk.principals().inspect()
                .request(req)
                .call();

        if (res.principalRolesInspectResponse().isPresent()) {
            System.out.println(res.principalRolesInspectResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [InspectRequest](../../models/operations/InspectRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[InspectResponse](../../models/operations/InspectResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 404                          | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## inspectMultiple

Retrieves role assignments for a specified list of principals within a shared scope and optional policy parameters.

Use this endpoint when you already know which principals you want to evaluate and want to check their role assignments in a single request.

In this request:
* You explicitly provide the `principals` array in the request body.
* All principals are evaluated against the same `scope_type`, optional `scope_id`, and optional `policy_parameters`.
* Unlike `Inspect`, this endpoint doesn't search for matching principals. It evaluates only the principals you provide.

This endpoint is useful for:
* Verify role assignments for multiple specified principals at once
* Comparing role assignments across specific users, groups, or keys
* Reducing multiple per-principal `Inspect` calls into a single request


### Example Usage: InspectMultipleRequestExample

<!-- UsageSnippet language="java" operationID="inspectMultiple" method="post" path="/v2/accounts/{account_id}/permissions/principal_roles/inspect" example="InspectMultipleRequestExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.InspectMultipleResponse;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws PermissionsErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        InspectRequest req = InspectRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principals(List.of(
                    Principal.builder()
                        .type(PrincipalTypeEnum.USER)
                        .id("1234abc")
                        .build(),
                    Principal.builder()
                        .type(PrincipalTypeEnum.USER)
                        .id("4567xyz")
                        .build(),
                    Principal.builder()
                        .type(PrincipalTypeEnum.API_KEY)
                        .id("a382ltieo893jhioqpg8urp")
                        .build()))
                .scopeId("975l29lz02jt0836fhwi")
                .policyParameters(Map.ofEntries(
                    Map.entry("folder_id", "asdfjkl12347890")))
                .build();

        InspectMultipleResponse res = sdk.principals().inspectMultiple()
                .request(req)
                .call();

        if (res.principalRolesInspectResponse().isPresent()) {
            System.out.println(res.principalRolesInspectResponse().get());
        }
    }
}
```
### Example Usage: InspectMultipleResponseExample

<!-- UsageSnippet language="java" operationID="inspectMultiple" method="post" path="/v2/accounts/{account_id}/permissions/principal_roles/inspect" example="InspectMultipleResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.InspectMultipleResponse;
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

        InspectRequest req = InspectRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principals(List.of(
                    Principal.builder()
                        .type(PrincipalTypeEnum.USER)
                        .id("1234abc")
                        .build()))
                .build();

        InspectMultipleResponse res = sdk.principals().inspectMultiple()
                .request(req)
                .call();

        if (res.principalRolesInspectResponse().isPresent()) {
            System.out.println(res.principalRolesInspectResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                               | Type                                                    | Required                                                | Description                                             |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| `request`                                               | [InspectRequest](../../models/shared/InspectRequest.md) | :heavy_check_mark:                                      | The request object to use for the request.              |

### Response

**[InspectMultipleResponse](../../models/operations/InspectMultipleResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 404                          | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |