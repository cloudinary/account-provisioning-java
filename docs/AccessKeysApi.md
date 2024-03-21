# AccessKeysApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAccessKey**](AccessKeysApi.md#deleteAccessKey) | **DELETE** /sub_accounts/{sub_account_id}/access_keys/{key} | Delete access key
[**deleteAccessKeyByName**](AccessKeysApi.md#deleteAccessKeyByName) | **DELETE** /sub_accounts/{sub_account_id}/access_keys | Delete access key by name
[**generateAccessKey**](AccessKeysApi.md#generateAccessKey) | **POST** /sub_accounts/{sub_account_id}/access_keys | Generate an access key
[**getAccessKeys**](AccessKeysApi.md#getAccessKeys) | **GET** /sub_accounts/{sub_account_id}/access_keys | Get access keys
[**updateAccessKey**](AccessKeysApi.md#updateAccessKey) | **PUT** /sub_accounts/{sub_account_id}/access_keys/{key} | Update an access key



## deleteAccessKey

> SuccessResponse deleteAccessKey(subAccountId, key)

Delete access key

Delete a specific access key.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        String key = "814814814814814"; // String | The access key (api key).
        try {
            SuccessResponse result = apiInstance.deleteAccessKey(subAccountId, key);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessKeysApi#deleteAccessKey");
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
 **key** | **String**| The access key (api key). |

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
| **200** | Access Key deleted successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## deleteAccessKeyByName

> SuccessResponse deleteAccessKeyByName(subAccountId, name)

Delete access key by name

Delete a specific access key by name.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        String name = "main_key"; // String | The access key name.
        try {
            SuccessResponse result = apiInstance.deleteAccessKeyByName(subAccountId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessKeysApi#deleteAccessKeyByName");
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
 **name** | **String**| The access key name. |

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
| **200** | Access Key deleted successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## generateAccessKey

> AccessKey generateAccessKey(subAccountId, accessKeyRequest)

Generate an access key

Generate a new access key.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        AccessKeyRequest accessKeyRequest = new AccessKeyRequest(); // AccessKeyRequest | Access key details
        try {
            AccessKey result = apiInstance.generateAccessKey(subAccountId, accessKeyRequest);
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
 **subAccountId** | **String**| The ID of the product environment. |
 **accessKeyRequest** | [**AccessKeyRequest**](AccessKeyRequest.md)| Access key details | [optional]

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Access key created successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## getAccessKeys

> AccessKeysResponse getAccessKeys(subAccountId, pageSize, page, sortBy, sortOrder)

Get access keys

Retrieve an array of all access keys for a product environment.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        Integer pageSize = 56; // Integer | How many entries to display on each page.
        Integer page = 56; // Integer | Which page to return (maximum pages 100). **Default**: All pages are returned. 
        String sortBy = "api_key"; // String | Which response parameter to sort by. **Possible values**: `api_key`, `created_at`, `name`, `enabled`. 
        String sortOrder = "desc"; // String | Control the order of returned keys. **Possible values**: `desc` (default), `asc`. 
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
 **subAccountId** | **String**| The ID of the product environment. |
 **pageSize** | **Integer**| How many entries to display on each page. | [optional]
 **page** | **Integer**| Which page to return (maximum pages 100). **Default**: All pages are returned.  | [optional]
 **sortBy** | **String**| Which response parameter to sort by. **Possible values**: &#x60;api_key&#x60;, &#x60;created_at&#x60;, &#x60;name&#x60;, &#x60;enabled&#x60;.  | [optional] [enum: api_key, created_at, name, enabled]
 **sortOrder** | **String**| Control the order of returned keys. **Possible values**: &#x60;desc&#x60; (default), &#x60;asc&#x60;.  | [optional] [enum: desc, asc]

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
| **401** | Authorization required. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## updateAccessKey

> AccessKey updateAccessKey(subAccountId, key, accessKeyUpdateRequest)

Update an access key

Update the name and/or status of an existing access key.

### Example

```java
// Import classes:
import com.cloudinary.account.provisioning.ApiClient;
import com.cloudinary.account.provisioning.ApiException;
import com.cloudinary.account.provisioning.Configuration;
import com.cloudinary.account.provisioning.auth.*;
import com.cloudinary.account.provisioning.models.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        AccessKeysApi apiInstance = new AccessKeysApi(apiClient);
        String subAccountId = "abcde1fghij2klmno3pqrst4uvwxy5z"; // String | The ID of the product environment.
        String key = "814814814814814"; // String | The access key (api key).
        AccessKeyUpdateRequest accessKeyUpdateRequest = new AccessKeyUpdateRequest(); // AccessKeyUpdateRequest | Access key details for update
        try {
            AccessKey result = apiInstance.updateAccessKey(subAccountId, key, accessKeyUpdateRequest);
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
 **subAccountId** | **String**| The ID of the product environment. |
 **key** | **String**| The access key (api key). |
 **accessKeyUpdateRequest** | [**AccessKeyUpdateRequest**](AccessKeyUpdateRequest.md)| Access key details for update | [optional]

### Return type

[**AccessKey**](AccessKey.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Access key updated successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |

