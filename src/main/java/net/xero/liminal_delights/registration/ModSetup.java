package net.xero.liminal_delights.registration;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.xero.liminal_delights.LiminalDelightsMod;
import net.xero.liminal_delights.events.loot.MeatFromSpiderModifier;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = LiminalDelightsMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static void init(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerModifierSerializer(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new MeatFromSpiderModifier.Serializer()
                        .setRegistryName(new ResourceLocation(LiminalDelightsMod.MODID, "meat_from_spider"))
        );
    }
}
