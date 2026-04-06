# MetricUsage


## Fields

| Field                                                                        | Type                                                                         | Required                                                                     | Description                                                                  |
| ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| `metric`                                                                     | *Optional\<String>*                                                          | :heavy_minus_sign:                                                           | The type of metric being measured (e.g., "credit").                          |
| `limit`                                                                      | *Optional\<Double>*                                                          | :heavy_minus_sign:                                                           | The limit for this metric in the plan.                                       |
| `cycles`                                                                     | List\<[Cycles](../../models/components/Cycles.md)>                           | :heavy_minus_sign:                                                           | Full usage details per billing cycle (monthly or annual, depending on plan). |
| `monthlyCycles`                                                              | List\<[MonthlyCycles](../../models/components/MonthlyCycles.md)>             | :heavy_minus_sign:                                                           | Monthly-level breakdown within a single annual cycle.                        |