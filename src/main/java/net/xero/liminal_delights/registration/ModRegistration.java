package net.xero.liminal_delights.registration;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.xero.liminal_delights.LiminalDelightsMod;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.items.drinks.HotCocoaItem;
import vectorwing.farmersdelight.registry.ModEffects;

public class ModRegistration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LiminalDelightsMod.MODID);

    public static final RegistryObject<Item> ROYAL_RATIONS = ITEMS.register("royal_rations",
            () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP).food(
                    new Food.Builder().nutrition(5).saturationMod(7.0F).build())));

    public static final RegistryObject<Item> DICED_ROYAL_RATION = ITEMS.register("diced_royal_ration",
            () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP).stacksTo(16)));

    public static final RegistryObject<Item> LUCKY_MILK = ITEMS.register("lucky_milk",
            () -> new HotCocoaItem(new Item.Properties().tab(FarmersDelight.ITEM_GROUP).craftRemainder(Items.BUCKET)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.LUCK, 1200, 0), 1.0F)
                            .nutrition(2).saturationMod(3).build()).stacksTo(1)));

    public static final RegistryObject<Item> ROYAL_RATION_MILKSHAKE = ITEMS.register("royal_milkshake",
            () -> new HotCocoaItem(new Item.Properties().tab(FarmersDelight.ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)
                    .food(new Food.Builder().nutrition(12).saturationMod(10.0F).build())));

    public static final RegistryObject<Item> SPIDER_MEAT = ITEMS.register("spider_meat",
            () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP)
                    .food(new Food.Builder().nutrition(2).saturationMod(1)
                            .effect(() -> new EffectInstance(Effects.POISON, 200, 1), 1.0F).build())));

    public static final RegistryObject<Item> SPIDER_LEGS = ITEMS.register("spider_legs",
            () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP).stacksTo(6)));

    public static final RegistryObject<Item> DEEP_FRIED_ARACHNID = ITEMS.register("deep_fried_arachnid",
            () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP)
                    .food(new Food.Builder().nutrition(10).saturationMod(9.0F)
                            .effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 80, 1), 1.0F).build())));



    private RegistryObject<Item> registerEffectFood(String id, int nutrition, float saturation, Effect effect, int duration, int power, float amplifier) {
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(FarmersDelight.ITEM_GROUP)
                        .food(new Food.Builder().nutrition(nutrition).saturationMod(saturation)
                                .effect(() -> new EffectInstance(effect, duration, power), amplifier).build())));
    }

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
