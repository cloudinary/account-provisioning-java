# Cloudinary Account Provisioning Java SDK

[![Maven Central](https://img.shields.io/maven-central/v/com.cloudinary.account.provisioning/cloudinary-account-provisioning.svg)](https://central.sonatype.com/artifact/com.cloudinary.account.provisioning/cloudinary-account-provisioning)
[![License](https://img.shields.io/github/license/cloudinary/account-provisioning-java.svg)](https://github.com/cloudinary/account-provisioning-java/blob/main/LICENSE)

Developer-friendly & type-safe Java SDK for the [Cloudinary Account Provisioning](https://cloudinary.com/documentation/provisioning_api_1) and Permissions APIs.

<!-- Start Summary [summary] -->
## Summary

Cloudinary Account Provisioning API: Accounts with provisioning API access can create and manage their **product environments**, **users** and **user groups** using the RESTful Provisioning API. 

Provisioning API access is available [upon request](https://cloudinary.com/contact?plan=enterprise) for accounts on an [Enterprise plan](https://cloudinary.com/pricing#pricing-enterprise).

The API uses **Basic Authentication** over HTTPS. Your **Account API Key** and **Account API Secret** (previously referred to as **Provisioning API keys**) are used for the authentication. These credentials (as well as your ACCOUNT_ID) are located in the [Cloudinary Console](https://console.cloudinary.com/pm) under **Settings > Account API Keys**.

The Provisioning API has dedicated SDKs for the following languages:

* [JavaScript](https://github.com/cloudinary/account-provisioning-js)
* [PHP](https://github.com/cloudinary/account-provisioning-php)
* [Java](https://github.com/cloudinary/account-provisioning-java)

Useful links:
* [Provisioning API reference (Classic)](https://cloudinary.com/documentation/provisioning_api_1) (includes SDKs for additional languages)

Accounts with Permissions API access can assign roles, made up of system policies, to control what principals (users, groups, and API keys) can do across the Cloudinary account and product environments. For more information about Cloudinary roles and permissions, see the [Role-based permissions](permissions_overview) guide.

Permissions API access is available [upon request](https://cloudinary.com/contact?plan=enterprise) for accounts on an [Enterprise plan](https://cloudinary.com/pricing#pricing-enterprise).

The API uses **Basic Authentication** over HTTPS. Your **Account API Key** and **Account API Secret** (previously referred to as **Provisioning API keys**) are used for the authentication. These credentials (as well as your ACCOUNT_ID) are located in the [Cloudinary Console](https://console.cloudinary.com/app/settings/account-api-keys) under **Settings > Account API Keys**.

_**Important:**_

_Cloudinary's **Roles and Permissions Management** is now available as a **Beta**. This is an early stage release, and while it's functional and ready for real-world testing, it's subject to change as we continue refining the experience based on what we learn, including your feedback.
During the Beta period, core functionality is considered stable, though some APIs, scopes, or response formats may evolve._

_**How you can help:**_

* _Use Roles and Permissions Management in real projects, prototypes, or tests._
* _Share feedback, issues, or ideas with our support team._

_Thank you for exploring this early release and helping us shape these tools to best meet your needs._
<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [Cloudinary Account Provisioning Java SDK](#cloudinary-account-provisioning-java-sdk)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Asynchronous Support](#asynchronous-support)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Global Parameters](#global-parameters)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
  * [Jackson Configuration](#jackson-configuration)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.cloudinary.account.provisioning:cloudinary-account-provisioning:0.3.0'
```

Maven:
```xml
<dependency>
    <groupId>com.cloudinary.account.provisioning</groupId>
    <artifactId>cloudinary-account-provisioning</artifactId>
    <version>0.3.0</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
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

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import com.cloudinary.account.provisioning.AsyncCldProvisioning;
import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.async.GetProductEnvironmentsResponse;
import java.util.concurrent.CompletableFuture;

public class Application {

    public static void main(String[] args) {

        AsyncCldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build()
            .async();

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        CompletableFuture<GetProductEnvironmentsResponse> resFut = sdk.productEnvironments().list()
                .request(req)
                .call();

        resFut.thenAccept(res -> {
            if (res.productEnvironmentsResponse().isPresent()) {
                System.out.println(res.productEnvironmentsResponse().get());
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
<!-- End SDK Example Usage [usage] -->

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name                                             | Type | Scheme      | Environment Variable                                                       |
| ------------------------------------------------ | ---- | ----------- | -------------------------------------------------------------------------- |
| `provisioningApiKey`<br/>`provisioningApiSecret` | http | Custom HTTP | `CLOUDINARY_PROVISIONING_API_KEY`<br/>`CLOUDINARY_PROVISIONING_API_SECRET` |

You can set the security parameters through the `security` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
                .accountId("<id>")
            .build();

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [AccessKeys](docs/sdks/accesskeys/README.md)

* [list](docs/sdks/accesskeys/README.md#list) - Get access keys
* [generate](docs/sdks/accesskeys/README.md#generate) - Generate an access key
* [deleteByName](docs/sdks/accesskeys/README.md#deletebyname) - Delete access key by name
* [update](docs/sdks/accesskeys/README.md#update) - Update an access key
* [delete](docs/sdks/accesskeys/README.md#delete) - Delete access key

### [BillingUsage](docs/sdks/billingusage/README.md)

* [get](docs/sdks/billingusage/README.md#get) - Get billing usage information

### [CustomPolicies](docs/sdks/custompolicies/README.md)

* [list](docs/sdks/custompolicies/README.md#list) - Get custom policies
* [create](docs/sdks/custompolicies/README.md#create) - Create custom policy
* [get](docs/sdks/custompolicies/README.md#get) - Get custom policy
* [update](docs/sdks/custompolicies/README.md#update) - Update custom policy
* [delete](docs/sdks/custompolicies/README.md#delete) - Delete custom policy

### [EffectivePolicies](docs/sdks/effectivepolicies/README.md)

* [list](docs/sdks/effectivepolicies/README.md#list) - Get effective policies

### [Principals](docs/sdks/principals/README.md)

* [listRoles](docs/sdks/principals/README.md#listroles) - Get a principal's roles
* [updateRoles](docs/sdks/principals/README.md#updateroles) - Assign roles to a principal
* [inspect](docs/sdks/principals/README.md#inspect) - Inspect
* [inspectMultiple](docs/sdks/principals/README.md#inspectmultiple) - Inspect multiple

### [ProductEnvironments](docs/sdks/productenvironments/README.md)

* [list](docs/sdks/productenvironments/README.md#list) - Get product environments
* [create](docs/sdks/productenvironments/README.md#create) - Create product environment
* [get](docs/sdks/productenvironments/README.md#get) - Get product environment
* [update](docs/sdks/productenvironments/README.md#update) - Update product environment
* [delete](docs/sdks/productenvironments/README.md#delete) - Delete product environment

### [Public](docs/sdks/public/README.md)

* [getCatalog](docs/sdks/public/README.md#getcatalog) - Get system roles and policies catalog
* [validatePolicy](docs/sdks/public/README.md#validatepolicy) - Validate a Cedar policy
* [getSchema](docs/sdks/public/README.md#getschema) - Get Cedar schema

### [Roles](docs/sdks/roles/README.md)

* [list](docs/sdks/roles/README.md#list) - Get roles
* [create](docs/sdks/roles/README.md#create) - Create custom role
* [get](docs/sdks/roles/README.md#get) - Get role
* [update](docs/sdks/roles/README.md#update) - Update custom role
* [delete](docs/sdks/roles/README.md#delete) - Delete custom role
* [listPrincipals](docs/sdks/roles/README.md#listprincipals) - Get a role's principals
* [updatePrincipals](docs/sdks/roles/README.md#updateprincipals) - Assign principals to a role

### [SystemPolicies](docs/sdks/systempolicies/README.md)

* [list](docs/sdks/systempolicies/README.md#list) - Get system policies

### [UserGroups](docs/sdks/usergroups/README.md)

* [list](docs/sdks/usergroups/README.md#list) - Get User Groups
* [create](docs/sdks/usergroups/README.md#create) - Create User Group
* [get](docs/sdks/usergroups/README.md#get) - Get User Group
* [update](docs/sdks/usergroups/README.md#update) - Update User Group
* [delete](docs/sdks/usergroups/README.md#delete) - Delete User Group
* [listUsers](docs/sdks/usergroups/README.md#listusers) - Get Users in User Group
* [addUser](docs/sdks/usergroups/README.md#adduser) - Add User to User Group
* [removeUser](docs/sdks/usergroups/README.md#removeuser) - Remove User from User Group

### [Users](docs/sdks/users/README.md)

* [list](docs/sdks/users/README.md#list) - Get users
* [create](docs/sdks/users/README.md#create) - Create user
* [get](docs/sdks/users/README.md#get) - Get user
* [update](docs/sdks/users/README.md#update) - Update user
* [delete](docs/sdks/users/README.md#delete) - Delete user
* [getGroups](docs/sdks/users/README.md#getgroups) - Get user groups
* [listSubAccounts](docs/sdks/users/README.md#listsubaccounts) - Get user sub-accounts

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Global Parameters [global-parameters] -->
## Global Parameters

A parameter is configured globally. This parameter may be set on the SDK client instance itself during initialization. When configured as an option during SDK initialization, This global value will be used as the default on the operations that use it. When such operations are called, there is a place in each to override the global value, if needed.

For example, you can set `account_id` to `"<id>"` at SDK initialization and then you do not have to pass the same value on calls to operations like `list`. But if you want to do so you may, which will locally override the global setting. See the example code below for a demonstration.


### Available Globals

The following global parameter is available.
Global parameters can also be set via environment variable.

| Name      | Type             | Description | Environment           |
| --------- | ---------------- | ----------- | --------------------- |
| accountId | java.lang.String | Account ID  | CLOUDINARY_ACCOUNT_ID |

### Example

```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
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

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```
<!-- End Global Parameters [global-parameters] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.


[`CldProvisioningException`](./src/main/java/models/errors/CldProvisioningException.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers`        | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `byte[]`                    | HTTP body as a byte array. Can be empty array if no body is returned.    |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Error;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.CldProvisioningException;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
import java.io.UncheckedIOException;
import java.lang.Exception;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();
        try {

            GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                    .enabled(true)
                    .prefix("product")
                    .build();

            GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                    .request(req)
                    .call();

            if (res.productEnvironmentsResponse().isPresent()) {
                System.out.println(res.productEnvironmentsResponse().get());
            }
        } catch (CldProvisioningException ex) { // all SDK exceptions inherit from CldProvisioningException

            // ex.ToString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.first("Content-Type");
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();

            // different error subclasses may be thrown 
            // depending on the service call
            if (ex instanceof ErrorResponse) {
                var e = (ErrorResponse) ex;
                // Check error data fields
                e.data().ifPresent(payload -> {
                      Optional<Error> error = payload.error();
                });
            }

            // An underlying cause may be provided. If the error payload 
            // cannot be deserialized then the deserialization exception 
            // will be set as the cause.
            if (ex.getCause() != null) {
                var cause = ex.getCause();
            }
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }    }
}
```

### Error Classes
**Primary error:**
* [`CldProvisioningException`](./src/main/java/models/errors/CldProvisioningException.java): The base class for HTTP error responses.

<details><summary>Less common errors (8)</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`CldProvisioningException`](./src/main/java/models/errors/CldProvisioningException.java)**:
* [`com.cloudinary.account.provisioning.models.errors.ErrorResponse`](./src/main/java/models/errors/com.cloudinary.account.provisioning.models.errors.ErrorResponse.java): Bad request. Applicable to 26 of 47 methods.*
* [`com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse`](./src/main/java/models/errors/com.cloudinary.account.provisioning.models.errors.PermissionsErrorResponse.java): Applicable to 18 of 47 methods.*


</details>

\* Check [the method documentation](#available-resources-and-operations) to see if the error is applicable.
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Index

You can override the default server globally using the `.serverIndex(int serverIdx)` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the indexes associated with the available servers:

| #   | Server                            | Variables | Description                                     |
| --- | --------------------------------- | --------- | ----------------------------------------------- |
| 0   | `https://{region}.cloudinary.com` | `region`  | Regional API endpoints for optimal performance. |
| 1   | `https://{host}`                  | `host`    | Custom domains for enterprise deployments.      |

If the selected server has variables, you may override its default values using the associated builder method(s):

| Variable | BuilderMethod                 | Supported Values                            | Default                | Description                 |
| -------- | ----------------------------- | ------------------------------------------- | ---------------------- | --------------------------- |
| `region` | `region(ServerRegion region)` | - `"api"`<br/>- `"api-eu"`<br/>- `"api-ap"` | `"api"`                | Regional endpoint selection |
| `host`   | `host(String host)`           | java.lang.String                            | `"api.cloudinary.com"` | API host domain.            |

#### Example

```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.SDK.Builder.ServerRegion;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .serverIndex(0)
                .region(ServerRegion.API_AP)
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```

### Override Server URL Per-Client

The default server can also be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.models.errors.ErrorResponse;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsRequest;
import com.cloudinary.account.provisioning.models.operations.GetProductEnvironmentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        CldProvisioning sdk = CldProvisioning.builder()
                .serverURL("https://api.cloudinary.com")
                .accountId("<id>")
                .security(Security.builder()
                    .provisioningApiKey("CLOUDINARY_PROVISIONING_API_KEY")
                    .provisioningApiSecret("CLOUDINARY_PROVISIONING_API_SECRET")
                    .build())
            .build();

        GetProductEnvironmentsRequest req = GetProductEnvironmentsRequest.builder()
                .enabled(true)
                .prefix("product")
                .build();

        GetProductEnvironmentsResponse res = sdk.productEnvironments().list()
                .request(req)
                .call();

        if (res.productEnvironmentsResponse().isPresent()) {
            System.out.println(res.productEnvironmentsResponse().get());
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Custom HTTP Client [http-client] -->
## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `SpeakeasyHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.utils.HTTPClient;
import com.cloudinary.account.provisioning.utils.SpeakeasyHTTPClient;
import com.cloudinary.account.provisioning.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new SpeakeasyHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        CldProvisioning sdk = CldProvisioning.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.utils.HTTPClient;
import com.cloudinary.account.provisioning.utils.Blob;
import com.cloudinary.account.provisioning.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        CldProvisioning sdk = CldProvisioning.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

You can also enable debug logging on the default `SpeakeasyHTTPClient`:

```java
import com.cloudinary.account.provisioning.CldProvisioning;
import com.cloudinary.account.provisioning.utils.SpeakeasyHTTPClient;

public class Application {
    public static void main(String[] args) {
        SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
        httpClient.enableDebugLogging(true);

        CldProvisioning sdk = CldProvisioning.builder()
            .client(httpClient)
            .build();
    }
}
```
<!-- End Custom HTTP Client [http-client] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug

You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:

```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This logging should only be used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.


Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Start Jackson Configuration [jackson] -->
## Jackson Configuration

The SDK ships with a pre-configured Jackson [`ObjectMapper`][jackson-databind] accessible via
`JSON.getMapper()`. It is set up with type modules, strict deserializers, and the feature flags
needed for full SDK compatibility (including ISO-8601 `OffsetDateTime` serialization):

```java
import com.cloudinary.account.provisioning.utils.JSON;

String json = JSON.getMapper().writeValueAsString(response);
```

To compose with your own `ObjectMapper`, register the provided `CloudinaryAccountProvisioningJacksonModule`, which
bundles all the same modules and feature flags as a single plug-and-play module:

```java
import com.cloudinary.account.provisioning.utils.CloudinaryAccountProvisioningJacksonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper myMapper = new ObjectMapper()
    .registerModule(new CloudinaryAccountProvisioningJacksonModule());

String json = myMapper.writeValueAsString(response);
```

[jackson-databind]: https://github.com/FasterXML/jackson-databind
[jackson-jsr310]: https://github.com/FasterXML/jackson-modules-java8/tree/master/datetime
<!-- End Jackson Configuration [jackson] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=cloudinary-account-provisioning&utm_campaign=java)
