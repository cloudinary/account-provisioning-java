# BillingUsage

## Overview

### Available Operations

* [get](#get) - Get billing usage information

## get

Retrieve billing usage metrics for your account and product environments,
including storage, bandwidth, impressions, and transformations.

If `year` is provided:
  - **Annual subscription**: Returns the single annual usage cycle that began in the specified year (if any).
  - **Monthly subscription**: Returns all monthly usage cycles that began in the specified year.

If `year` is not provided:
  - Returns usage for the year in which the current active subscription period began.
  - If no active subscription exists, an empty list is returned.

**Note**: Usage metrics are updated daily, so calling this endpoint once per day gives you the latest data.


### Example Usage: AdvancedExtraPAYG

<!-- UsageSnippet language="java" operationID="getBillingUsage" method="get" path="/v1_1/provisioning/accounts/{account_id}/billing_usage" example="AdvancedExtraPAYG" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageRequest;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageResponse;
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

        GetBillingUsageRequest req = GetBillingUsageRequest.builder()
                .year(2024)
                .build();

        GetBillingUsageResponse res = sdk.billingUsage().get()
                .request(req)
                .call();

        if (res.billingUsageResponse().isPresent()) {
            System.out.println(res.billingUsageResponse().get());
        }
    }
}
```
### Example Usage: AdvancedPAYG

<!-- UsageSnippet language="java" operationID="getBillingUsage" method="get" path="/v1_1/provisioning/accounts/{account_id}/billing_usage" example="AdvancedPAYG" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageRequest;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageResponse;
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

        GetBillingUsageRequest req = GetBillingUsageRequest.builder()
                .year(2024)
                .build();

        GetBillingUsageResponse res = sdk.billingUsage().get()
                .request(req)
                .call();

        if (res.billingUsageResponse().isPresent()) {
            System.out.println(res.billingUsageResponse().get());
        }
    }
}
```
### Example Usage: MultiPlan

<!-- UsageSnippet language="java" operationID="getBillingUsage" method="get" path="/v1_1/provisioning/accounts/{account_id}/billing_usage" example="MultiPlan" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageRequest;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageResponse;
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

        GetBillingUsageRequest req = GetBillingUsageRequest.builder()
                .year(2024)
                .build();

        GetBillingUsageResponse res = sdk.billingUsage().get()
                .request(req)
                .call();

        if (res.billingUsageResponse().isPresent()) {
            System.out.println(res.billingUsageResponse().get());
        }
    }
}
```
### Example Usage: ProPAYG

<!-- UsageSnippet language="java" operationID="getBillingUsage" method="get" path="/v1_1/provisioning/accounts/{account_id}/billing_usage" example="ProPAYG" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageRequest;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageResponse;
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

        GetBillingUsageRequest req = GetBillingUsageRequest.builder()
                .year(2024)
                .build();

        GetBillingUsageResponse res = sdk.billingUsage().get()
                .request(req)
                .call();

        if (res.billingUsageResponse().isPresent()) {
            System.out.println(res.billingUsageResponse().get());
        }
    }
}
```
### Example Usage: ProPAYGPlus

<!-- UsageSnippet language="java" operationID="getBillingUsage" method="get" path="/v1_1/provisioning/accounts/{account_id}/billing_usage" example="ProPAYGPlus" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageRequest;
import com.cloudinary.account.provisioning.models.operations.GetBillingUsageResponse;
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

        GetBillingUsageRequest req = GetBillingUsageRequest.builder()
                .year(2024)
                .build();

        GetBillingUsageResponse res = sdk.billingUsage().get()
                .request(req)
                .call();

        if (res.billingUsageResponse().isPresent()) {
            System.out.println(res.billingUsageResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetBillingUsageRequest](../../models/operations/GetBillingUsageRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetBillingUsageResponse](../../models/operations/GetBillingUsageResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 401, 403, 404, 429     | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |