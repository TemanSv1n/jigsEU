/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.world.inventory.DropChestGUIMenu;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.inventory.MenuType;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigseuModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY =
			DeferredRegister.create(ForgeRegistries.MENU_TYPES, JigseuMod.MODID);

	public static final RegistryObject<MenuType<DropChestGUIMenu>> DROP_CHEST_GUI =
			REGISTRY.register("drop_chest_gui",
					() -> IForgeMenuType.create((id, inv, extraData) -> new DropChestGUIMenu(id, inv, extraData))
			);

	// Если нужно выполнить какую-то инициализацию после регистрации
	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		// Здесь можно добавить дополнительную инициализацию если нужно
	}
}