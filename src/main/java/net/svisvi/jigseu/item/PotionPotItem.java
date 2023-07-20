
package net.svisvi.jigseu.item;

import net.svisvi.jigseu.init.JigseuModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class PotionPotItem extends Item {
	public PotionPotItem() {
		super(new Item.Properties().tab(JigseuModTabs.TAB_EVENT_UTILS).stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f)

				.build()));
	}
}
