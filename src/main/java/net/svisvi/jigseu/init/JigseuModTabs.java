
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class JigseuModTabs {
	public static CreativeModeTab TAB_EVENT_UTILS;

	public static void load() {
		TAB_EVENT_UTILS = new CreativeModeTab("tabevent_utils") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.END_ROD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
