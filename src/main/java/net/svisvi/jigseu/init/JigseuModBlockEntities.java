
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigseu.init;

import net.svisvi.jigseu.block.entity.TeleportatorBlockEntity;
import net.svisvi.jigseu.block.entity.KitdispenserBlockEntity;
import net.svisvi.jigseu.block.entity.DropChestBlockEntity;
import net.svisvi.jigseu.block.entity.ChestJigsawerBlockEntity;
import net.svisvi.jigseu.JigseuMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class JigseuModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, JigseuMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> TELEPORTATOR = register("teleportator", JigseuModBlocks.TELEPORTATOR, TeleportatorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_JIGSAWER = register("chest_jigsawer", JigseuModBlocks.CHEST_JIGSAWER, ChestJigsawerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DROP_CHEST = register("drop_chest", JigseuModBlocks.DROP_CHEST, DropChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> KIT_DISPENSER = register("kit_dispenser", JigseuModBlocks.KIT_DISPENSER, KitdispenserBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
