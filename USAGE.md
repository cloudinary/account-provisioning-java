<!-- Start SDK Example Usage [usage] -->
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
<!-- End SDK Example Usage [usage] -->