# ErrorResponse

Bad request.


## Fields

| Field                                                                                                                | Type                                                                                                                 | Required                                                                                                             | Description                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| `error`                                                                                                              | [Optional\<Error>](../../models/components/Error.md)                                                                 | :heavy_minus_sign:                                                                                                   | N/A                                                                                                                  |
| `rawResponse`                                                                                                        | [HttpResponse\<?>](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpResponse.html) | :heavy_minus_sign:                                                                                                   | Raw HTTP response; suitable for custom response parsing                                                              |