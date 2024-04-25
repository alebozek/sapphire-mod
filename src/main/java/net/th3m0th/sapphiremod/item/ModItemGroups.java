package net.th3m0th.sapphiremod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.th3m0th.sapphiremod.SapphireMod;
import net.th3m0th.sapphiremod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SAPPHIRE_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(SapphireMod.MOD_ID, "sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sapphire")).icon(()-> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
                entries.add(ModItems.SAPPHIRE);
                entries.add(ModItems.RAW_SAPPHIRE);
                entries.add(ModItems.SAPPHIRE_WAND);
                entries.add(ModBlocks.SAPPHIRE_BLOCK);
                entries.add(ModBlocks.RAW_SAPPHIRE_BLOCK);
            }).build());
    public static void  registerItemGroups(){
        SapphireMod.LOGGER.info("Registering Item Groups for " + SapphireMod.MOD_ID);
    }
}
