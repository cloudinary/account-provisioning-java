# SystemPolicies

## Overview

### Available Operations

* [list](#list) - Get system policies

## list

Retrieve all system-defined permission policies. Optionally filter the results by `scope_type` (account or product environment) and/or `permission_type` (global or content-specific).

**Note:** If `scope_type` isn't specified as `prodenv`, the account-level policies will be returned.


### Example Usage

<!-- UsageSnippet language="java" operationID="getSystemPolicies" method="get" path="/v2/accounts/{account_id}/permissions/policies/system" example="SystemPoliciesExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetSystemPoliciesRequest;
import com.cloudinary.account.provisioning.models.operations.GetSystemPoliciesResponse;
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

        GetSystemPoliciesRequest req = GetSystemPoliciesRequest.builder()
                .permissionType(PermissionTypeEnum.GLOBAL)
                .scopeType(ScopeTypeEnum.PRODENV)
                .build();

        GetSystemPoliciesResponse res = sdk.systemPolicies().list()
                .request(req)
                .call();

        if (res.systemPoliciesResponse().isPresent()) {
            System.out.println(res.systemPoliciesResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetSystemPoliciesRequest](../../models/operations/GetSystemPoliciesRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GetSystemPoliciesResponse](../../models/operations/GetSystemPoliciesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/PermissionsErrorResponse | 401, 403                               | application/json                       |
| models/errors/PermissionsErrorResponse | 500                                    | application/json                       |
| models/errors/SDKException             | 4XX, 5XX                               | \*/\*                                  |