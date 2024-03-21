

# CreateUserRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The user&#39;s name. |  |
|**email** | **String** | A unique email address, which serves as the login name and notification address. |  |
|**role** | [**RoleEnum**](#RoleEnum) | The role to assign. |  |
|**subAccountIds** | **List&lt;String&gt;** | A list of product environment IDs that this user can access. Ignored if the role is &#x60;master_admin&#x60;.  **Default**: all product environments.  |  [optional] |
|**enabled** | **Boolean** | Whether the user is enabled. **Default**: true.  |  [optional] |



## Enum: RoleEnum

| Name | Value |
|---- | -----|
| MASTER_ADMIN | &quot;master_admin&quot; |
| ADMIN | &quot;admin&quot; |
| BILLING | &quot;billing&quot; |
| TECHNICAL_ADMIN | &quot;technical_admin&quot; |
| REPORTS | &quot;reports&quot; |
| MEDIA_LIBRARY_ADMIN | &quot;media_library_admin&quot; |
| MEDIA_LIBRARY_USER | &quot;media_library_user&quot; |



