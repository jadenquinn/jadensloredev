
package to.us.jadenswebmc.lore.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class LoremanualguiGuiWindow extends ContainerScreen<LoremanualguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public LoremanualguiGuiWindow(LoremanualguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 225;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mod_jadenslore:textures/fdsgt.png"));
		this.blit(ms, this.guiLeft + 183, this.guiTop + 53, 0, 0, 16, 16, 16, 16);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Welcome to Jaden's Lore!", 131, 4, -65536);
		this.font.drawString(ms, "Goal 1: Grab some White Sacks from the white plants scattered", 3, 15, -65536);
		this.font.drawString(ms, "scattered around your world.", 3, 25, -65536);
		this.font.drawString(ms, "Goal 2: Once you got an Iron Pickaxe (or an equivalent) go down to where", 3, 34, -65536);
		this.font.drawString(ms, "diamonds generate, and look for Nikolite Ore.", 3, 44, -65536);
		this.font.drawString(ms, "This is what such an ore looks like:", 2, 53, -65536);
		this.font.drawString(ms, "Get as much of that stuff as you can, trust me you'll need it.", 1, 68, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
