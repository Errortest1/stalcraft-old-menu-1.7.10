package by.errortest.stalcraft_menu.client.gui;

import by.errortest.stalcraft_menu.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StalcraftMenuGui extends GuiScreen {
    
    Minecraft mc = Minecraft.getMinecraft();
    public static float sphereTimer = 0;

    public void initGui() {
        this.buttonList.add(new CustomGuiButton(0, this.width - 310, this.height / 6 - 22, this.width - 415, this.height / 6 - 20, this.width - 415,
                this.height / 6 - 20, 0, 14, 0, 100, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(1, this.width - 310, this.height / 6 + 18, this.width - 415, this.height / 6 + 20, this.width - 415,
                this.height / 6 + 16, 0, 37, 0, 120, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(2, this.width - 310, this.height / 6 + 58, this.width - 415, this.height / 6 + 52, this.width - 415,
                this.height / 6 + 51, 0, 55, 0, 140, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(3, this.width - 310, this.height / 6 + 95, this.width - 415, this.height / 6 + 88, this.width - 415,
                this.height / 6 + 87, 0, 76, 0, 161, 256, 20, 320, 30, ""));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (button.id == 1) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (button.id == 2) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        if (button.id == 3) {
            this.mc.shutdown();
        }
    }


    public void drawScreen(int var1, int var2, float p_73863_3_) {
        GL11.glPushMatrix();
        GL11.glTranslated(0, -16.0, 0);
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_0.png"));
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslated(0, sphereTimer / 8, 0);
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_1.png"));
        GL11.glPopMatrix();
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_2.png"));

        int k;

        for (k = 0; k < this.buttonList.size(); ++k) {
            this.buttonList.get(k).drawButton(this.mc, var1, var2);
        }
    }
    
    public void updateScreen() {
        if (sphereTimer >= 30 && flag1) {
            flag1 = false;
        } else if (sphereTimer == 0 && !flag1) {
            flag1 = true;
        }
        if (!flag1) {
            sphereTimer--;
        } else {
            sphereTimer++;
        }
    }

    void drawFullScreenTexture(ResourceLocation resourceLocation) {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        int x = scaledresolution.getScaledWidth();
        int y = scaledresolution.getScaledHeight();
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glTranslated((((Mouse.getEventX() * -1) * 5.44444444d) / x) * 1.03, ((Mouse.getEventY() * 5.44444444d) / y) * 1.03, 0);
        GL11.glScaled(1.07, 1.07, 1);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, y, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(x, y, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(x, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glPopMatrix();
    }
}
