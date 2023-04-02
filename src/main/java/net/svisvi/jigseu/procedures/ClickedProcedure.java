package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModMobEffects;
import net.svisvi.jigseu.init.JigseuModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ClickedProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getTarget(), event.getPlayer());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigseuModItems.STICK_OF_DISABILITY.get()) {
			if (entity.getPersistentData().getBoolean("disabebe") == true) {
				entity.getPersistentData().putBoolean("disabebe", (false));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(JigseuModMobEffects.DISABLED.get());
			} else {
				entity.getPersistentData().putBoolean("disabebe", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JigseuModMobEffects.DISABLED.get(), 99999, 0, (true), (true)));
			}
		}
	}
}
