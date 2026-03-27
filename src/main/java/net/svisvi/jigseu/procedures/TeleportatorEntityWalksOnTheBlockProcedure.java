package net.svisvi.jigseu.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class TeleportatorEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randus = 0;

		// Получаем значение "quan" из NBT блока
		double quan = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "quan");

		if (quan > 0) {
			// Генерируем случайное число от 1 до quan
			RandomSource random = RandomSource.create();
			randus = Mth.nextInt(random, 1, (int) quan);

			// Форматируем randus для использования в ключе NBT
			String randusStr = String.valueOf(randus);

			// Получаем координаты для телепортации
			double teleportX = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), ("x" + randusStr));

			double teleportY = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), ("y" + randusStr));

			double teleportZ = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), ("z" + randusStr));

			// Телепортируем сущность
			Entity _ent = entity;
			_ent.teleportTo(teleportX, teleportY, teleportZ);

			if (_ent instanceof ServerPlayer _serverPlayer) {
				_serverPlayer.connection.teleport(teleportX, teleportY, teleportZ, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}