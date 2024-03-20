package net.th3m0th.sapphiremod;

import net.fabricmc.api.ModInitializer;

import net.th3m0th.sapphiremod.block.ModBlocks;
import net.th3m0th.sapphiremod.item.ModItemGroups;
import net.th3m0th.sapphiremod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SapphireMod implements ModInitializer {
	public static final String MOD_ID = "sapphiremod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}

}