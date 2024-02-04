package com.redleaf.entities;


import com.redleaf.items.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityNullPointer extends ThrownItemEntity {
    public EntityNullPointer(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public EntityNullPointer(World world, LivingEntity owner) {
        super(EntityRegistry.ENTITY_NULL_POINTER, owner, world); // null will be changed later
    }

    public EntityNullPointer(World world, double x, double y, double z) {
        super(EntityRegistry.ENTITY_NULL_POINTER, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.ITEM_NULL_POINTER;
    }
}
