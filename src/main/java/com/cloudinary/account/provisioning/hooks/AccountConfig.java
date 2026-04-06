package com.cloudinary.account.provisioning.hooks;

import java.net.URI;

/**
 * Holds Cloudinary account provisioning credentials parsed from
 * CLOUDINARY_ACCOUNT_URL or individual CLOUDINARY_* environment variables.
 *
 * <p>URL format: {@code account://<provisioning_api_key>:<provisioning_api_secret>@<account_id>}
 */
final class AccountConfig {

    private String accountId = "";
    private String provisioningApiKey = "";
    private String provisioningApiSecret = "";

    AccountConfig() {
        String accountUrl = System.getenv("CLOUDINARY_ACCOUNT_URL");
        if (accountUrl != null && !accountUrl.isEmpty()) {
            loadFromUrl(accountUrl);
        }

        String v;
        if ((v = System.getenv("CLOUDINARY_ACCOUNT_ID")) != null && !v.isEmpty()) {
            this.accountId = v;
        }
        if ((v = System.getenv("CLOUDINARY_PROVISIONING_API_KEY")) != null && !v.isEmpty()) {
            this.provisioningApiKey = v;
        }
        if ((v = System.getenv("CLOUDINARY_PROVISIONING_API_SECRET")) != null && !v.isEmpty()) {
            this.provisioningApiSecret = v;
        }
    }

    private void loadFromUrl(String rawUrl) {
        URI uri = URI.create(rawUrl);
        if (!"account".equals(uri.getScheme())) {
            throw new IllegalArgumentException(
                    "Invalid CLOUDINARY_ACCOUNT_URL scheme, expecting 'account://'");
        }
        this.accountId = uri.getHost();
        String userInfo = uri.getUserInfo();
        if (userInfo != null) {
            int colon = userInfo.indexOf(':');
            if (colon >= 0) {
                this.provisioningApiKey = userInfo.substring(0, colon);
                this.provisioningApiSecret = userInfo.substring(colon + 1);
            } else {
                this.provisioningApiKey = userInfo;
            }
        }
    }

    String accountId() {
        return accountId;
    }

    String provisioningApiKey() {
        return provisioningApiKey;
    }

    String provisioningApiSecret() {
        return provisioningApiSecret;
    }
}
