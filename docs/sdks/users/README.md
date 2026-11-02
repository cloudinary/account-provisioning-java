# Users

## Overview

Manage the users for your account.


Learn more about users management.
<https://cloudinary.com/documentation/provisioning_api#users>

### Available Operations

* [list](#list) - Get users
* [create](#create) - Create user
* [get](#get) - Get user
* [update](#update) - Update user
* [delete](#delete) - Delete user
* [getGroups](#getgroups) - Get user groups
* [listSubAccounts](#listsubaccounts) - Get user sub-accounts

## list

Returns an array of all users in the account, or if conditions are specified, returns the relevant users.


Learn more about retrieving users.
<https://cloudinary.com/documentation/provisioning_api#get_users>

### Example Usage

<!-- UsageSnippet language="java" operationID="getUsers" method="get" path="/v1_1/provisioning/accounts/{account_id}/users" example="Users" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUsersRequest;
import com.cloudinary.account.provisioning.models.operations.GetUsersResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetUsersRequest req = GetUsersRequest.builder()
                .pending(false)
                .prefix("john")
                .from(LocalDate.parse("2023-01-01T00:00:00Z"))
                .to(LocalDate.parse("2024-12-31T00:00:00Z"))
                .build();

        GetUsersResponse res = sdk.users().list()
                .request(req)
                .call();

        if (res.usersResponse().isPresent()) {
            System.out.println(res.usersResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `request`                                                     | [GetUsersRequest](../../models/operations/GetUsersRequest.md) | :heavy_check_mark:                                            | The request object to use for the request.                    |

### Response

**[GetUsersResponse](../../models/operations/GetUsersResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## create

Create a new user.

Learn more about creating users.
<https://cloudinary.com/documentation/provisioning_api#create_user>

### Example Usage: CreateUserExample

<!-- UsageSnippet language="java" operationID="createUser" method="post" path="/v1_1/provisioning/accounts/{account_id}/users" example="CreateUserExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.*;
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

        CreateUserRequestBody req = CreateUserRequestBody.builder()
                .name("jenny_bar")
                .email("jenny_bar@example.com")
                .role(Role.MASTER_ADMIN)
                .build();

        CreateUserResponse res = sdk.users().create()
                .request(req)
                .call();

        if (res.user().isPresent()) {
            System.out.println(res.user().get());
        }
    }
}
```
### Example Usage: UserResponseExample

<!-- UsageSnippet language="java" operationID="createUser" method="post" path="/v1_1/provisioning/accounts/{account_id}/users" example="UserResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.RoleAssignment;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateUserRequestBody;
import com.cloudinary.account.provisioning.models.operations.CreateUserResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        CreateUserRequestBody req = CreateUserRequestBody.builder()
                .name("John")
                .email("john@example.com")
                .enabled(true)
                .roles(List.of(
                    RoleAssignment.builder()
                        .id("media_library_admin")
                        .build()))
                .build();

        CreateUserResponse res = sdk.users().create()
                .request(req)
                .call();

        if (res.user().isPresent()) {
            System.out.println(res.user().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateUserRequestBody](../../models/operations/CreateUserRequestBody.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreateUserResponse](../../models/operations/CreateUserResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## get

Retrieve a specific user.

Learn more about retrieving a specific user.
<https://cloudinary.com/documentation/provisioning_api#get_user>

### Example Usage

<!-- UsageSnippet language="java" operationID="getUser" method="get" path="/v1_1/provisioning/accounts/{account_id}/users/{user_id}" example="UserResponseExample" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUserResponse;
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

        GetUserResponse res = sdk.users().get()
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .call();

        if (res.user().isPresent()) {
            System.out.println(res.user().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    | Example                        |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userId`                       | *String*                       | :heavy_check_mark:             | The ID of the user.            | 0abed8dfcc039ea05e2a1d494fd442 |

### Response

**[GetUserResponse](../../models/operations/GetUserResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## update

Update the details of a user.

Learn more about updating a specific user.
<https://cloudinary.com/documentation/provisioning_api#update_user>

### Example Usage

<!-- UsageSnippet language="java" operationID="updateUser" method="put" path="/v1_1/provisioning/accounts/{account_id}/users/{user_id}" example="UserJohn" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.*;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        UpdateUserRequest req = UpdateUserRequest.builder()
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .requestBody(UpdateUserRequestBody.builder()
                    .name("John")
                    .email("john@example.com")
                    .enabled(true)
                    .roleManagement(RoleManagementRequest.builder()
                        .operation(Operation.ADD)
                        .roles(List.of())
                        .build())
                    .build())
                .build();

        UpdateUserResponse res = sdk.users().update()
                .request(req)
                .call();

        if (res.user().isPresent()) {
            System.out.println(res.user().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [UpdateUserRequest](../../models/operations/UpdateUserRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[UpdateUserResponse](../../models/operations/UpdateUserResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete a specific user.

Learn more about deleting a specific user.
<https://cloudinary.com/documentation/provisioning_api#delete_user>

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteUser" method="delete" path="/v1_1/provisioning/accounts/{account_id}/users/{user_id}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteUserResponse;
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

        DeleteUserResponse res = sdk.users().delete()
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .call();

        if (res.successResponse().isPresent()) {
            System.out.println(res.successResponse().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    | Example                        |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userId`                       | *String*                       | :heavy_check_mark:             | The ID of the user.            | 0abed8dfcc039ea05e2a1d494fd442 |

### Response

**[DeleteUserResponse](../../models/operations/DeleteUserResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |

## getGroups

Retrieve the groups that a specific user belongs to.

Learn more about retrieving user groups.
<https://cloudinary.com/documentation/provisioning_api#get_users_groups>

### Example Usage

<!-- UsageSnippet language="java" operationID="getGroupsForUser" method="get" path="/v1_1/provisioning/accounts/{account_id}/users/{user_id}/groups" example="UserGroupsList" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetGroupsForUserResponse;
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

        GetGroupsForUserResponse res = sdk.users().getGroups()
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .call();

        if (res.userGroupsListResponse().isPresent()) {
            System.out.println(res.userGroupsListResponse().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    | Example                        |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userId`                       | *String*                       | :heavy_check_mark:             | The ID of the user.            | 0abed8dfcc039ea05e2a1d494fd442 |

### Response

**[GetGroupsForUserResponse](../../models/operations/GetGroupsForUserResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## listSubAccounts

Retrieve the product environments (sub-accounts) that a specific user has access to.

Learn more about retrieving user sub-accounts.
<https://cloudinary.com/documentation/provisioning_api#get_user_sub_accounts>

### Example Usage

<!-- UsageSnippet language="java" operationID="getSubAccountsForUser" method="get" path="/v1_1/provisioning/accounts/{account_id}/users/{user_id}/sub_accounts" example="UserSubAccounts" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetSubAccountsForUserResponse;
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

        GetSubAccountsForUserResponse res = sdk.users().listSubAccounts()
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .call();

        if (res.userSubAccountsResponse().isPresent()) {
            System.out.println(res.userSubAccountsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    | Example                        |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `userId`                       | *String*                       | :heavy_check_mark:             | The ID of the user.            | 0abed8dfcc039ea05e2a1d494fd442 |

### Response

**[GetSubAccountsForUserResponse](../../models/operations/GetSubAccountsForUserResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |