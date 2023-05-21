package fr.brangers.eunomiacore;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.InterModComms.IMCMessage;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.stream.Stream;

import org.slf4j.Logger;
import fr.brangers.eunomiacore.networks.Network;

@Mod(EunomiaCore.MODID)
public class EunomiaCore {
    
    public static final String MODID = "eunomiacore";
    public static final String NAME = "Eunomia Core";
    public static final String VERSION = "0.0.1";
    public static final String MC_VERSION = "1.19.2";
    public static final String ACCEPTED_VERSIONS = "[1.19.2]";

    public static final Logger LOGGER = LogUtils.getLogger();

    public EunomiaCore() {
        LOGGER.info("Eunomia Core v" + VERSION + " is loading!");

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(Network::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        // Register ourselves for server and other game events we are interested in

    }

    private void setup(final FMLCommonSetupEvent event) {

        LOGGER.info("HELLO FROM PREINIT");
        InterModComms.sendTo("eunomiacore", "eunomiacore", "test", () -> {
            System.out.println("Hello from EunomiaCore");
            return "Hello from EunomiaCore";
        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
       LOGGER.info("HELLO FROM enqueueIMC");
    }
}
