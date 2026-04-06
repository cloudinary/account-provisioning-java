# Public

## Overview

View shared Permissions system utilities, including the system roles and policies catalog, Cedar policy validation, and the Cedar schema. These endpoints are publicly accessible and don't require authentication.


### Available Operations

* [getCatalog](#getcatalog) - Get system roles and policies catalog
* [validatePolicy](#validatepolicy) - Validate a Cedar policy
* [getSchema](#getschema) - Get Cedar schema

## getCatalog

Retrieves the catalog of predefined system roles and their associated policies.

### Example Usage

<!-- UsageSnippet language="java" operationID="getSystemRolesAndPoliciesCatalog" method="get" path="/v2/accounts/permissions/public/catalog" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.operations.GetSystemRolesAndPoliciesCatalogResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetSystemRolesAndPoliciesCatalogResponse res = sdk.public_().getCatalog()
                .call();

        if (res.systemRolesAndPoliciesCatalogResponse().isPresent()) {
            System.out.println(res.systemRolesAndPoliciesCatalogResponse().get());
        }
    }
}
```

### Response

**[GetSystemRolesAndPoliciesCatalogResponse](../../models/operations/GetSystemRolesAndPoliciesCatalogResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/SDKException | 4XX, 5XX                   | \*/\*                      |

## validatePolicy

Validate a Cedar policy

### Example Usage

<!-- UsageSnippet language="java" operationID="validateCedarPolicy" method="post" path="/v2/accounts/permissions/public/validate" example="ValidateCedarPolicyResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.components.ValidateCedarPolicyRequest;
import com.cloudinary.account.provisioning.models.operations.ValidateCedarPolicyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        ValidateCedarPolicyRequest req = ValidateCedarPolicyRequest.builder()
                .policy("permit(principal == Cloudinary::APIKy::\"1234\", action == Cloudinary::Action::\"read\", resource is Cloudinary::Folder ) when {resource.ancestor_ids.contains(\"asdfjkl12347890\")} ;")
                .build();

        ValidateCedarPolicyResponse res = sdk.public_().validatePolicy()
                .request(req)
                .call();

        if (res.validateCedarPolicyResponse().isPresent()) {
            System.out.println(res.validateCedarPolicyResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [ValidateCedarPolicyRequest](../../models/shared/ValidateCedarPolicyRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[ValidateCedarPolicyResponse](../../models/operations/ValidateCedarPolicyResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/SDKException | 4XX, 5XX                   | \*/\*                      |

## getSchema

Get Cedar schema

### Example Usage

<!-- UsageSnippet language="java" operationID="getCedarSchema" method="get" path="/v2/accounts/permissions/public/schema" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.operations.GetCedarSchemaResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetCedarSchemaResponse res = sdk.public_().getSchema()
                .call();

        if (res.cedarSchemaResponse().isPresent()) {
            System.out.println(res.cedarSchemaResponse().get());
        }
    }
}
```

### Response

**[GetCedarSchemaResponse](../../models/operations/GetCedarSchemaResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/SDKException | 4XX, 5XX                   | \*/\*                      |