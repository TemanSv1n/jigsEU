/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigseuModTabs {
	public static final DeferredRegister<CreativeModeTab> TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "jigseu");

	public static final RegistryObject<CreativeModeTab> TAB_EVENT_UTILS = TABS.register("tabevent_utils",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.jigseu.tabevent_utils"))
					.icon(() -> new ItemStack(Blocks.END_ROD))
					.displayItems((parameters, output) -> {
						// Здесь добавляются предметы вкладки
						// Например:
						// output.accept(JigseuModItems.YOUR_ITEM.get());
						// output.accept(JigseuModBlocks.YOUR_BLOCK.get().asItem());
					})
					.build()
	);

	public static void register() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TABS.register(bus);
	}
}