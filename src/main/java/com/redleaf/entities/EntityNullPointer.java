package com.redleaf.entities;


import com.redleaf.items.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
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

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (this.getWorld().isClient()) return;
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof PlayerEntity) entity.damage(this.getDamageSources().genericKill(), 100);
        else entity.discard();
        this.discard();
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (this.getWorld().isClient()) return;
        if (hitResult.getType() == HitResult.Type.ENTITY) return;
        this.discard();
        Object crash = null;
        crash.hashCode();
    }
}
