package by.errortest.stalcraft_menu.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

import static by.errortest.stalcraft_menu.client.gui.StalcraftMenuGui.sphereTimer;

public class FMLEvent {

    boolean flag1 = true;

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent e) {

        if (sphereTimer >= 30 && flag1)
            flag1 = false;
        else if (sphereTimer == 0 && !flag1)
            flag1 = true;
        if (!flag1)
            sphereTimer--;
        else 
            sphereTimer++;
        
    }
}
