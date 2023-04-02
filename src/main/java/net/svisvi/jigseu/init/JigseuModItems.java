
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.item.StickOfDisabilityItem;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class JigseuModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JigseuMod.MODID);
	public static final RegistryObject<Item> TELEPORTATOR = block(JigseuModBlocks.TELEPORTATOR, JigseuModTabs.TAB_EVENT_UTILS);
	public static final RegistryObject<Item> STICK_OF_DISABILITY = REGISTRY.register("stick_of_disability", () -> new StickOfDisabilityItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
