package com.redleaf.mixin;

import com.redleaf.items.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class PointerToNullPointerMixin extends Entity {
    @Shadow
    @Nullable
    public abstract Entity getOwner();

    @Shadow
    public abstract ItemStack getStack();

    public PointerToNullPointerMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        //make sure we are in the server
        if (this.getWorld().isClient()) return;
        //make sure the item is a pointer
        if (!this.getStack().isOf(ItemRegistry.ITEM_POINTER)) return;
        //make sure the item is in the void
        if (this.getPos().getY() > this.getWorld().getBottomY()) return;
        //make sure there is a player who throw the item
        if (this.getOwner() == null || (!(this.getOwner() instanceof PlayerEntity))) return;
        //give him a null pointer
        ItemStack stack = new ItemStack(ItemRegistry.ITEM_NULL_POINTER, 1);
        ((PlayerEntity) this.getOwner()).giveItemStack(stack);
        //discard
        this.discard();
    }
}
