
package net.svisvi.jigseu.item;

import net.svisvi.jigseu.procedures.VopPaperRightclickedOnBlockProcedure;
import net.svisvi.jigseu.init.JigseuModTabs;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class VopPaperItem extends Item {
	public VopPaperItem() {
		super(new Item.Properties().tab(JigseuModTabs.TAB_EVENT_UTILS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		VopPaperRightclickedOnBlockProcedure.execute(context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
