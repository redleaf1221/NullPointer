package com.redleaf.entities;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.redleaf.NullPointer.MODID;

public class EntityRegistry {
    public static final EntityType<EntityNullPointer> NULL_POINTER_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MODID, "null_pointer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityNullPointer::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    public static void register(){
        FabricDefaultAttributeRegistry.register(NULL_POINTER_ENTITY, EntityNullPointer.createLivingAttributes());
    }
}
