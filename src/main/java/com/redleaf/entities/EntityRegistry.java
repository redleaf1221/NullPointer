package com.redleaf.entities;


import com.redleaf.NullPointer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.redleaf.NullPointer.MODID;

public class EntityRegistry {
    public static final EntityType<EntityNullPointer> ENTITY_NULL_POINTER = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MODID, "null_pointer"),
            FabricEntityTypeBuilder.<EntityNullPointer>create(SpawnGroup.MISC, EntityNullPointer::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void register() {
        NullPointer.LOGGER.info(ENTITY_NULL_POINTER.getName() + " is registered");
    }
}
