package com.redleaf.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
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
        ItemStack stack = context.getStack();
        // 如果玩家在 潜行 时 use 方块
        if (player != null && player.isSneaking()) {
            // 保存 方块位置
            String worldKey = world.getRegistryKey().getValue().toString();
            NbtCompound nbt = stack.getOrCreateNbt();
            nbt.putString("world", worldKey);
            nbt.putInt("x", pos.getX());
            nbt.putInt("y", pos.getY());
            nbt.putInt("z", pos.getZ());

            // 添加 Lore
            NbtList loreList = new NbtList();
            loreList.add(NbtString.of("{\"text\":\"world: " + worldKey + "\"}"));
            loreList.add(NbtString.of("{\"text\":\"X: " + pos.getX() + "\"}"));
            loreList.add(NbtString.of("{\"text\":\"Y: " + pos.getY() + "\"}"));
            loreList.add(NbtString.of("{\"text\":\"Z: " + pos.getZ() + "\"}"));

            NbtCompound display = new NbtCompound();
            display.put("Lore", loreList);
            nbt.put("display", display);

            nbt.putBoolean("PointTo", true);
            stack.setNbt(nbt);

        } else if (player != null) {
            // 检测 是否有 方块位置
            if (stack.getNbt() != null && stack.getNbt().getBoolean("PointTo")) {
                // 获取 方块位置
                NbtCompound nbt = stack.getNbt();
                player.sendMessage(Text.of(nbt.toString()));
            }
        }
        return ActionResult.success(false);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.haveData;
    }
}
