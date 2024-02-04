package com.redleaf.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPointer extends Item {
    public boolean haveData = false;
    public BlockPos blockPos = null;

    public ItemPointer(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (player == null) return ActionResult.PASS;
        if (world.isClient()) return ActionResult.success(true);
        if (!this.haveData) {
            player.sendMessage(Text.translatable("item.nullpointer.pointer.tip1", pos.getX(), pos.getY(), pos.getZ()));
            this.blockPos = pos;
            this.haveData = true;
        } else {
            player.sendMessage(Text.translatable("item.nullpointer.pointer.tip2"));
            this.blockPos = null;
            this.haveData = false;
        }
        return ActionResult.success(false);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.haveData;
    }
}
