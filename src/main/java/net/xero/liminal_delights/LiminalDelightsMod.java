package net.xero.liminal_delights;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xero.liminal_delights.registration.ModRegistration;
import net.xero.liminal_delights.registration.ModSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LiminalDelightsMod.MODID)
public class LiminalDelightsMod
{
    // Directly reference a log4j logger.
    public static final String MODID = "liminal_delights";
    private static final Logger LOGGER = LogManager.getLogger();

    public LiminalDelightsMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRegistration.init(eventBus);
        eventBus.addListener(ModSetup::init);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static class DataProvider extends GlobalLootModifierProvider {

        public DataProvider(DataGenerator gen, String modid) {
            super(gen, modid);
        }

        @Override
        protected void start() {

        }
    }
}
