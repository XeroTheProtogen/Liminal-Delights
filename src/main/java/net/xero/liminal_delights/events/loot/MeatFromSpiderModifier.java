package net.xero.liminal_delights.events.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class MeatFromSpiderModifier extends LootModifier {

    private final Item addition;
    private final int amount;
    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected MeatFromSpiderModifier(ILootCondition[] conditionsIn, Item addition, int amount) {
        super(conditionsIn);
        this.addition = addition;
        this.amount = amount;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() > 0.5F) {
            generatedLoot.add(new ItemStack(addition, amount));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<MeatFromSpiderModifier> {

        @Override
        public MeatFromSpiderModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(object, "drop")));
            int amount = JSONUtils.getAsInt(object, "amount");
            return new MeatFromSpiderModifier(ailootcondition, addition, amount);
        }

        @Override
        public JsonObject write(MeatFromSpiderModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("drop", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            json.addProperty("amount", instance.amount);
            return json;
        }
    }
}
