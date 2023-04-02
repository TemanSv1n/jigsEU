
package net.svisvi.jigseu.potion;

import net.svisvi.jigseu.procedures.DisabledOnEffectActiveTickProcedure;
import net.svisvi.jigseu.procedures.DisabledEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DisabledMobEffect extends MobEffect {
	public DisabledMobEffect() {
		super(MobEffectCategory.HARMFUL, -12309749);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigseu.disabled";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DisabledOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		DisabledEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
