package net.svisvi.jigseu.procedures;

import net.svisvi.jigseu.init.JigseuModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PapersCommandScriptProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null) return;

		// Получаем ID бумаги из аргументов команды
		String paperId = String.valueOf(DoubleArgumentType.getDouble(arguments, "paper_id"));

		// Получаем позицию блока, на который смотрит игрок
		BlockPos targetPos = entity.level().clip(new ClipContext(
				entity.getEyePosition(1.0f),
				entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(7)),
				ClipContext.Block.COLLIDER,
				ClipContext.Fluid.NONE,
				entity
		)).getBlockPos();

		// Создаем бумаги с координатами
		createAndGivePaper(entity, JigseuModItems.X_PAPER.get(),
				paperId + "." + formatCoordinate(targetPos.getX()));

		// Для Y координаты учитываем Shift
		String yCoord;
		if (entity.isShiftKeyDown()) {
			yCoord = formatCoordinate(targetPos.getY() + 1);
		} else {
			yCoord = formatCoordinate(targetPos.getY());
		}
		createAndGivePaper(entity, JigseuModItems.Y_PAPER.get(), paperId + "." + yCoord);

		createAndGivePaper(entity, JigseuModItems.Z_PAPER.get(),
				paperId + "." + formatCoordinate(targetPos.getZ()));
	}

	private static String formatCoordinate(int coord) {
		String coordStr = String.valueOf(coord);
		return coordStr.length() > 2 ? coordStr.substring(0, coordStr.length() - 2) : coordStr;
	}

	private static void createAndGivePaper(Entity entity, net.minecraft.world.item.Item paperItem, String hoverName) {
		if (!(entity instanceof Player player)) return;

		ItemStack paperStack = new ItemStack(paperItem);
		paperStack.setHoverName(Component.literal(hoverName));
		paperStack.setCount(1);
		ItemHandlerHelper.giveItemToPlayer(player, paperStack);
	}
}