# ProductEnvironmentsApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProductEnvironment**](ProductEnvironmentsApi.md#createProductEnvironment) | **POST** /sub_accounts | Create product environment
[**deleteProductEnvironment**](ProductEnvironmentsApi.md#deleteProductEnvironment) | **DELETE** /sub_accounts/{sub_account_id} | Delete product environment
[**getProductEnvironment**](ProductEnvironmentsApi.md#getProductEnvironment) | **GET** /sub_accounts/{sub_account_id} | Get product environment
[**getProductEnvironments**](ProductEnvironmentsApi.md#getProductEnvironments) | **GET** /sub_accounts | Get product environments
[**updateProductEnvironment**](ProductEnvironmentsApi.md#updateProductEnvironment) | **PUT** /sub_accounts/{sub_account_id} | Update product environment



## createProductEnvironment

> ProductEnvironment createProductEnvironment(productEnvironmentRequest)

Create product environment

Create a new product environment. Any users that have access to all product environments will also automatically have access to the new product environment. 

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.ProductEnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        ProductEnvironmentsApi apiInstance = new ProductEnvironmentsApi(apiClient);
        ProductEnvironmentRequest productEnvironmentRequest = new ProductEnvironmentRequest(); // ProductEnvironmentRequest | Product environment details
        try {
            ProductEnvironment result = apiInstance.createProductEnvironment(productEnvironmentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductEnvironmentsApi#createProductEnvironment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productEnvironmentRequest** | [**ProductEnvironmentRequest**](ProductEnvironmentRequest.md)| Product environment details |

### Return type

[**ProductEnvironment**](ProductEnvironment.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product environment created successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## deleteProductEnvironment

> SuccessResponse deleteProductEnvironment(subAccountId)

Delete product environment

Delete a specific product environment.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.ProductEnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        ProductEnvironmentsApi apiInstance = new ProductEnvironmentsApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        try {
            SuccessResponse result = apiInstance.deleteProductEnvironment(subAccountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductEnvironmentsApi#deleteProductEnvironment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subAccountId** | **String**| The ID of the product environment. |

### Return type

[**SuccessResponse**](SuccessResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product environment deleted successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## getProductEnvironment

> ProductEnvironment getProductEnvironment(subAccountId)

Get product environment

Retrieve a specific product environment.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.ProductEnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        ProductEnvironmentsApi apiInstance = new ProductEnvironmentsApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        try {
            ProductEnvironment result = apiInstance.getProductEnvironment(subAccountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductEnvironmentsApi#getProductEnvironment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subAccountId** | **String**| The ID of the product environment. |

### Return type

[**ProductEnvironment**](ProductEnvironment.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## getProductEnvironments

> ProductEnvironmentsResponse getProductEnvironments(enabled, ids, prefix)

Get product environments

Return an array of all product environments, or if conditions are specified,  return the relevant product environments. 

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.ProductEnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        ProductEnvironmentsApi apiInstance = new ProductEnvironmentsApi(apiClient);
        Boolean enabled = true; // Boolean | Whether to only return enabled product environments (true) or disabled product environments (false).  **Default**: all product environments are returned (both enabled and disabled). 
        List<String> ids = Arrays.asList(); // List<String> | A list of up to 100 product environment IDs. When provided, other parameters are ignored.
        String prefix = "product"; // String | Returns product environments where the name begins with the specified case-insensitive string.
        try {
            ProductEnvironmentsResponse result = apiInstance.getProductEnvironments(enabled, ids, prefix);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductEnvironmentsApi#getProductEnvironments");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **enabled** | **Boolean**| Whether to only return enabled product environments (true) or disabled product environments (false).  **Default**: all product environments are returned (both enabled and disabled).  | [optional]
 **ids** | [**List&lt;String&gt;**](String.md)| A list of up to 100 product environment IDs. When provided, other parameters are ignored. | [optional]
 **prefix** | **String**| Returns product environments where the name begins with the specified case-insensitive string. | [optional]

### Return type

[**ProductEnvironmentsResponse**](ProductEnvironmentsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation. |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## updateProductEnvironment

> ProductEnvironment updateProductEnvironment(subAccountId, productEnvironmentUpdateRequest)

Update product environment

Update the details of a product environment.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.ProductEnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        ProductEnvironmentsApi apiInstance = new ProductEnvironmentsApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        ProductEnvironmentUpdateRequest productEnvironmentUpdateRequest = new ProductEnvironmentUpdateRequest(); // ProductEnvironmentUpdateRequest | Updated product environment details
        try {
            ProductEnvironment result = apiInstance.updateProductEnvironment(subAccountId, productEnvironmentUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductEnvironmentsApi#updateProductEnvironment");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subAccountId** | **String**| The ID of the product environment. |
 **productEnvironmentUpdateRequest** | [**ProductEnvironmentUpdateRequest**](ProductEnvironmentUpdateRequest.md)| Updated product environment details | [optional]

### Return type

[**ProductEnvironment**](ProductEnvironment.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product environment updated successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |

