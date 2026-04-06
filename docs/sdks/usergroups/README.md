# UserGroups

## Overview

### Available Operations

* [list](#list) - Get User Groups
* [create](#create) - Create User Group
* [get](#get) - Get User Group
* [update](#update) - Update User Group
* [delete](#delete) - Delete User Group
* [listUsers](#listusers) - Get Users in User Group
* [addUser](#adduser) - Add User to User Group
* [removeUser](#removeuser) - Remove User from User Group

## list

Retrieve an array of all user groups in the account.

Learn more about retrieving user groups.
<https://cloudinary.com/documentation/provisioning_api#get_user_groups>

### Example Usage: UserGroups

<!-- UsageSnippet language="java" operationID="getUserGroups" method="get" path="/v1_1/provisioning/accounts/{account_id}/user_groups" example="UserGroups" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupsResponse;
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

        GetUserGroupsResponse res = sdk.userGroups().list()
                .extendedDetails(true)
                .call();

        if (res.userGroupsResponse().isPresent()) {
            System.out.println(res.userGroupsResponse().get());
        }
    }
}
```
### Example Usage: UserGroupsExtendedDetails

<!-- UsageSnippet language="java" operationID="getUserGroups" method="get" path="/v1_1/provisioning/accounts/{account_id}/user_groups" example="UserGroupsExtendedDetails" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupsResponse;
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

        GetUserGroupsResponse res = sdk.userGroups().list()
                .extendedDetails(true)
                .call();

        if (res.userGroupsResponse().isPresent()) {
            System.out.println(res.userGroupsResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               | Example                                                                                                   |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `extendedDetails`                                                                                         | *Optional\<Boolean>*                                                                                      | :heavy_minus_sign:                                                                                        | Whether to only return extended (true) or basic information about the group (false).<br/>**Default**: false.<br/> | true                                                                                                      |

### Response

**[GetUserGroupsResponse](../../models/operations/GetUserGroupsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## create

Create a new user group for the account.

Learn more about creating user groups.
<https://cloudinary.com/documentation/provisioning_api#create_user_group>

### Example Usage

<!-- UsageSnippet language="java" operationID="createUserGroup" method="post" path="/v1_1/provisioning/accounts/{account_id}/user_groups" example="UserGroupDesigners" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.components.UserGroupRequest;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.CreateUserGroupResponse;
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

        UserGroupRequest req = UserGroupRequest.builder()
                .name("Designers")
                .extendedDetails(false)
                .build();

        CreateUserGroupResponse res = sdk.userGroups().create()
                .request(req)
                .call();

        if (res.userGroup().isPresent()) {
            System.out.println(res.userGroup().get());
        }
    }
}
```

### Parameters

| Parameter                                                   | Type                                                        | Required                                                    | Description                                                 |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `request`                                                   | [UserGroupRequest](../../models/shared/UserGroupRequest.md) | :heavy_check_mark:                                          | The request object to use for the request.                  |

### Response

**[CreateUserGroupResponse](../../models/operations/CreateUserGroupResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## get

Retrieve a specific user group.

Learn more about retrieving a specific user group.
<https://cloudinary.com/documentation/provisioning_api#get_user_group>

### Example Usage: UserGroupDesigners

<!-- UsageSnippet language="java" operationID="getUserGroup" method="get" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}" example="UserGroupDesigners" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupResponse;
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

        GetUserGroupRequest req = GetUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .extendedDetails(true)
                .build();

        GetUserGroupResponse res = sdk.userGroups().get()
                .request(req)
                .call();

        if (res.userGroup().isPresent()) {
            System.out.println(res.userGroup().get());
        }
    }
}
```
### Example Usage: UserGroupDesignersExtendedDetails

<!-- UsageSnippet language="java" operationID="getUserGroup" method="get" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}" example="UserGroupDesignersExtendedDetails" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.GetUserGroupResponse;
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

        GetUserGroupRequest req = GetUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .extendedDetails(true)
                .build();

        GetUserGroupResponse res = sdk.userGroups().get()
                .request(req)
                .call();

        if (res.userGroup().isPresent()) {
            System.out.println(res.userGroup().get());
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [GetUserGroupRequest](../../models/operations/GetUserGroupRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[GetUserGroupResponse](../../models/operations/GetUserGroupResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## update

Update the name of a specified user group.

Learn more about updating a specific user group.
<https://cloudinary.com/documentation/provisioning_api#update_user_group>

### Example Usage: UserGroupDesignersRequest

<!-- UsageSnippet language="java" operationID="updateUserGroup" method="put" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}" example="UserGroupDesignersRequest" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.components.UserGroupRequest;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateUserGroupResponse;
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

        UpdateUserGroupRequest req = UpdateUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .userGroupRequest(UserGroupRequest.builder()
                    .name("Designers and Creatives")
                    .build())
                .build();

        UpdateUserGroupResponse res = sdk.userGroups().update()
                .request(req)
                .call();

        if (res.userGroup().isPresent()) {
            System.out.println(res.userGroup().get());
        }
    }
}
```
### Example Usage: UserGroupUpdate

<!-- UsageSnippet language="java" operationID="updateUserGroup" method="put" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}" example="UserGroupUpdate" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.components.UserGroupRequest;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.UpdateUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.UpdateUserGroupResponse;
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

        UpdateUserGroupRequest req = UpdateUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .userGroupRequest(UserGroupRequest.builder()
                    .name("Designers")
                    .extendedDetails(false)
                    .build())
                .build();

        UpdateUserGroupResponse res = sdk.userGroups().update()
                .request(req)
                .call();

        if (res.userGroup().isPresent()) {
            System.out.println(res.userGroup().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [UpdateUserGroupRequest](../../models/operations/UpdateUserGroupRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[UpdateUserGroupResponse](../../models/operations/UpdateUserGroupResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## delete

Delete a user group with the specified ID.

Learn more about deleting a specific user group.
<https://cloudinary.com/documentation/provisioning_api#delete_user_group>

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteUserGroup" method="delete" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.DeleteUserGroupResponse;
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

        DeleteUserGroupResponse res = sdk.userGroups().delete()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
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
| `groupId`                      | *String*                       | :heavy_check_mark:             | The ID of the user group.      | 7f08f1f1fc910bf1f25274aef11d27 |

### Response

**[DeleteUserGroupResponse](../../models/operations/DeleteUserGroupResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |

## listUsers

Retrieve the users in the group with the specified ID.

Learn more about retrieving users in a specific user group.
<https://cloudinary.com/documentation/provisioning_api#get_user_group_users>

### Example Usage

<!-- UsageSnippet language="java" operationID="getUsersInUserGroup" method="get" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}/users" example="UserGroupUsers" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetUsersInUserGroupResponse;
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

        GetUsersInUserGroupResponse res = sdk.userGroups().listUsers()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .call();

        if (res.userGroupUsersResponse().isPresent()) {
            System.out.println(res.userGroupUsersResponse().get());
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    | Example                        |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `groupId`                      | *String*                       | :heavy_check_mark:             | The ID of the user group.      | 7f08f1f1fc910bf1f25274aef11d27 |

### Response

**[GetUsersInUserGroupResponse](../../models/operations/GetUsersInUserGroupResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 401, 404, 420, 429          | application/json            |
| models/errors/SDKException  | 4XX, 5XX                    | \*/\*                       |

## addUser

Add a user to a group with the specified ID.

Learn more about adding users to a specific user group.
<https://cloudinary.com/documentation/provisioning_api#add_user_to_group>

### Example Usage

<!-- UsageSnippet language="java" operationID="addUserToUserGroup" method="post" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}/users/{user_id}" example="UserGroupUserJohn" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.AddUserToUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.AddUserToUserGroupResponse;
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

        AddUserToUserGroupRequest req = AddUserToUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .build();

        AddUserToUserGroupResponse res = sdk.userGroups().addUser()
                .request(req)
                .call();

        if (res.userGroupUser().isPresent()) {
            System.out.println(res.userGroupUser().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [AddUserToUserGroupRequest](../../models/operations/AddUserToUserGroupRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[AddUserToUserGroupResponse](../../models/operations/AddUserToUserGroupResponse.md)**

### Errors

| Error Type                        | Status Code                       | Content Type                      |
| --------------------------------- | --------------------------------- | --------------------------------- |
| models/errors/ErrorResponse       | 400, 401, 403, 404, 409, 420, 429 | application/json                  |
| models/errors/SDKException        | 4XX, 5XX                          | \*/\*                             |

## removeUser

Remove a user from a group with the specified ID.

Learn more about removing users from a specific user group.
<https://cloudinary.com/documentation/provisioning_api#remove_user_from_group>

### Example Usage

<!-- UsageSnippet language="java" operationID="removeUserFromUserGroup" method="delete" path="/v1_1/provisioning/accounts/{account_id}/user_groups/{group_id}/users/{user_id}" example="UserGroupUsers" -->
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.RemoveUserFromUserGroupRequest;
import com.cloudinary.account.provisioning.models.operations.RemoveUserFromUserGroupResponse;
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

        RemoveUserFromUserGroupRequest req = RemoveUserFromUserGroupRequest.builder()
                .groupId("7f08f1f1fc910bf1f25274aef11d27")
                .userId("0abed8dfcc039ea05e2a1d494fd442")
                .build();

        RemoveUserFromUserGroupResponse res = sdk.userGroups().removeUser()
                .request(req)
                .call();

        if (res.userGroupUsersResponse().isPresent()) {
            System.out.println(res.userGroupUsersResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                   | Type                                                                                        | Required                                                                                    | Description                                                                                 |
| ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `request`                                                                                   | [RemoveUserFromUserGroupRequest](../../models/operations/RemoveUserFromUserGroupRequest.md) | :heavy_check_mark:                                                                          | The request object to use for the request.                                                  |

### Response

**[RemoveUserFromUserGroupResponse](../../models/operations/RemoveUserFromUserGroupResponse.md)**

### Errors

| Error Type                   | Status Code                  | Content Type                 |
| ---------------------------- | ---------------------------- | ---------------------------- |
| models/errors/ErrorResponse  | 400, 401, 403, 404, 420, 429 | application/json             |
| models/errors/SDKException   | 4XX, 5XX                     | \*/\*                        |