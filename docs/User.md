

# User

User details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The user&#39;s ID. |  [optional] |
|**name** | **String** | The user&#39;s name. |  [optional] |
|**role** | **String** | The user&#39;s role. |  [optional] |
|**email** | **String** | The user&#39;s email. |  [optional] |
|**pending** | **Boolean** | Whether the user is pending. |  [optional] |
|**enabled** | **Boolean** | Whether the user is enabled. |  [optional] |
|**createdAt** | **OffsetDateTime** | The date when the user was created. |  [optional] |
|**updatedAt** | **OffsetDateTime** | The date when the user was last updated. |  [optional] |
|**lastLogin** | **OffsetDateTime** | The date when the user was last logged in. |  [optional] |
|**allSubAccounts** | **Boolean** |  |  [optional] |
|**groups** | [**List&lt;UserGroupSummary&gt;**](UserGroupSummary.md) | The list of user groups. |  [optional] |
|**subAccountIds** | **String** | The list of the product environments IDs. |  [optional] |



