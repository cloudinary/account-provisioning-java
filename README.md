# Cloudinary cloudinary-account-provisioning

    Accounts with provisioning API access can create and manage their **product environments**, **users** and **user groups** using the RESTful Provisioning API. 

Provisioning API access is available [upon request](https://cloudinary.com/contact?plan=enterprise) for accounts on an [Enterprise plan](https://cloudinary.com/pricing#pricing-enterprise).

The API uses **Basic Authentication** over HTTPS. Your **Provisioning Key** and **Provisioning Secret** are used for the authentication. These credentials (as well as your ACCOUNT_ID) are located in the [Cloudinary Console](https://console.cloudinary.com/pm) under **Settings > Account > Provisioning API Access**, or they can be obtained from the provisioning environment variable available on your Cloudinary Console [Dashboard](https://console.cloudinary.com/pm/developer-dashboard).

The Provisioning API has dedicated SDKs for the following languages:

* [JavaScript](https://github.com/cloudinary/account-provisioning-js)
* [PHP](https://github.com/cloudinary/account-provisioning-php)
* [Java](https://github.com/cloudinary/account-provisioning-java)

Useful links:
* [Provisioning API reference (Classic)](https://cloudinary.com/documentation/provisioning_api_1)


    For more information, please visit [https://support.cloudinary.com](https://support.cloudinary.com).

## Installation & Usage

## Requirements

Java 6 and later.

## Installation

The cloudinary_java library is available in Maven Central. To use it, add the following dependency to your pom.xml :
```xml
<dependency>
    <groupId>com.cloudinary.account.provisioning</groupId>
    <artifactId>cloudinary-account-provisioning</artifactId>
    <version>0.1.0</version>
    <scope>compile</scope>
</dependency>
```

## API Endpoints

All URIs are relative to *https://api.cloudinary.com/v1_1/provisioning/accounts/ACCOUNT_ID*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccessKeysApi* | [**deleteAccessKey**](docs/AccessKeysApi.md#deleteAccessKey) | **DELETE** /sub_accounts/{sub_account_id}/access_keys/{key} | Delete access key
*AccessKeysApi* | [**deleteAccessKeyByName**](docs/AccessKeysApi.md#deleteAccessKeyByName) | **DELETE** /sub_accounts/{sub_account_id}/access_keys | Delete access key by name
*AccessKeysApi* | [**generateAccessKey**](docs/AccessKeysApi.md#generateAccessKey) | **POST** /sub_accounts/{sub_account_id}/access_keys | Generate an access key
*AccessKeysApi* | [**getAccessKeys**](docs/AccessKeysApi.md#getAccessKeys) | **GET** /sub_accounts/{sub_account_id}/access_keys | Get access keys
*AccessKeysApi* | [**updateAccessKey**](docs/AccessKeysApi.md#updateAccessKey) | **PUT** /sub_accounts/{sub_account_id}/access_keys/{key} | Update an access key
*ProductEnvironmentsApi* | [**createProductEnvironment**](docs/ProductEnvironmentsApi.md#createProductEnvironment) | **POST** /sub_accounts | Create product environment
*ProductEnvironmentsApi* | [**deleteProductEnvironment**](docs/ProductEnvironmentsApi.md#deleteProductEnvironment) | **DELETE** /sub_accounts/{sub_account_id} | Delete product environment
*ProductEnvironmentsApi* | [**getProductEnvironment**](docs/ProductEnvironmentsApi.md#getProductEnvironment) | **GET** /sub_accounts/{sub_account_id} | Get product environment
*ProductEnvironmentsApi* | [**getProductEnvironments**](docs/ProductEnvironmentsApi.md#getProductEnvironments) | **GET** /sub_accounts | Get product environments
*ProductEnvironmentsApi* | [**updateProductEnvironment**](docs/ProductEnvironmentsApi.md#updateProductEnvironment) | **PUT** /sub_accounts/{sub_account_id} | Update product environment
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
import com.cloudinary.account.provisioning.*;
import com.cloudinary.account.provisioning.api.AccessKeysApi;

...

ApiClient apiClient = Configuration.getDefaultApiClient();
// If you don't supply cloudinary url through apiClient.setCloudinaryUrl("Cloudinary account url"> it'll be taken from environment variable
apiClient.setCloudinaryUrl("account://provisioning_key:provisioning_secret@account_id");

AccessKeysApi apiInstance = new AccessKeysApi(apiClient);

```

## Documentation for Models

 - [AccessKey](docs/AccessKey.md)
 - [AccessKeyRequest](docs/AccessKeyRequest.md)
 - [AccessKeyUpdateRequest](docs/AccessKeyUpdateRequest.md)
 - [AccessKeysResponse](docs/AccessKeysResponse.md)
 - [ApiAccessKey](docs/ApiAccessKey.md)
 - [CreateUserRequest](docs/CreateUserRequest.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [ErrorResponseError](docs/ErrorResponseError.md)
 - [ProductEnvironment](docs/ProductEnvironment.md)
 - [ProductEnvironmentRequest](docs/ProductEnvironmentRequest.md)
 - [ProductEnvironmentUpdateRequest](docs/ProductEnvironmentUpdateRequest.md)
 - [ProductEnvironmentsResponse](docs/ProductEnvironmentsResponse.md)
 - [SuccessResponse](docs/SuccessResponse.md)
 - [User](docs/User.md)
 - [UserGroup](docs/UserGroup.md)
 - [UserGroupRequest](docs/UserGroupRequest.md)
 - [UserGroupSummary](docs/UserGroupSummary.md)
 - [UserGroupUser](docs/UserGroupUser.md)
 - [UserGroupUsersResponse](docs/UserGroupUsersResponse.md)
 - [UserGroupsResponse](docs/UserGroupsResponse.md)
 - [UserRequest](docs/UserRequest.md)
 - [UsersResponse](docs/UsersResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### basicAuth


- **Type**: HTTP basic authentication


## Author

support@cloudinary.com

## About this package

This Cloudinary Java package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `0.1.2`
    - Package version: `0.1.0`
    - Build date: `2024-11-19T16:44:42.106539Z[Etc/UTC]`
- Build package: `org.openapitools.codegen.languages.JavaClientCodegen`
