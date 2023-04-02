
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.world.biome.BrownWaterBiome;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

public class JigseuModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, JigseuMod.MODID);
	public static final RegistryObject<Biome> BROWN_WATER = REGISTRY.register("brown_water", () -> BrownWaterBiome.createBiome());
}
