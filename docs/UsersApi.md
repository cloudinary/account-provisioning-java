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

> User createUser(userRequest)

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
            User result = apiInstance.createUser(userRequest);
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

[**User**](User.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User created successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## deleteUser

> SuccessResponse deleteUser(userId)

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
        String userId = "0abed8dfcc039ea05e2a1d494fd442"; // String | The ID of the user.
        try {
            SuccessResponse result = apiInstance.deleteUser(userId);
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
 **userId** | **String**| The ID of the user. |

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
| **200** | User deleted successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## getUser

> User getUser(userId)

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
        String userId = "0abed8dfcc039ea05e2a1d494fd442"; // String | The ID of the user.
        try {
            User result = apiInstance.getUser(userId);
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
 **userId** | **String**| The ID of the user. |

### Return type

[**User**](User.md)

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


## getUsers

> UsersResponse getUsers(pending, ids, prefix, subAccountId, lastLogin, from, to, unionType)

Get users

Returns an array of all users in the account, or if conditions are specified, returns the relevant users. 

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
        Boolean pending = false; // Boolean | Whether to return pending users. **Default**: `false` (all users) 
        List<String> ids = Arrays.asList(); // List<String> | A list of up to 100 user IDs.  When provided, other parameters are ignored.
        String prefix = "john"; // String | Returns users where the name begins with the specified case-insensitive string.
        String subAccountId = "subAccountId_example"; // String | Only returns users who have access to the specified account.
        Boolean lastLogin = true; // Boolean | Specifies a date range for last login.
        LocalDate from = LocalDate.parse("2023-01-01"); // LocalDate | All last logins after this date, given in the format: yyyy-mm-dd. 
        LocalDate to = LocalDate.parse("2024-12-31"); // LocalDate | All last logins before this date, given in the format: yyyy-mm-dd. 
        String unionType = "include"; // String | Whether to return users who last logged in within the specified date range (include) or those who didn't last log in within the range (exclude). **Possible values**: `include`, `exclude`. **Default**: `include`. 
        try {
            UsersResponse result = apiInstance.getUsers(pending, ids, prefix, subAccountId, lastLogin, from, to, unionType);
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
 **pending** | **Boolean**| Whether to return pending users. **Default**: &#x60;false&#x60; (all users)  | [optional]
 **ids** | [**List&lt;String&gt;**](String.md)| A list of up to 100 user IDs.  When provided, other parameters are ignored. | [optional]
 **prefix** | **String**| Returns users where the name begins with the specified case-insensitive string. | [optional]
 **subAccountId** | **String**| Only returns users who have access to the specified account. | [optional]
 **lastLogin** | **Boolean**| Specifies a date range for last login. | [optional]
 **from** | **LocalDate**| All last logins after this date, given in the format: yyyy-mm-dd.  | [optional]
 **to** | **LocalDate**| All last logins before this date, given in the format: yyyy-mm-dd.  | [optional]
 **unionType** | **String**| Whether to return users who last logged in within the specified date range (include) or those who didn&#39;t last log in within the range (exclude). **Possible values**: &#x60;include&#x60;, &#x60;exclude&#x60;. **Default**: &#x60;include&#x60;.  | [optional] [enum: include, exclude]

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
| **401** | Authorization required. |  -  |
| **404** | Not found. |  -  |
| **420** | Max usage rate exceeded. |  -  |


## updateUser

> User updateUser(userId, userRequest)

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
        String userId = "0abed8dfcc039ea05e2a1d494fd442"; // String | The ID of the user.
        UserRequest userRequest = new UserRequest(); // UserRequest | Updated user details
        try {
            User result = apiInstance.updateUser(userId, userRequest);
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
 **userId** | **String**| The ID of the user. |
 **userRequest** | [**UserRequest**](UserRequest.md)| Updated user details | [optional]

### Return type

[**User**](User.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User updated successfully |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization required. |  -  |
| **403** | Not allowed. |  -  |
| **404** | Not found. |  -  |
| **409** | Already exists. |  -  |
| **420** | Max usage rate exceeded. |  -  |

