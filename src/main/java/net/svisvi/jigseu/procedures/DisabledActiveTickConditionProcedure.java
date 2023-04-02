package net.svisvi.jigseu.procedures;

import net.minecraft.world.entity.Entity;

public class DisabledActiveTickConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("disabebe") == true) {
			return true;
		}
		return false;
	}
}
