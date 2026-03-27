package net.svisvi.jigseu.client.gui;

import net.svisvi.jigseu.world.inventory.DropChestGUIMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

public class DropChestGUIScreen extends AbstractContainerScreen<DropChestGUIMenu> {
	private final static HashMap<String, Object> guistate = DropChestGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DropChestGUIScreen(DropChestGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("jigseu:textures/screens/drop_chest_gui.png");
	private static final ResourceLocation packTexture = new ResourceLocation("jigseu:textures/screens/pack.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		// Render the main GUI texture
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		// Render the pack icon
		guiGraphics.blit(packTexture, this.leftPos + 6, this.topPos + 7, 0, 0, 32, 32, 32, 32);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		// Draw the label text
		guiGraphics.drawString(this.font, Component.translatable("gui.jigseu.drop_chest_gui.label_only_showing_break_block_for_i"), 3, 56, -15263977, false);
	}
}