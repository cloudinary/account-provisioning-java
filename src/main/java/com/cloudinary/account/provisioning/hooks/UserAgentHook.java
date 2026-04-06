package com.cloudinary.account.provisioning.hooks;

import java.net.http.HttpRequest;

import com.cloudinary.account.provisioning.SDKConfiguration;
import com.cloudinary.account.provisioning.utils.Helpers;
import com.cloudinary.account.provisioning.utils.Hook;

/**
 * Replaces the default Speakeasy user-agent with a Cloudinary-branded one.
 *
 * <p>Format: {@code Cloudinary/AccountProvisioning Java/{sdkVersion} Gen/{genVersion} Schema/{schemaVersion} (Java {javaVersion}; {os} {arch})}
 */
final class UserAgentHook implements Hook.BeforeRequest {

    private final String cloudinaryUserAgent;

    UserAgentHook() {
        this.cloudinaryUserAgent = buildUserAgent();
    }

    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request)
            throws Exception {
        HttpRequest.Builder builder = Helpers.copy(request,
                (name, value) -> !name.equalsIgnoreCase("user-agent"));
        builder.header("user-agent", cloudinaryUserAgent);
        return builder.build();
    }

    private static String buildUserAgent() {
        String original = SDKConfiguration.USER_AGENT;
        if (original == null || !original.startsWith("speakeasy-sdk/")) {
            return original != null ? original : "Cloudinary/AccountProvisioning Java";
        }

        String[] parts = original.split(" ", 5);
        if (parts.length < 5) {
            return original;
        }

        String sdkVersion = parts[1];
        String genVersion = parts[2];
        String schemaVersion = parts[3];

        String javaVersion = System.getProperty("java.version", "unknown");
        String os = System.getProperty("os.name", "unknown");
        String arch = System.getProperty("os.arch", "unknown");

        return String.format(
                "Cloudinary/AccountProvisioning Java/%s Gen/%s Schema/%s (Java %s; %s %s)",
                sdkVersion, genVersion, schemaVersion, javaVersion, os, arch);
    }
}
