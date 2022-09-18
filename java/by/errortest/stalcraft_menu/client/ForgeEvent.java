package by.errortest.stalcraft_menu.client;

import by.errortest.stalcraft_menu.client.gui.StalcraftMenuGui;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ForgeEvent {

    public static StalcraftMenuGui sm = new StalcraftMenuGui();
    public static int musicCount;


    @SubscribeEvent
    public void initGui(GuiOpenEvent e) {
        if (e.gui instanceof GuiMainMenu) {
            e.gui = sm;
            musicCount++;
        }
    }


    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent e) {
        musicCount = 0;
    }
}
