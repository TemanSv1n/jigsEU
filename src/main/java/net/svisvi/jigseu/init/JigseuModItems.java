
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.item.ZPaperItem;
import net.svisvi.jigseu.item.YPaperItem;
import net.svisvi.jigseu.item.XPaperItem;
import net.svisvi.jigseu.item.VopPaperItem;
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
	public static final RegistryObject<Item> X_PAPER = REGISTRY.register("x_paper", () -> new XPaperItem());
	public static final RegistryObject<Item> Y_PAPER = REGISTRY.register("y_paper", () -> new YPaperItem());
	public static final RegistryObject<Item> Z_PAPER = REGISTRY.register("z_paper", () -> new ZPaperItem());
	public static final RegistryObject<Item> VOP_PAPER = REGISTRY.register("vop_paper", () -> new VopPaperItem());
	public static final RegistryObject<Item> CHEST_JIGSAWER = block(JigseuModBlocks.CHEST_JIGSAWER, JigseuModTabs.TAB_EVENT_UTILS);
	public static final RegistryObject<Item> DROP_CHEST = block(JigseuModBlocks.DROP_CHEST, JigseuModTabs.TAB_EVENT_UTILS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
