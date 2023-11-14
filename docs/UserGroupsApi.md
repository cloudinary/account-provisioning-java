# UserGroupsApi

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserToUserGroup**](UserGroupsApi.md#addUserToUserGroup) | **POST** /user_groups/{group_id}/users/{user_id} | Add User to User Group
[**createUserGroup**](UserGroupsApi.md#createUserGroup) | **POST** /user_groups | Create User Group
[**deleteUserGroup**](UserGroupsApi.md#deleteUserGroup) | **DELETE** /user_groups/{group_id} | Delete User Group
[**getUserGroup**](UserGroupsApi.md#getUserGroup) | **GET** /user_groups/{group_id} | Get User Group
[**getUserGroups**](UserGroupsApi.md#getUserGroups) | **GET** /user_groups | Get User Groups
[**getUsersInUserGroup**](UserGroupsApi.md#getUsersInUserGroup) | **GET** /user_groups/{group_id}/users | Get Users in User Group
[**removeUserFromUserGroup**](UserGroupsApi.md#removeUserFromUserGroup) | **DELETE** /user_groups/{group_id}/users/{user_id} | Remove User from User Group
[**updateUserGroup**](UserGroupsApi.md#updateUserGroup) | **PUT** /user_groups/{group_id} | Update User Group



## addUserToUserGroup

> UserGroupUserResponse addUserToUserGroup(groupId, userId)

Add User to User Group

Add a user to a group with the specified ID.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        String userId = "userId_example"; // String | 
        try {
            UserGroupUserResponse result = apiInstance.addUserToUserGroup(groupId, userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#addUserToUserGroup");
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
 **groupId** | **String**|  |
 **userId** | **String**|  |

### Return type

[**UserGroupUserResponse**](UserGroupUserResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | User added to group successfully |  -  |


## createUserGroup

> UserGroupResponse createUserGroup(userGroupRequest)

Create User Group

Create a new user group for the account.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        UserGroupRequest userGroupRequest = new UserGroupRequest(); // UserGroupRequest | User group details
        try {
            UserGroupResponse result = apiInstance.createUserGroup(userGroupRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#createUserGroup");
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
 **userGroupRequest** | [**UserGroupRequest**](UserGroupRequest.md)| User group details | [optional]

### Return type

[**UserGroupResponse**](UserGroupResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | User group created successfully |  -  |


## deleteUserGroup

> MessageResponse deleteUserGroup(groupId)

Delete User Group

Delete a user group with the specified ID.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        try {
            MessageResponse result = apiInstance.deleteUserGroup(groupId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#deleteUserGroup");
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
 **groupId** | **String**|  |

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
| **200** | User group deleted successfully |  -  |


## getUserGroup

> UserGroupResponse getUserGroup(groupId)

Get User Group

Retrieve a specific user group.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        try {
            UserGroupResponse result = apiInstance.getUserGroup(groupId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#getUserGroup");
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
 **groupId** | **String**|  |

### Return type

[**UserGroupResponse**](UserGroupResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## getUserGroups

> UserGroupsResponse getUserGroups()

Get User Groups

Retrieve an array of all user groups in the account.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        try {
            UserGroupsResponse result = apiInstance.getUserGroups();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#getUserGroups");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**UserGroupsResponse**](UserGroupsResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## getUsersInUserGroup

> UserGroupUsersResponse getUsersInUserGroup(groupId)

Get Users in User Group

Retrieve the users in the group with the specified ID.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        try {
            UserGroupUsersResponse result = apiInstance.getUsersInUserGroup(groupId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#getUsersInUserGroup");
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
 **groupId** | **String**|  |

### Return type

[**UserGroupUsersResponse**](UserGroupUsersResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |


## removeUserFromUserGroup

> UserGroupUserResponse removeUserFromUserGroup(groupId, userId)

Remove User from User Group

Remove a user from a group with the specified ID.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        String userId = "userId_example"; // String | 
        try {
            UserGroupUserResponse result = apiInstance.removeUserFromUserGroup(groupId, userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#removeUserFromUserGroup");
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
 **groupId** | **String**|  |
 **userId** | **String**|  |

### Return type

[**UserGroupUserResponse**](UserGroupUserResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User removed from group successfully |  -  |


## updateUserGroup

> UserGroupResponse updateUserGroup(groupId, userGroupRequest)

Update User Group

Update the name of a specified user group.

### Example

```java
// Import classes:
import com.cloudinary.provisioning.ApiClient;
import com.cloudinary.provisioning.ApiException;
import com.cloudinary.provisioning.Configuration;
import com.cloudinary.provisioning.auth.*;
import com.cloudinary.provisioning.models.*;
import com.cloudinary.provisioning.api.UserGroupsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        // If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
        UserGroupsApi apiInstance = new UserGroupsApi(apiClient);
        String groupId = "groupId_example"; // String | 
        UserGroupRequest userGroupRequest = new UserGroupRequest(); // UserGroupRequest | Updated user group details
        try {
            UserGroupResponse result = apiInstance.updateUserGroup(groupId, userGroupRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserGroupsApi#updateUserGroup");
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
 **groupId** | **String**|  |
 **userGroupRequest** | [**UserGroupRequest**](UserGroupRequest.md)| Updated user group details | [optional]

### Return type

[**UserGroupResponse**](UserGroupResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User group updated successfully |  -  |

