

# AccessKeyUpdateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The name of the access key. |  [optional] |
|**enabled** | **Boolean** | Whether the access key is enabled or disabled. |  [optional] |
|**dedicatedFor** | [**DedicatedForEnum**](#DedicatedForEnum) | Designates the access key for a specific purpose while allowing it to be used for other purposes, as well.  This action replaces any previously assigned key. **Possible values**: &#x60;webhooks&#x60;  |  [optional] |



## Enum: DedicatedForEnum

| Name | Value |
|---- | -----|
| WEBHOOKS | &quot;webhooks&quot; |



