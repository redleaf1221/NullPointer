package com.redleaf.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class ItemPointer extends Item {

    public ItemPointer(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (!world.isClient){
            BlockState state = world.getBlockState(pos);
            BlockEntity entity = world.getBlockEntity(pos);


            player.sendMessage(Text.literal(state.toString()));
            player.sendMessage(Text.literal(entity.toString()));
        }
        return ActionResult.success(world.isClient());
    }
}
