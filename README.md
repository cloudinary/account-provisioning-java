# Cloudinary provisioning-java

    Accounts with provisioning API access can create and manage their **product environments**, **users** and **user groups** using the RESTful Provisioning API. 

Provisioning API access is available [upon request](https://cloudinary.com/contact?plan=enterprise) for accounts on an [Enterprise plan](https://cloudinary.com/pricing#pricing-enterprise).


    For more information, please visit [https://support.cloudinary.com](https://support.cloudinary.com).

## Installation & Usage

## Requirements

Java 6 and later.

## Installation

The cloudinary_java library is available in Maven Central. To use it, add the following dependency to your pom.xml :
```xml
<dependency>
    <groupId>com.cloudinary.provisioning</groupId>
    <artifactId>provisioning-java</artifactId>
    <version>0.0.1</version>
    <scope>compile</scope>
</dependency>
```

## API Endpoints

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccessKeysApi* | [**generateAccessKey**](docs/AccessKeysApi.md#generateAccessKey) | **POST** /sub_accounts/{sub_account_id}/access_keys | Generate an access key
*AccessKeysApi* | [**getAccessKeys**](docs/AccessKeysApi.md#getAccessKeys) | **GET** /sub_accounts/{sub_account_id}/access_keys | Get access keys
*AccessKeysApi* | [**updateAccessKey**](docs/AccessKeysApi.md#updateAccessKey) | **PUT** /sub_accounts/{sub_account_id}/access_keys/{key} | Update an access key
*EnvironmentsApi* | [**createProductEnvironment**](docs/EnvironmentsApi.md#createProductEnvironment) | **POST** /sub_accounts | Create product environment
*EnvironmentsApi* | [**deleteProductEnvironment**](docs/EnvironmentsApi.md#deleteProductEnvironment) | **DELETE** /sub_accounts/{sub_account_id} | Delete product environment
*EnvironmentsApi* | [**getProductEnvironment**](docs/EnvironmentsApi.md#getProductEnvironment) | **GET** /sub_accounts/{sub_account_id} | Get product environment
*EnvironmentsApi* | [**getProductEnvironments**](docs/EnvironmentsApi.md#getProductEnvironments) | **GET** /sub_accounts | Get product environments
*EnvironmentsApi* | [**updateProductEnvironment**](docs/EnvironmentsApi.md#updateProductEnvironment) | **PUT** /sub_accounts/{sub_account_id} | Update product environment
*UserGroupsApi* | [**addUserToUserGroup**](docs/UserGroupsApi.md#addUserToUserGroup) | **POST** /user_groups/{group_id}/users/{user_id} | Add User to User Group
*UserGroupsApi* | [**createUserGroup**](docs/UserGroupsApi.md#createUserGroup) | **POST** /user_groups | Create User Group
*UserGroupsApi* | [**deleteUserGroup**](docs/UserGroupsApi.md#deleteUserGroup) | **DELETE** /user_groups/{group_id} | Delete User Group
*UserGroupsApi* | [**getUserGroup**](docs/UserGroupsApi.md#getUserGroup) | **GET** /user_groups/{group_id} | Get User Group
*UserGroupsApi* | [**getUserGroups**](docs/UserGroupsApi.md#getUserGroups) | **GET** /user_groups | Get User Groups
*UserGroupsApi* | [**getUsersInUserGroup**](docs/UserGroupsApi.md#getUsersInUserGroup) | **GET** /user_groups/{group_id}/users | Get Users in User Group
*UserGroupsApi* | [**removeUserFromUserGroup**](docs/UserGroupsApi.md#removeUserFromUserGroup) | **DELETE** /user_groups/{group_id}/users/{user_id} | Remove User from User Group
*UserGroupsApi* | [**updateUserGroup**](docs/UserGroupsApi.md#updateUserGroup) | **PUT** /user_groups/{group_id} | Update User Group
*UsersApi* | [**createUser**](docs/UsersApi.md#createUser) | **POST** /users | Create user
*UsersApi* | [**deleteUser**](docs/UsersApi.md#deleteUser) | **DELETE** /users/{user_id} | Delete user
*UsersApi* | [**getUser**](docs/UsersApi.md#getUser) | **GET** /users/{user_id} | Get user
*UsersApi* | [**getUsers**](docs/UsersApi.md#getUsers) | **GET** /users | Get users
*UsersApi* | [**updateUser**](docs/UsersApi.md#updateUser) | **PUT** /users/{user_id} | Update user


To add a HTTP proxy for the API client, use `ClientConfig`:
```java

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import com.cloudinary.provisioning.*;
import com.cloudinary.provisioning.api.AccessKeysApi;

...

ApiClient apiClient = Configuration.getDefaultApiClient();
// If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary url"> it'll be taken from environment variable
apiClient.setCloudinaryUrl("cloudinary://API_KEY:API_SECRET@CLOUD_NAME");

AccessKeysApi apiInstance = new AccessKeysApi(apiClient);

```

## Documentation for Models

 - [AccessKeyRequest](docs/AccessKeyRequest.md)
 - [AccessKeyResponse](docs/AccessKeyResponse.md)
 - [AccessKeyUpdateRequest](docs/AccessKeyUpdateRequest.md)
 - [AccessKeysResponse](docs/AccessKeysResponse.md)
 - [MessageResponse](docs/MessageResponse.md)
 - [ProductEnvironmentRequest](docs/ProductEnvironmentRequest.md)
 - [ProductEnvironmentResponse](docs/ProductEnvironmentResponse.md)
 - [ProductEnvironmentsResponse](docs/ProductEnvironmentsResponse.md)
 - [User](docs/User.md)
 - [UserGroup](docs/UserGroup.md)
 - [UserGroupRequest](docs/UserGroupRequest.md)
 - [UserGroupResponse](docs/UserGroupResponse.md)
 - [UserGroupUserRequest](docs/UserGroupUserRequest.md)
 - [UserGroupUserResponse](docs/UserGroupUserResponse.md)
 - [UserGroupUsersResponse](docs/UserGroupUsersResponse.md)
 - [UserGroupsResponse](docs/UserGroupsResponse.md)
 - [UserRequest](docs/UserRequest.md)
 - [UserResponse](docs/UserResponse.md)
 - [UsersResponse](docs/UsersResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### basicAuth


- **Type**: HTTP basic authentication


## Author

support@cloudinary.com

## About this package

This Cloudinary Java package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `0.0.1`
    - Package version: `0.0.1`
    - Build date: `2023-11-14T10:16:56.558721+02:00[Asia/Jerusalem]`
- Build package: `org.openapitools.codegen.languages.JavaClientCodegen`
