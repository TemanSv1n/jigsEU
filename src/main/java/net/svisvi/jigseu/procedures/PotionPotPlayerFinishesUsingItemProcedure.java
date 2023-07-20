package net.svisvi.jigseu.procedures;

import net.minecraft.world.item.ItemStack;

public class PotionPotPlayerFinishesUsingItemProcedure {
	public static void execute(ItemStack itemstack) {
		String string1 = "";
		string1 = (itemstack.getDisplayName().getString()).substring((int) 1, (int) ((itemstack.getDisplayName().getString()).length() - 1));
	}
}
