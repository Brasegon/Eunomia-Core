package fr.brangers.eunomiacore.networks;

import fr.brangers.eunomiacore.EunomiaCore;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

public class Network {
    
    private static InterModEnqueueEvent eventInter;
    private static InterModProcessEvent eventProcess;

    public static void enqueueIMC(final InterModEnqueueEvent event) {
        eventInter = event;
        InterModComms.sendTo("eunomiacore", "eunomiacore", "test", () -> {
            System.out.println("Hello from EunomiaCore");
            return "Hello from EunomiaCore";
        });
    }

    public static void processIMC(final InterModProcessEvent event) {
        eventProcess = event;
    }

}
