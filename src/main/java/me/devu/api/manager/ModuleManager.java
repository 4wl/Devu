package me.devu.api.manager;

import me.devu.features.module.Module;
import me.devu.features.module.modules.client.ClickGUI;
import me.devu.features.module.modules.combat.Criticals;
import me.devu.features.module.modules.movement.*;
import me.devu.features.module.modules.render.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager{

    public ArrayList<Module> modules = new ArrayList();
    public List<Module> sortedModules = new ArrayList<Module>();
    public List<String> sortedModulesABC = new ArrayList<String>();

    public void init() {

        //movement
        modules.add(new Sprint());

        //render
        modules.add(new FullBright());

        //combat
        modules.add(new Criticals());

        //misc

        //player

        //client
        modules.add(new ClickGUI());

        modules.forEach(Module::register);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        int code = Keyboard.getEventKey();
        if (Minecraft.getMinecraft().currentScreen == null && code != Keyboard.KEY_NONE && !Keyboard.getEventKeyState()) {
            for (Module module : modules) {
                if (module.getBind() == code) {
                    module.toggle();
                }
            }
        }
    }

}
