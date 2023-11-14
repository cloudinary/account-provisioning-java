# AccessKeysApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateAccessKey**](AccessKeysApi.md#generateAccessKey) | **POST** /sub_accounts/{sub_account_id}/access_keys | Generate an access key
[**getAccessKeys**](AccessKeysApi.md#getAccessKeys) | **GET** /sub_accounts/{sub_account_id}/access_keys | Get access keys
[**updateAccessKey**](AccessKeysApi.md#updateAccessKey) | **PUT** /sub_accounts/{sub_account_id}/access_keys/{key} | Update an access key



## generateAccessKey

> AccessKeyResponse generateAccessKey(subAccountId, accessKeyRequest)

Generate an access key

Generate a new access key.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        AccessKeyRequest accessKeyRequest = new AccessKeyRequest(); // AccessKeyRequest | Access key details
        try {
            AccessKeyResponse result = apiInstance.generateAccessKey(subAccountId, accessKeyRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessKeysApi#generateAccessKey");
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
 **accessKeyRequest** | [**AccessKeyRequest**](AccessKeyRequest.md)| Access key details | [optional]

### Return type

[**AccessKeyResponse**](AccessKeyResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Access key created successfully |  -  |


## getAccessKeys

> AccessKeysResponse getAccessKeys(subAccountId, pageSize, page, sortBy, sortOrder)

Get access keys

Retrieve an array of all access keys for a product environment.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        Integer pageSize = 56; // Integer | How many entries to display on each page.
        Integer page = 56; // Integer | Which page to return (maximum pages 100). Default All pages are returned.
        String sortBy = "sortBy_example"; // String | Which response parameter to sort by. Possible values api_key, created_at, name, enabled.
        String sortOrder = "sortOrder_example"; // String | Control the order of returned keys. Possible values desc (default), asc.
        try {
            AccessKeysResponse result = apiInstance.getAccessKeys(subAccountId, pageSize, page, sortBy, sortOrder);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessKeysApi#getAccessKeys");
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
 **pageSize** | **Integer**| How many entries to display on each page. | [optional]
 **page** | **Integer**| Which page to return (maximum pages 100). Default All pages are returned. | [optional]
 **sortBy** | **String**| Which response parameter to sort by. Possible values api_key, created_at, name, enabled. | [optional]
 **sortOrder** | **String**| Control the order of returned keys. Possible values desc (default), asc. | [optional]

### Return type

[**AccessKeysResponse**](AccessKeysResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## updateAccessKey

> AccessKeyResponse updateAccessKey(subAccountId, key, accessKeyUpdateRequest)

Update an access key

Update the name and/or status of an existing access key.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "subAccountId_example"; // String | 
        String key = "key_example"; // String | 
        AccessKeyUpdateRequest accessKeyUpdateRequest = new AccessKeyUpdateRequest(); // AccessKeyUpdateRequest | Access key details for update
        try {
            AccessKeyResponse result = apiInstance.updateAccessKey(subAccountId, key, accessKeyUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessKeysApi#updateAccessKey");
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
 **key** | **String**|  |
 **accessKeyUpdateRequest** | [**AccessKeyUpdateRequest**](AccessKeyUpdateRequest.md)| Access key details for update | [optional]

### Return type

[**AccessKeyResponse**](AccessKeyResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Access key updated successfully |  -  |

