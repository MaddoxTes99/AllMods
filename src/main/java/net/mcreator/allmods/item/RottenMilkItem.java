
package net.mcreator.allmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.allmods.procedures.RottenMilkFoodEatenProcedure;
import net.mcreator.allmods.itemgroup.AllModsItemItemGroup;
import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AllmodsModElements.ModElement.Tag
public class RottenMilkItem extends AllmodsModElements.ModElement {
	@ObjectHolder("allmods:rotten_milk")
	public static final Item block = null;
	public RottenMilkItem(AllmodsModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AllModsItemItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(8).saturation(1.4000000000000001f).build()));
			setRegistryName("rotten_milk");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 100;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Du Froumage cuit"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.BUCKET, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RottenMilkFoodEatenProcedure.executeProcedure($_dependencies);
			}
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
