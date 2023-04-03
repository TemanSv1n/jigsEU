package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class VopPaperRightclickedOnBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String str999 = "";
		ItemStack x999 = ItemStack.EMPTY;
		ItemStack y999 = ItemStack.EMPTY;
		ItemStack z999 = ItemStack.EMPTY;
		str999 = (itemstack.getDisplayName().getString()).substring((int) 1, (int) ((itemstack.getDisplayName().getString()).length() - 1));
		x999 = new ItemStack(JigseuModItems.X_PAPER.get());
		(x999).setHoverName(new TextComponent((str999 + "." + x)));
		y999 = new ItemStack(JigseuModItems.Y_PAPER.get());
		(y999).setHoverName(new TextComponent((str999 + "." + y)));
		z999 = new ItemStack(JigseuModItems.Z_PAPER.get());
		(z999).setHoverName(new TextComponent((str999 + "." + z)));
		if (entity instanceof Player _player) {
			ItemStack _setstack = x999;
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = y999;
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = z999;
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
