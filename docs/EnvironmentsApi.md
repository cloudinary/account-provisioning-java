# EnvironmentsApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProductEnvironment**](EnvironmentsApi.md#createProductEnvironment) | **POST** /sub_accounts | Create product environment
[**deleteProductEnvironment**](EnvironmentsApi.md#deleteProductEnvironment) | **DELETE** /sub_accounts/{sub_account_id} | Delete product environment
[**getProductEnvironment**](EnvironmentsApi.md#getProductEnvironment) | **GET** /sub_accounts/{sub_account_id} | Get product environment
[**getProductEnvironments**](EnvironmentsApi.md#getProductEnvironments) | **GET** /sub_accounts | Get product environments
[**updateProductEnvironment**](EnvironmentsApi.md#updateProductEnvironment) | **PUT** /sub_accounts/{sub_account_id} | Update product environment



## createProductEnvironment

> ProductEnvironmentResponse createProductEnvironment(productEnvironmentRequest)

Create product environment

Create a new product environment.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.EnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        EnvironmentsApi apiInstance = new EnvironmentsApi(apiClient);
        ProductEnvironmentRequest productEnvironmentRequest = new ProductEnvironmentRequest(); // ProductEnvironmentRequest | Product environment details
        try {
            ProductEnvironmentResponse result = apiInstance.createProductEnvironment(productEnvironmentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnvironmentsApi#createProductEnvironment");
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
 **productEnvironmentRequest** | [**ProductEnvironmentRequest**](ProductEnvironmentRequest.md)| Product environment details | [optional]

### Return type

[**ProductEnvironmentResponse**](ProductEnvironmentResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Product environment created successfully |  -  |


## deleteProductEnvironment

> MessageResponse deleteProductEnvironment(subAccountId)

Delete product environment

Delete a specific product environment.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.EnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        EnvironmentsApi apiInstance = new EnvironmentsApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        try {
            MessageResponse result = apiInstance.deleteProductEnvironment(subAccountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnvironmentsApi#deleteProductEnvironment");
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
 **subAccountId** | **String**|  |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product environment deleted successfully |  -  |


## getProductEnvironment

> ProductEnvironmentResponse getProductEnvironment(subAccountId)

Get product environment

Retrieve a specific product environment.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.EnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        EnvironmentsApi apiInstance = new EnvironmentsApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        try {
            ProductEnvironmentResponse result = apiInstance.getProductEnvironment(subAccountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnvironmentsApi#getProductEnvironment");
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
 **subAccountId** | **String**|  |

### Return type

[**ProductEnvironmentResponse**](ProductEnvironmentResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## getProductEnvironments

> ProductEnvironmentsResponse getProductEnvironments(enabled, ids, prefix)

Get product environments

Retrieve an array of product environments.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.EnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        EnvironmentsApi apiInstance = new EnvironmentsApi(apiClient);
        Boolean enabled = true; // Boolean | Whether to return enabled (true) or disabled (false) product environments. Default all environments.
        List<String> ids = Arrays.asList(); // List<String> | A list of up to 100 product environment IDs.
        String prefix = "product"; // String | Returns product environments where the name begins with the specified case-insensitive string.
        try {
            ProductEnvironmentsResponse result = apiInstance.getProductEnvironments(enabled, ids, prefix);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnvironmentsApi#getProductEnvironments");
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
 **enabled** | **Boolean**| Whether to return enabled (true) or disabled (false) product environments. Default all environments. | [optional]
 **ids** | [**List&lt;String&gt;**](String.md)| A list of up to 100 product environment IDs. | [optional]
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
| **200** | Successful operation |  -  |


## updateProductEnvironment

> ProductEnvironmentResponse updateProductEnvironment(subAccountId, productEnvironmentRequest)

Update product environment

Update the details of a product environment.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.EnvironmentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        EnvironmentsApi apiInstance = new EnvironmentsApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        ProductEnvironmentRequest productEnvironmentRequest = new ProductEnvironmentRequest(); // ProductEnvironmentRequest | Updated product environment details
        try {
            ProductEnvironmentResponse result = apiInstance.updateProductEnvironment(subAccountId, productEnvironmentRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EnvironmentsApi#updateProductEnvironment");
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
 **subAccountId** | **String**|  |
 **productEnvironmentRequest** | [**ProductEnvironmentRequest**](ProductEnvironmentRequest.md)| Updated product environment details | [optional]

### Return type

[**ProductEnvironmentResponse**](ProductEnvironmentResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product environment updated successfully |  -  |

