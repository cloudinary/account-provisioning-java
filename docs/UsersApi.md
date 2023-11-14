# UsersApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UsersApi.md#createUser) | **POST** /users | Create user
[**deleteUser**](UsersApi.md#deleteUser) | **DELETE** /users/{user_id} | Delete user
[**getUser**](UsersApi.md#getUser) | **GET** /users/{user_id} | Get user
[**getUsers**](UsersApi.md#getUsers) | **GET** /users | Get users
[**updateUser**](UsersApi.md#updateUser) | **PUT** /users/{user_id} | Update user



## createUser

> UserResponse createUser(userRequest)

Create user

Create a new user.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UsersApi apiInstance = new UsersApi(apiClient);
        UserRequest userRequest = new UserRequest(); // UserRequest | User details
        try {
            UserResponse result = apiInstance.createUser(userRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#createUser");
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
 **userRequest** | [**UserRequest**](UserRequest.md)| User details | [optional]

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | User created successfully |  -  |


## deleteUser

> MessageResponse deleteUser(userId)

Delete user

Delete a specific user.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UsersApi apiInstance = new UsersApi(apiClient);
        String userId = "userId_example"; // String | 
        try {
            MessageResponse result = apiInstance.deleteUser(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#deleteUser");
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
 **userId** | **String**|  |

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
| **200** | User deleted successfully |  -  |


## getUser

> UserResponse getUser(userId)

Get user

Retrieve a specific user.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UsersApi apiInstance = new UsersApi(apiClient);
        String userId = "userId_example"; // String | 
        try {
            UserResponse result = apiInstance.getUser(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#getUser");
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
 **userId** | **String**|  |

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## getUsers

> UsersResponse getUsers(pending, ids, prefix, subAccountId)

Get users

Retrieve an array of users.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UsersApi apiInstance = new UsersApi(apiClient);
        Boolean pending = true; // Boolean | Whether to return pending users. Default false (all users)
        List<String> ids = Arrays.asList(); // List<String> | A list of up to 100 user IDs.
        String prefix = "prefix_example"; // String | Returns users where the name begins with the specified case-insensitive string.
        String subAccountId = "subAccountId_example"; // String | Only returns users who have access to the specified account.
        try {
            UsersResponse result = apiInstance.getUsers(pending, ids, prefix, subAccountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#getUsers");
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
 **pending** | **Boolean**| Whether to return pending users. Default false (all users) | [optional]
 **ids** | [**List&lt;String&gt;**](String.md)| A list of up to 100 user IDs. | [optional]
 **prefix** | **String**| Returns users where the name begins with the specified case-insensitive string. | [optional]
 **subAccountId** | **String**| Only returns users who have access to the specified account. | [optional]

### Return type

[**UsersResponse**](UsersResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## updateUser

> UserResponse updateUser(userId, userRequest)

Update user

Update the details of a user.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UsersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UsersApi apiInstance = new UsersApi(apiClient);
        String userId = "userId_example"; // String | 
        UserRequest userRequest = new UserRequest(); // UserRequest | Updated user details
        try {
            UserResponse result = apiInstance.updateUser(userId, userRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsersApi#updateUser");
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
 **userId** | **String**|  |
 **userRequest** | [**UserRequest**](UserRequest.md)| Updated user details | [optional]

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User updated successfully |  -  |

