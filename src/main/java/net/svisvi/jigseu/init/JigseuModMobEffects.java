
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.potion.DisabledMobEffect;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class JigseuModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JigseuMod.MODID);
	public static final RegistryObject<MobEffect> DISABLED = REGISTRY.register("disabled", () -> new DisabledMobEffect());
}
