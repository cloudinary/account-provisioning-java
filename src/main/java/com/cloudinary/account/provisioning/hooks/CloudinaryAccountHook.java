package com.cloudinary.account.provisioning.hooks;

import java.net.http.HttpRequest;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

import com.cloudinary.account.provisioning.SDKConfiguration;
import com.cloudinary.account.provisioning.SecuritySource;
import com.cloudinary.account.provisioning.models.components.Security;
import com.cloudinary.account.provisioning.utils.Helpers;
import com.cloudinary.account.provisioning.utils.Hook;

/**
 * Populates account_id from CLOUDINARY_ACCOUNT_URL on init and attaches
 * Basic auth (provisioning_api_key:provisioning_api_secret) to every request.
 *
 * <p>Credential resolution order:
 * <ol>
 *   <li>Explicit security passed to the SDK constructor</li>
 *   <li>CLOUDINARY_ACCOUNT_URL / individual CLOUDINARY_* env vars</li>
 * </ol>
 */
final class CloudinaryAccountHook implements Hook.SdkInit, Hook.BeforeRequest {

    private final AccountConfig config;

    CloudinaryAccountHook(AccountConfig config) {
        this.config = config;
    }

    @Override
    public SDKConfiguration sdkInit(SDKConfiguration sdkConfig) {
        if (!config.accountId().isEmpty()
                && sdkConfig.globals.getPathParam("account_id").isEmpty()) {
            sdkConfig.globals.putParam("pathParam", "account_id", config.accountId());
        }
        return sdkConfig;
    }

    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request)
            throws Exception {
        String key = config.provisioningApiKey();
        String secret = config.provisioningApiSecret();

        if (context.securitySource().isPresent()) {
            SecuritySource source = context.securitySource().get();
            if (source.getSecurity() instanceof Security) {
                Security sec = (Security) source.getSecurity();
                if (sec.provisioningApiKey() != null && !sec.provisioningApiKey().isEmpty()) {
                    key = sec.provisioningApiKey();
                }
                if (sec.provisioningApiSecret() != null && !sec.provisioningApiSecret().isEmpty()) {
                    secret = sec.provisioningApiSecret();
                }
            }
        }

        if (key.isEmpty() || secret.isEmpty()) {
            throw new IllegalStateException("Provisioning API key and secret are required");
        }

        String credentials = key + ":" + secret;
        String encoded = Base64.getEncoder()
                .encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        HttpRequest.Builder builder = Helpers.copy(request);
        builder.header("Authorization", "Basic " + encoded);
        return builder.build();
    }
}
