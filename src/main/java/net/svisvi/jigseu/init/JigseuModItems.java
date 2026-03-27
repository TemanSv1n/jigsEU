/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.item.ZPaperItem;
import net.svisvi.jigseu.item.YPaperItem;
import net.svisvi.jigseu.item.XPaperItem;
import net.svisvi.jigseu.item.VopPaperItem;
import net.svisvi.jigseu.item.StickOfDisabilityItem;
import net.svisvi.jigseu.item.PotionPotItem;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigseuModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JigseuMod.MODID);

	public static final RegistryObject<Item> TELEPORTATOR = block(JigseuModBlocks.TELEPORTATOR);
	public static final RegistryObject<Item> STICK_OF_DISABILITY = REGISTRY.register("stick_of_disability", () -> new StickOfDisabilityItem());
	public static final RegistryObject<Item> X_PAPER = REGISTRY.register("x_paper", () -> new XPaperItem());
	public static final RegistryObject<Item> Y_PAPER = REGISTRY.register("y_paper", () -> new YPaperItem());
	public static final RegistryObject<Item> Z_PAPER = REGISTRY.register("z_paper", () -> new ZPaperItem());
	public static final RegistryObject<Item> VOP_PAPER = REGISTRY.register("vop_paper", () -> new VopPaperItem());
	public static final RegistryObject<Item> CHEST_JIGSAWER = block(JigseuModBlocks.CHEST_JIGSAWER);
	public static final RegistryObject<Item> DROP_CHEST = block(JigseuModBlocks.DROP_CHEST);
	public static final RegistryObject<Item> KIT_DISPENSER = block(JigseuModBlocks.KIT_DISPENSER);
	public static final RegistryObject<Item> POTION_POT = REGISTRY.register("potion_pot", () -> new PotionPotItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	// Добавляем предметы в креативную вкладку
	@SubscribeEvent
	public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
		if (event.getTab() == JigseuModTabs.TAB_EVENT_UTILS.get()) {
			event.accept(TELEPORTATOR.get());
			event.accept(STICK_OF_DISABILITY.get());
			event.accept(X_PAPER.get());
			event.accept(Y_PAPER.get());
			event.accept(Z_PAPER.get());
			event.accept(VOP_PAPER.get());
			event.accept(CHEST_JIGSAWER.get());
			event.accept(DROP_CHEST.get());
			event.accept(KIT_DISPENSER.get());
			event.accept(POTION_POT.get());
		}
	}
}