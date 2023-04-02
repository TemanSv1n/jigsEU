
package net.svisvi.jigseu.item;

import net.svisvi.jigseu.procedures.ClickedProcedure;
import net.svisvi.jigseu.init.JigseuModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class StickOfDisabilityItem extends SwordItem {
	public StickOfDisabilityItem() {
		super(new Tier() {
			public int getUses() {
				return 1488;
			}

			public float getSpeed() {
				return 1f;
			}

			public float getAttackDamageBonus() {
				return -1f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, 10f, new Item.Properties().tab(JigseuModTabs.TAB_EVENT_UTILS).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ClickedProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
