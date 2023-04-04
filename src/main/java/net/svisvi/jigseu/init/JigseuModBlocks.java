
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.block.TeleportatorBlock;
import net.svisvi.jigseu.block.DropChestBlock;
import net.svisvi.jigseu.block.ChestJigsawerBlock;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class JigseuModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JigseuMod.MODID);
	public static final RegistryObject<Block> TELEPORTATOR = REGISTRY.register("teleportator", () -> new TeleportatorBlock());
	public static final RegistryObject<Block> CHEST_JIGSAWER = REGISTRY.register("chest_jigsawer", () -> new ChestJigsawerBlock());
	public static final RegistryObject<Block> DROP_CHEST = REGISTRY.register("drop_chest", () -> new DropChestBlock());
}
