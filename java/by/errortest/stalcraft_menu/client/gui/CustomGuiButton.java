package by.errortest.stalcraft_menu.client.gui;

import by.errortest.stalcraft_menu.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import static by.errortest.stalcraft_menu.client.ForgeEvent.musicCount;

public class CustomGuiButton extends GuiButton {
    public ResourceLocation buttonTexture = new ResourceLocation(Main.MODID, "textures/gui/menu/navigation.png");
    private float scale = 1.65f;
    private int xHovPos, yHovPos, xOff, yOff, xHovOff, yHovOff, xTexSize, yTexSize, xTexPos, yTexPos;

    public CustomGuiButton(int id, int xButtonPos, int yButtonPos, int xTexPos, int yTexPos, int xHovPos, int yHovPos, int xOff, int yOff, int xHovOff, int yHovOff, int xTexSize, int yTexSize, int width, int height, String displayString) {
        super(id, width, height, displayString);
        this.width = width;
        this.height = height;
        this.xHovPos = xHovPos;
        this.yHovPos = yHovPos;
        this.xTexPos = xTexPos;
        this.yTexPos = yTexPos;
        this.xOff = xOff;
        this.yOff = yOff;
        this.xHovOff = xHovOff;
        this.yHovOff = yHovOff;
        this.xTexSize = xTexSize;
        this.yTexSize = yTexSize;
        this.enabled = true;
        this.visible = true;
        this.id = id;
        this.xPosition = xButtonPos;
        this.yPosition = yButtonPos;
    }
    boolean flag;

    @Override
    public void drawButton(Minecraft minecraft, int xCoord, int yCoord) {
        if (musicCount == 1) {
            playSound("main_menu");
            musicCount++;
        }
        if (this.visible) {
            GL11.glPushMatrix();
            GL11.glScalef(scale, scale, scale);
            minecraft.renderEngine.bindTexture(buttonTexture);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = xCoord >= this.xPosition && yCoord >= this.yPosition && xCoord < this.xPosition + this.width && yCoord < this.yPosition + this.height;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            if (this.field_146123_n) {
                if (flag)
                playSound("main_menu_hover");
                flag = false;
                drawTexturedModalRect((int) ((this.xHovPos) / scale), (int) ((this.yHovPos + 15 - 13) / scale), xHovOff, yHovOff, xTexSize, yTexSize);
            } else {
                drawTexturedModalRect((int) ((this.xTexPos) / scale), (int) ((this.yTexPos + 15 - 13) / scale), xOff, yOff, xTexSize, yTexSize);
                flag = true;
            }
            GL11.glPopMatrix();
            this.mouseDragged(minecraft, xCoord, yCoord);
        }
    }

    void playSound(String name) {
        ISound sound = PositionedSoundRecord.func_147673_a(new ResourceLocation(Main.MODID, name));
        Minecraft.getMinecraft().getSoundHandler().playSound(sound);
    }
}

