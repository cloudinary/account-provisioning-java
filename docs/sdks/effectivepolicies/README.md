# EffectivePolicies

## Overview

### Available Operations

* [list](#list) - Get effective policies

## list

Retrieve all roles (along with their system permission policies) associated with principals, and all custom permission policies directly added to principals, all within a specified scope.

Optionally specify a principal to only include roles and policies associated with that principal.


### Example Usage

<!-- UsageSnippet language="java" operationID="getEffectivePolicies" method="get" path="/v2/accounts/{account_id}/permissions/policies/effective" example="EffectivePoliciesExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetEffectivePoliciesRequest;
import com.cloudinary.account.provisioning.models.operations.GetEffectivePoliciesResponse;
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

        GetEffectivePoliciesRequest req = GetEffectivePoliciesRequest.builder()
                .scopeType(ScopeTypeEnum.PRODENV)
                .principalType(PrincipalTypeEnum.USER)
                .build();

        GetEffectivePoliciesResponse res = sdk.effectivePolicies().list()
                .request(req)
                .call();

        if (res.effectivePoliciesResponse().isPresent()) {
            System.out.println(res.effectivePoliciesResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [GetEffectivePoliciesRequest](../../models/operations/GetEffectivePoliciesRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[GetEffectivePoliciesResponse](../../models/operations/GetEffectivePoliciesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 400, 401, 403, 404                     | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |