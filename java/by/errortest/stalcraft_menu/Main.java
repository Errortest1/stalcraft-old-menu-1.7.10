package by.errortest.stalcraft_menu;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static by.errortest.stalcraft_menu.Main.MODID;

@Mod(
        name = "Stalcraft Menu",
        modid = MODID,
        version = "0.0.1",
        acceptedMinecraftVersions = "[1.7.10]"
)
public class Main {

    @SidedProxy(
            clientSide = "by.errortest.stalcraft_menu.ClientProxy",
            serverSide = "by.errortest.stalcraft_menu.CommonProxy"
    )
    private static CommonProxy proxy;
    public static final String MODID = "stalcraft_menu";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
