package by.errortest.stalcraft_menu.client;

import by.errortest.stalcraft_menu.Main;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;

import static by.errortest.stalcraft_menu.client.ForgeEvent.musicCount;
import static by.errortest.stalcraft_menu.client.gui.StalcraftMenuGui.sphereTimer;

public class FMLEvent {

    boolean flag1 = true;
    ISound mainmenu_ambient = PositionedSoundRecord.func_147673_a(new ResourceLocation(Main.MODID, "main_menu"));

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent e) {
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
        if (musicCount == 1) {
            Minecraft.getMinecraft().getSoundHandler().playSound(mainmenu_ambient);
            musicCount+=1;
        }


    }
}
