# RoleManagementRequest

A role management operation and the roles it applies to.


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        | Example                                                            |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `operation`                                                        | [Operation](../../models/components/Operation.md)                  | :heavy_check_mark:                                                 | Whether to add or remove the listed roles.                         | add                                                                |
| `roles`                                                            | List\<[RoleAssignment](../../models/components/RoleAssignment.md)> | :heavy_check_mark:                                                 | The roles to add or remove.                                        |                                                                    |