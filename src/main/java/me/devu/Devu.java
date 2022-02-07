package me.devu;

import me.devu.api.manager.ModuleManager;
import me.zero.alpine.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;

/**
 * @author M3dusa
 * @since 04/01/2022
 */
@Mod(modid = Devu.MODID, name = Devu.NAME, version = "v " + Devu.VERISON)
public class Devu {

    public static final String MODID = "devu";
    public static final String NAME = "Devu";
    public static final String VERISON = "1";

    public static final EventManager EVENT_BUS = new EventManager();

    private ModuleManager moduleManager;

    @Mod.Instance
    public static Devu INSTANCE;

    public Devu() {
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        Display.setTitle("Balls " + "v" + Devu.VERISON);

        moduleManager = new ModuleManager();
        moduleManager.init();
        MinecraftForge.EVENT_BUS.register(moduleManager);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

}
