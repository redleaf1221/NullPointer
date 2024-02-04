package com.redleaf.entities;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class EntityNullPointer extends PathAwareEntity {
    public EntityNullPointer(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
