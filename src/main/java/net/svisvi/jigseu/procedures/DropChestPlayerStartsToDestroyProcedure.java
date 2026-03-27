package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class DropChestPlayerStartsToDestroyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xc = 0;
		double yc = 0;
		double zc = 0;
		double slots = 0;
		double i = 0;

		xc = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "xc");

		yc = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "yc");

		zc = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "zc");

		slots = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "slot_count");

		i = 0;
		while (i <= 26) {
			ItemStack itemStack = new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null) {
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
								_retval.set(capability.getStackInSlot(slotid).copy()));
					}
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(xc, yc, zc), (int) i);

			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemStack) : false) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemStack;
					int amount = new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null) {
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
										_retval.set(capability.getStackInSlot(slotid).getCount()));
							}
							return _retval.get();
						}
					}.getAmount(world, BlockPos.containing(xc, yc, zc), (int) i);

					_player.getInventory().clearOrCountMatchingItems(
							p -> _stktoremove.getItem() == p.getItem(),
							amount,
							_player.inventoryMenu.getCraftSlots()
					);
				}

				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")),
								SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z,
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break")),
								SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			i = i + 1;
		}

		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;
			private Entity entity;
			private double x;
			private double y;
			private double z;

			public void start(LevelAccessor world, int waitTicks, Entity entity, double x, double y, double z) {
				this.waitTicks = waitTicks;
				this.world = world;
				this.entity = entity;
				this.x = x;
				this.y = y;
				this.z = z;
				MinecraftForge.EVENT_BUS.register(this);
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null) {
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
										_retval.set(capability.getStackInSlot(slotid).copy()));
							}
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(x, y, z), 0);

					_setstack.setCount(new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null) {
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
										_retval.set(capability.getStackInSlot(slotid).getCount()));
							}
							return _retval.get();
						}
					}.getAmount(world, BlockPos.containing(x, y, z), 0));

					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(JigseuModBlocks.DROP_CHEST.get().defaultBlockState()));
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 2, entity, x, y, z);
	}
}