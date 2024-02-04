package com.redleaf.entities;

import com.redleaf.NullPointer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityRegistry {
    public static final EntityType<EntityNullPointer> ENullPointer = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(NullPointer.MODID, "null_pointer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityNullPointer::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(ENullPointer, EntityNullPointer.createMobAttributes());
    }
}
