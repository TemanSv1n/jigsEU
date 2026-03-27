package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModItems;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class TeleportatorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		String str1 = "";
		double iindex1 = 0;
		ItemStack mainHandItem = entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;

		if (mainHandItem.getItem() == Items.CLOCK) {
			if (entity.isShiftKeyDown()) {
				// Shift + ПКМ - показать текущее значение "quan"
				if (entity instanceof Player _player && !_player.level().isClientSide()) {
					double quanValue = new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "quan");

					_player.displayClientMessage(Component.literal("" + quanValue), true);
				}
			} else {
				// ПКМ - установить значение "quan" из названия предмета
				String displayName = mainHandItem.getDisplayName().getString();
				String valueStr = displayName.substring(1, displayName.length() - 1);

				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("quan", new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
									return 0;
								}
							}
						}.convert(valueStr));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}

				if (entity instanceof Player _player && !_player.level().isClientSide()) {
					_player.displayClientMessage(Component.literal(valueStr), true);
				}
			}
		}
		else if (mainHandItem.getItem() == JigseuModItems.X_PAPER.get()) {
			// Обработка X_PAPER
			str1 = mainHandItem.getDisplayName().getString().substring(1, mainHandItem.getDisplayName().getString().length() - 1);
			iindex1 = str1.indexOf('.');

			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					String key = "x" + str1.substring(0, (int) iindex1);
					double value = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
								return 0;
							}
						}
					}.convert(str1.substring((int) (iindex1 + 1), str1.length()));

					_blockEntity.getPersistentData().putDouble(key, value);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}

			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				String key = "x" + str1.substring(0, (int) iindex1);
				String value = str1.substring((int) (iindex1 + 1), str1.length());
				_player.displayClientMessage(Component.literal("var " + key + " = " + value), true);
			}
		}
		else if (mainHandItem.getItem() == JigseuModItems.Y_PAPER.get()) {
			// Обработка Y_PAPER
			str1 = mainHandItem.getDisplayName().getString().substring(1, mainHandItem.getDisplayName().getString().length() - 1);
			iindex1 = str1.indexOf('.');

			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					String key = "y" + str1.substring(0, (int) iindex1);
					double value = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
								return 0;
							}
						}
					}.convert(str1.substring((int) (iindex1 + 1), str1.length()));

					_blockEntity.getPersistentData().putDouble(key, value);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}

			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				String key = "y" + str1.substring(0, (int) iindex1);
				String value = str1.substring((int) (iindex1 + 1), str1.length());
				_player.displayClientMessage(Component.literal("var " + key + " = " + value), true);
			}
		}
		else if (mainHandItem.getItem() == JigseuModItems.Z_PAPER.get()) {
			// Обработка Z_PAPER
			str1 = mainHandItem.getDisplayName().getString().substring(1, mainHandItem.getDisplayName().getString().length() - 1);
			iindex1 = str1.indexOf('.');

			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					String key = "z" + str1.substring(0, (int) iindex1);
					double value = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
								return 0;
							}
						}
					}.convert(str1.substring((int) (iindex1 + 1), str1.length()));

					_blockEntity.getPersistentData().putDouble(key, value);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}

			if (entity instanceof Player _player && !_player.level().isClientSide()) {
				String key = "z" + str1.substring(0, (int) iindex1);
				String value = str1.substring((int) (iindex1 + 1), str1.length());
				_player.displayClientMessage(Component.literal("var " + key + " = " + value), true);
			}
		}
	}
}