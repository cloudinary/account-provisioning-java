# AccessKeys

## Overview

### Available Operations

* [list](#list) - Get access keys
* [generate](#generate) - Generate an access key
* [deleteByName](#deletebyname) - Delete access key by name
* [update](#update) - Update an access key
* [delete](#delete) - Delete access key

## list

Retrieve an array of all access keys for a product environment.

Learn more about retrieving access keys.
<https://cloudinary.com/documentation/provisioning_api#get_access_keys>

### Example Usage

<!-- UsageSnippet language="java" operationID="getAccessKeys" method="get" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}/access_keys" example="AccessKeys" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetAccessKeysRequest req = GetAccessKeysRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .sortBy(SortBy.CREATED_AT)
                .sortOrder(SortOrder.ASC)
                .build();

        GetAccessKeysResponse res = sdk.accessKeys().list()
                .request(req)
                .call();

        if (res.accessKeysResponse().isPresent()) {
            System.out.println(res.accessKeysResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [GetAccessKeysRequest](../../models/operations/GetAccessKeysRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[GetAccessKeysResponse](../../models/operations/GetAccessKeysResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## generate

Generate a new access key.

Learn more about generating access keys.
<https://cloudinary.com/documentation/provisioning_api#generate_an_access_key>

### Example Usage

<!-- UsageSnippet language="java" operationID="generateAccessKey" method="post" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}/access_keys" example="MainAccessKey" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.AccessKeyRequest;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GenerateAccessKeyRequest;
import com.cloudinary.account.provisioning.models.operations.GenerateAccessKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GenerateAccessKeyRequest req = GenerateAccessKeyRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .accessKeyRequest(AccessKeyRequest.builder()
                    .name("main_key")
                    .enabled(true)
                    .build())
                .build();

        GenerateAccessKeyResponse res = sdk.accessKeys().generate()
                .request(req)
                .call();

        if (res.accessKey().isPresent()) {
            System.out.println(res.accessKey().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GenerateAccessKeyRequest](../../models/operations/GenerateAccessKeyRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GenerateAccessKeyResponse](../../models/operations/GenerateAccessKeyResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## deleteByName

Delete a specific access key by name.

Learn more about deleting access keys.
<https://cloudinary.com/documentation/provisioning_api#delete_an_access_key>

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteAccessKeyByName" method="delete" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}/access_keys" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteAccessKeyByNameRequest;
import com.cloudinary.account.provisioning.models.operations.DeleteAccessKeyByNameResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        DeleteAccessKeyByNameRequest req = DeleteAccessKeyByNameRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .name("main_key")
                .build();

        DeleteAccessKeyByNameResponse res = sdk.accessKeys().deleteByName()
                .request(req)
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [DeleteAccessKeyByNameRequest](../../models/operations/DeleteAccessKeyByNameRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[DeleteAccessKeyByNameResponse](../../models/operations/DeleteAccessKeyByNameResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |

## update

Update the name and/or status of an existing access key.

Learn more about updating access keys.
<https://cloudinary.com/documentation/provisioning_api#update_an_access_key>

### Example Usage

<!-- UsageSnippet language="java" operationID="updateAccessKey" method="put" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}/access_keys/{key}" example="MainAccessKey" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateAccessKeyRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateAccessKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateAccessKeyRequest req = UpdateAccessKeyRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .key("814814814814814")
                .accessKeyUpdateRequest(AccessKeyUpdateRequest.builder()
                    .name("main_key")
                    .enabled(true)
                    .dedicatedFor(DedicatedFor.WEBHOOKS)
                    .build())
                .build();

        UpdateAccessKeyResponse res = sdk.accessKeys().update()
                .request(req)
                .call();

        if (res.accessKey().isPresent()) {
            System.out.println(res.accessKey().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [UpdateAccessKeyRequest](../../models/operations/UpdateAccessKeyRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[UpdateAccessKeyResponse](../../models/operations/UpdateAccessKeyResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete a specific access key.

Learn more about deleting access keys.
<https://cloudinary.com/documentation/provisioning_api#delete_an_access_key>

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteAccessKey" method="delete" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}/access_keys/{key}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteAccessKeyRequest;
import com.cloudinary.account.provisioning.models.operations.DeleteAccessKeyResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        DeleteAccessKeyRequest req = DeleteAccessKeyRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .key("814814814814814")
                .build();

        DeleteAccessKeyResponse res = sdk.accessKeys().delete()
                .request(req)
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [DeleteAccessKeyRequest](../../models/operations/DeleteAccessKeyRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[DeleteAccessKeyResponse](../../models/operations/DeleteAccessKeyResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |