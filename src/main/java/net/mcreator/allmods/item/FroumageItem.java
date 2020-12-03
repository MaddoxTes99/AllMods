
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.allmods.procedures.FroumageFoodEatenProcedure;
import net.mcreator.allmods.itemgroup.AllModsItemItemGroup;
import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AllmodsModElements.ModElement.Tag
public class FroumageItem extends AllmodsModElements.ModElement {
	@ObjectHolder("allmods:froumage")
	public static final Item block = null;
	public FroumageItem(AllmodsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AllModsItemItemGroup.tab).maxStackSize(16).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(20).saturation(2f).meat().build()));
			setRegistryName("froumage");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 60;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Ses du Froumage"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(FroumagePaperItem.block, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FroumageFoodEatenProcedure.executeProcedure($_dependencies);
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
