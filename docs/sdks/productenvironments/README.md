# ProductEnvironments

## Overview

### Available Operations

* [list](#list) - Get product environments
* [create](#create) - Create product environment
* [get](#get) - Get product environment
* [update](#update) - Update product environment
* [delete](#delete) - Delete product environment

## list

Return an array of all product environments, or if conditions are specified,
return the relevant product environments.


Learn more about getting product environments.
<https://cloudinary.com/documentation/provisioning_api#get_product_environments>

### Example Usage

<!-- UsageSnippet language="java" operationID="getProductEnvironments" method="get" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts" example="ProductEnvironments" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
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

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [GetProductEnvironmentsRequest](../../models/operations/GetProductEnvironmentsRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[GetProductEnvironmentsResponse](../../models/operations/GetProductEnvironmentsResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## create

Create a new product environment. Any users that have access to all product environments will also automatically
have access to the new product environment.


Learn more about creating product environments.
<https://cloudinary.com/documentation/provisioning_api#create_product_environment>

### Example Usage

<!-- UsageSnippet language="java" operationID="createProductEnvironment" method="post" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts" example="ProductEnvironment3" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.ProductEnvironmentRequest;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateProductEnvironmentResponse;
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

        ProductEnvironmentRequest req = ProductEnvironmentRequest.builder()
                .name("Product3 Application")
                .cloudName("product3")
                .baseSubAccountId("0aaaaa1bbbbb2ccccc3ddddd4eeeee5f")
                .build();

        CreateProductEnvironmentResponse res = sdk.productEnvironments().create()
                .request(req)
                .call();

        if (res.productEnvironment().isPresent()) {
            System.out.println(res.productEnvironment().get());
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [ProductEnvironmentRequest](../../models/shared/ProductEnvironmentRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[CreateProductEnvironmentResponse](../../models/operations/CreateProductEnvironmentResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 409, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |

## get

Retrieve a specific product environment.

Learn more about retrieving specific product environments.
<https://cloudinary.com/documentation/provisioning_api#get_product_environment>

### Example Usage: ProductEnvironment1

<!-- UsageSnippet language="java" operationID="getProductEnvironment" method="get" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}" example="ProductEnvironment1" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentResponse;
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

        GetProductEnvironmentResponse res = sdk.productEnvironments().get()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .call();

        if (res.productEnvironment().isPresent()) {
            System.out.println(res.productEnvironment().get());
        }
    }
}
```
### Example Usage: ProductEnvironment2

<!-- UsageSnippet language="java" operationID="getProductEnvironment" method="get" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}" example="ProductEnvironment2" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentResponse;
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

        GetProductEnvironmentResponse res = sdk.productEnvironments().get()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .call();

        if (res.productEnvironment().isPresent()) {
            System.out.println(res.productEnvironment().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        | Example                            |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subAccountId`                     | *String*                           | :heavy_check_mark:                 | The ID of the product environment. | abcde1fghij2klmno3pqrst4uvwxy5z    |

### Response

**[GetProductEnvironmentResponse](../../models/operations/GetProductEnvironmentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 404, 420, 429     | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## update

Update the details of a product environment.

Learn more about updating product environments.
<https://cloudinary.com/documentation/provisioning_api#update_product_environment>

### Example Usage

<!-- UsageSnippet language="java" operationID="updateProductEnvironment" method="put" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}" example="ProductEnvironment1" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.ProductEnvironmentUpdateRequest;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateProductEnvironmentRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateProductEnvironmentResponse;
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

        UpdateProductEnvironmentRequest req = UpdateProductEnvironmentRequest.builder()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .productEnvironmentUpdateRequest(ProductEnvironmentUpdateRequest.builder()
                    .name("Product3 Application")
                    .cloudName("product3")
                    .build())
                .build();

        UpdateProductEnvironmentResponse res = sdk.productEnvironments().update()
                .request(req)
                .call();

        if (res.productEnvironment().isPresent()) {
            System.out.println(res.productEnvironment().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [UpdateProductEnvironmentRequest](../../models/operations/UpdateProductEnvironmentRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[UpdateProductEnvironmentResponse](../../models/operations/UpdateProductEnvironmentResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete a specific product environment.

Learn more about deleting product environments.
<https://cloudinary.com/documentation/provisioning_api#delete_product_environment>

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteProductEnvironment" method="delete" path="/v1_1/provisioning/accounts/{account_id}/sub_accounts/{sub_account_id}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteProductEnvironmentResponse;
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

        DeleteProductEnvironmentResponse res = sdk.productEnvironments().delete()
                .subAccountId("abcde1fghij2klmno3pqrst4uvwxy5z")
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                          | Type                               | Required                           | Description                        | Example                            |
| ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- | ---------------------------------- |
| `subAccountId`                     | *String*                           | :heavy_check_mark:                 | The ID of the product environment. | abcde1fghij2klmno3pqrst4uvwxy5z    |

### Response

**[DeleteProductEnvironmentResponse](../../models/operations/DeleteProductEnvironmentResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |