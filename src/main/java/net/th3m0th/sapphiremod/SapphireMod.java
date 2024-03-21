package net.th3m0th.sapphiremod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.th3m0th.sapphiremod.block.ModBlocks;
import net.th3m0th.sapphiremod.item.ModItemGroups;
import net.th3m0th.sapphiremod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SapphireMod implements ModInitializer {
	public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY =
			RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SapphireMod.MOD_ID, "raw_sapphire_block"));
	public static final String MOD_ID = "sapphiremod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SAPPHIRE_ORE_PLACED_KEY);
	}

}