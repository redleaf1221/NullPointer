package com.redleaf;

import com.redleaf.render.EntityRenderRegistry;
import net.fabricmc.api.ClientModInitializer;

public class NullPointerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        EntityRenderRegistry.register();
    }
}