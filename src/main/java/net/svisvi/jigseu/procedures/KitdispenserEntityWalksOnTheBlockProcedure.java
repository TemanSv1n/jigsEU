package net.svisvi.jigseu.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class KitdispenserEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double slot = 0;

		if ((world.getBlockState(BlockPos.containing(x, y - 3, z))).getBlock() == Blocks.CHEST) {

			// Установка предмета в офф-руку
			if (entity instanceof LivingEntity _entity) {
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
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), 22);

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
				}.getAmount(world, BlockPos.containing(x, y - 3, z), 22));

				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}

			// Установка шлема (слот 3)
			{
				Entity _entity = entity;
				ItemStack headStack = new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null) {
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
									_retval.set(capability.getStackInSlot(slotid).copy()));
						}
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), 23);

				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, headStack);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, headStack);
				}
			}

			// Установка нагрудника (слот 2)
			{
				Entity _entity = entity;
				ItemStack chestStack = new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null) {
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
									_retval.set(capability.getStackInSlot(slotid).copy()));
						}
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), 24);

				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, chestStack);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, chestStack);
				}
			}

			// Установка понож (слот 1)
			{
				Entity _entity = entity;
				ItemStack legsStack = new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null) {
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
									_retval.set(capability.getStackInSlot(slotid).copy()));
						}
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), 25);

				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, legsStack);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, legsStack);
				}
			}

			// Установка ботинок (слот 0)
			{
				Entity _entity = entity;
				ItemStack feetStack = new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null) {
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
									_retval.set(capability.getStackInSlot(slotid).copy()));
						}
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), 26);

				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, feetStack);
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, feetStack);
				}
			}

			// Заполнение инвентаря предметами (слоты 0-21)
			slot = 0;
			while (slot < 22) {
				final int currentSlot = (int) slot;
				final ItemStack _setstack = new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null) {
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability ->
									_retval.set(capability.getStackInSlot(slotid).copy()));
						}
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y - 3, z), currentSlot);

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
				}.getAmount(world, BlockPos.containing(x, y - 3, z), currentSlot));

				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable _modHandler)
						_modHandler.setStackInSlot(currentSlot, _setstack);
				});

				slot = slot + 1;
			}

			// Телепортация
			{
				Entity _ent = entity;
				double teleportX = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "x");

				double teleportY = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "y");

				double teleportZ = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "z");

				_ent.teleportTo(teleportX, teleportY, teleportZ);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(teleportX, teleportY, teleportZ, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}