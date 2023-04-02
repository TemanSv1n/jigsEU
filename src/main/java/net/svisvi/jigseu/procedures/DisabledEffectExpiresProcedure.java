package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class DisabledEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("disabebe") == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(JigseuModMobEffects.DISABLED.get(), 99999, 0, (true), (true)));
		}
	}
}
