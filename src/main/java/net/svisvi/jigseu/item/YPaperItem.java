
package net.svisvi.jigseu.item;

import net.svisvi.jigseu.init.JigseuModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class YPaperItem extends Item {
	public YPaperItem() {
		super(new Item.Properties().tab(JigseuModTabs.TAB_EVENT_UTILS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
