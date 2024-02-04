package com.redleaf.render;

import com.redleaf.entities.EntityRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class EntityRenderRegistry {
    public static void register() {
        EntityRendererRegistry.register(EntityRegistry.ENTITY_NULL_POINTER, FlyingItemEntityRenderer::new);
    }
}
