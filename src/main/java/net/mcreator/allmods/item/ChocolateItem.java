
package net.mcreator.allmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.allmods.itemgroup.AllModsItemItemGroup;
import net.mcreator.allmods.AllmodsModElements;

import java.util.List;

@AllmodsModElements.ModElement.Tag
public class ChocolateItem extends AllmodsModElements.ModElement {
	@ObjectHolder("allmods:chocolate")
	public static final Item block = null;
	public ChocolateItem(AllmodsModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AllModsItemItemGroup.tab).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).meat().build()));
			setRegistryName("chocolate");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Mmmmm sa sen le diabete"));
		}
	}
}
