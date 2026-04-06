# CustomPolicies

## Overview

### Available Operations

* [list](#list) - Get custom policies
* [create](#create) - Create custom policy
* [get](#get) - Get custom policy
* [update](#update) - Update custom policy
* [delete](#delete) - Delete custom policy

## list

Retrieve all custom permission policies defined for a specific scope. The scope can be at the account level or within a specific product environment.

**Notes:**
  * If `scope_type` isn't specified as `prodenv`, the account-level policies will be returned.

  * If `scope_type` is specified as `prodenv`, `scope_id` is required.


### Example Usage

<!-- UsageSnippet language="java" operationID="getCustomPolicies" method="get" path="/v2/accounts/{account_id}/permissions/policies/custom" example="CustomPoliciesExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.ScopeTypeEnum;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetCustomPoliciesRequest;
import com.cloudinary.account.provisioning.models.operations.GetCustomPoliciesResponse;
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

        GetCustomPoliciesRequest req = GetCustomPoliciesRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .build();

        GetCustomPoliciesResponse res = sdk.customPolicies().list()
                .request(req)
                .call();

        if (res.customPoliciesResponse().isPresent()) {
            System.out.println(res.customPoliciesResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetCustomPoliciesRequest](../../models/operations/GetCustomPoliciesRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GetCustomPoliciesResponse](../../models/operations/GetCustomPoliciesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403                               | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## create

Create a new custom policy with a statement defined in Cedar. This policy specifies permissions for a principal, allowing a specific action on a designated resource, within a particular scope.

Learn more about creating a new custom policy
<https://cloudinary.com/documentation/permissions_api_guide#create_a_policy_statement>

### Example Usage: cedarErrorExample

<!-- UsageSnippet language="java" operationID="createCustomPolicy" method="post" path="/v2/accounts/{account_id}/permissions/policies/custom" example="cedarErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateCustomPolicyResponse;
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

        CustomPolicy req = CustomPolicy.builder()
                .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Read access to Clothing folder")
                .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                .scopeId("975l29lz02jt0836fhwi")
                .build();

        CreateCustomPolicyResponse res = sdk.customPolicies().create()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: createCustomPolicyExample

<!-- UsageSnippet language="java" operationID="createCustomPolicy" method="post" path="/v2/accounts/{account_id}/permissions/policies/custom" example="createCustomPolicyExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateCustomPolicyResponse;
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

        CustomPolicy req = CustomPolicy.builder()
                .policyStatement("permit(principal == Cloudinary::APIKey::\"1234\",action==Cloudinary::Action::\"read\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\"asdfjkl12347890\")} ;")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Read access to Clothing folder")
                .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                .scopeId("975l29lz02jt0836fhwi")
                .build();

        CreateCustomPolicyResponse res = sdk.customPolicies().create()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: createPolicyResponse

<!-- UsageSnippet language="java" operationID="createCustomPolicy" method="post" path="/v2/accounts/{account_id}/permissions/policies/custom" example="createPolicyResponse" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateCustomPolicyResponse;
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

        CustomPolicy req = CustomPolicy.builder()
                .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Read access to Clothing folder")
                .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                .scopeId("975l29lz02jt0836fhwi")
                .build();

        CreateCustomPolicyResponse res = sdk.customPolicies().create()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: invalidFieldErrorExample

<!-- UsageSnippet language="java" operationID="createCustomPolicy" method="post" path="/v2/accounts/{account_id}/permissions/policies/custom" example="invalidFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateCustomPolicyResponse;
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

        CustomPolicy req = CustomPolicy.builder()
                .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Read access to Clothing folder")
                .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                .scopeId("975l29lz02jt0836fhwi")
                .build();

        CreateCustomPolicyResponse res = sdk.customPolicies().create()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: missingFieldsErrorExample

<!-- UsageSnippet language="java" operationID="createCustomPolicy" method="post" path="/v2/accounts/{account_id}/permissions/policies/custom" example="missingFieldsErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateCustomPolicyResponse;
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

        CustomPolicy req = CustomPolicy.builder()
                .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                .scopeType(ScopeTypeEnum.PRODENV)
                .name("Read access to Clothing folder")
                .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                .scopeId("975l29lz02jt0836fhwi")
                .build();

        CreateCustomPolicyResponse res = sdk.customPolicies().create()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                           | Type                                                | Required                                            | Description                                         |
| --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| `request`                                           | [CustomPolicy](../../models/shared/CustomPolicy.md) | :heavy_check_mark:                                  | The request object to use for the request.          |

### Response

**[CreateCustomPolicyResponse](../../models/operations/CreateCustomPolicyResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 409                     | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## get

Get a specific custom policy.

### Example Usage

<!-- UsageSnippet language="java" operationID="getCustomPolicy" method="get" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="CustomPolicyExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetCustomPolicyResponse;
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

        GetCustomPolicyResponse res = sdk.customPolicies().get()
                .policyId("<id>")
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `policyId`                                            | *String*                                              | :heavy_check_mark:                                    | A unique identifier for the custom permission policy. |

### Response

**[GetCustomPolicyResponse](../../models/operations/GetCustomPolicyResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403, 404                          | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## update

Update a specific custom policy by providing the entire policy entity in the request body. Ensure the new `policy_statement` includes modifications. Existing permissions will be replaced with the new data.

*Note:* Updating a policy with an identical `policy_statement` will trigger a 409 error.


### Example Usage: cedarErrorExample

<!-- UsageSnippet language="java" operationID="updateCustomPolicy" method="put" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="cedarErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyResponse;
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

        UpdateCustomPolicyRequest req = UpdateCustomPolicyRequest.builder()
                .policyId("<id>")
                .updateCustomPolicy(UpdateCustomPolicy.builder()
                    .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                    .scopeType(ScopeTypeEnum.PRODENV)
                    .name("Read access to Clothing folder")
                    .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                    .scopeId("975l29lz02jt0836fhwi")
                    .build())
                .build();

        UpdateCustomPolicyResponse res = sdk.customPolicies().update()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: invalidFieldErrorExample

<!-- UsageSnippet language="java" operationID="updateCustomPolicy" method="put" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="invalidFieldErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyResponse;
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

        UpdateCustomPolicyRequest req = UpdateCustomPolicyRequest.builder()
                .policyId("<id>")
                .updateCustomPolicy(UpdateCustomPolicy.builder()
                    .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                    .scopeType(ScopeTypeEnum.PRODENV)
                    .name("Read access to Clothing folder")
                    .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                    .scopeId("975l29lz02jt0836fhwi")
                    .build())
                .build();

        UpdateCustomPolicyResponse res = sdk.customPolicies().update()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: missingFieldsUpdateErrorExample

<!-- UsageSnippet language="java" operationID="updateCustomPolicy" method="put" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="missingFieldsUpdateErrorExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyResponse;
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

        UpdateCustomPolicyRequest req = UpdateCustomPolicyRequest.builder()
                .policyId("<id>")
                .updateCustomPolicy(UpdateCustomPolicy.builder()
                    .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                    .scopeType(ScopeTypeEnum.PRODENV)
                    .name("Read access to Clothing folder")
                    .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                    .scopeId("975l29lz02jt0836fhwi")
                    .build())
                .build();

        UpdateCustomPolicyResponse res = sdk.customPolicies().update()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: updateCustomPolicyExample

<!-- UsageSnippet language="java" operationID="updateCustomPolicy" method="put" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="updateCustomPolicyExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyResponse;
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

        UpdateCustomPolicyRequest req = UpdateCustomPolicyRequest.builder()
                .policyId("<id>")
                .updateCustomPolicy(UpdateCustomPolicy.builder()
                    .policyStatement("permit(principal == Cloudinary::APIKey::\"1234\",action==Cloudinary::Action::\"read\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\"asdfjkl12347890\")} ;")
                    .scopeType(ScopeTypeEnum.PRODENV)
                    .name("Read access to Accessories folder")
                    .description("Permit read access to the Accessories folder with external ID asdfjkl12347890.")
                    .scopeId("975l29lz02jt0836fhwi")
                    .build())
                .build();

        UpdateCustomPolicyResponse res = sdk.customPolicies().update()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```
### Example Usage: updatePolicyResponse

<!-- UsageSnippet language="java" operationID="updateCustomPolicy" method="put" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" example="updatePolicyResponse" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateCustomPolicyResponse;
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

        UpdateCustomPolicyRequest req = UpdateCustomPolicyRequest.builder()
                .policyId("<id>")
                .updateCustomPolicy(UpdateCustomPolicy.builder()
                    .policyStatement("permit(principal == Cloudinary::APIKey::\\\"1234\\\",action==Cloudinary::Action::\\\"read\\\",resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\\\"asdfjkl12347890\\\")} ;\n")
                    .scopeType(ScopeTypeEnum.PRODENV)
                    .name("Read access to Clothing folder")
                    .description("Permit read access to the Clothing folder with external ID asdfjkl12347890.")
                    .scopeId("975l29lz02jt0836fhwi")
                    .build())
                .build();

        UpdateCustomPolicyResponse res = sdk.customPolicies().update()
                .request(req)
                .call();

        if (res.customPolicyResponse().isPresent()) {
            System.out.println(res.customPolicyResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [UpdateCustomPolicyRequest](../../models/operations/UpdateCustomPolicyRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[UpdateCustomPolicyResponse](../../models/operations/UpdateCustomPolicyResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 404, 409                | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Delete a specific custom policy.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteCustomPolicy" method="delete" path="/v2/accounts/{account_id}/permissions/policies/custom/{policy_id}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteCustomPolicyResponse;
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

        DeleteCustomPolicyResponse res = sdk.customPolicies().delete()
                .policyId("<id>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                             | Type                                                  | Required                                              | Description                                           |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| `policyId`                                            | *String*                                              | :heavy_check_mark:                                    | A unique identifier for the custom permission policy. |

### Response

**[DeleteCustomPolicyResponse](../../models/operations/DeleteCustomPolicyResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403, 404                          | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |