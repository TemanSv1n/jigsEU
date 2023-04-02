package net.svisvi.jigseu.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class DisabledOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("disabebe") == true) {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayBuild = (entity.getPersistentData().getBoolean("disabebe") == false);
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = (entity.getPersistentData().getBoolean("disabebe") == true);
				_player.onUpdateAbilities();
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 21, 255, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 21, 255, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21, 255, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 21, 255, (false), (false)));
		}
	}
}
