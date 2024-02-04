package com.redleaf.items;


import com.redleaf.NullPointer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    public static final ItemPointer ITEM_POINTER = new ItemPointer(new FabricItemSettings());
    public static final ItemNullPointer ITEM_NULL_POINTER = new ItemNullPointer(new FabricItemSettings());

    public static void register() {
        Registry.register(Registries.ITEM,
                new Identifier(NullPointer.MODID, "pointer"),
                ITEM_POINTER);
        Registry.register(Registries.ITEM,
                new Identifier(NullPointer.MODID, "null_pointer"),
                ITEM_NULL_POINTER);
    }
}
