package com.cloudinary.account.provisioning.hooks;

//
// This file is written once by speakeasy code generation and
// thereafter will not be overwritten by speakeasy updates. As a
// consequence any customization of this class will be preserved.
//

public final class SDKHooks {

    private SDKHooks() {
        // prevent instantiation
    }

    public static void initialize(com.cloudinary.account.provisioning.utils.Hooks hooks) {
        AccountConfig config = new AccountConfig();
        CloudinaryAccountHook accountHook = new CloudinaryAccountHook(config);

        hooks.registerSdkInit(accountHook);
        hooks.registerBeforeRequest(accountHook);
        hooks.registerBeforeRequest(new UserAgentHook());
    }

    public static void initialize(com.cloudinary.account.provisioning.utils.AsyncHooks asyncHooks) {
        AccountConfig config = new AccountConfig();
        CloudinaryAccountHook accountHook = new CloudinaryAccountHook(config);

        asyncHooks.registerBeforeRequest(
                com.cloudinary.account.provisioning.utils.HookAdapters.toAsync(accountHook));
        asyncHooks.registerBeforeRequest(
                com.cloudinary.account.provisioning.utils.HookAdapters.toAsync(new UserAgentHook()));
    }

}
