package by.errortest.stalcraft_menu.client;

import by.errortest.stalcraft_menu.Main;
import by.errortest.stalcraft_menu.client.gui.StalcraftMenuGui;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ForgeEvent {

    StalcraftMenuGui sm = new StalcraftMenuGui();
    public static int musicCount;

    @SubscribeEvent
    public void initGui(GuiOpenEvent e) {
        if (e.gui instanceof GuiMainMenu) {
            e.gui = sm;
            musicCount++;
            System.out.println(musicCount);
        }
    }


    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent e) {
        musicCount = 0;
    }
}
