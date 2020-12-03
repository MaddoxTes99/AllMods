
package net.mcreator.allmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.allmods.procedures.PickaxeCheatToolInHandTickProcedure;
import net.mcreator.allmods.itemgroup.AllModsItemItemGroup;
import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AllmodsModElements.ModElement.Tag
public class PickaxeCheatItem extends AllmodsModElements.ModElement {
	@ObjectHolder("allmods:pickaxe_cheat")
	public static final Item block = null;
	public PickaxeCheatItem(AllmodsModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 128000;
			}

			public float getEfficiency() {
				return 128000f;
			}

			public float getAttackDamage() {
				return -2f;
			}

			public int getHarvestLevel() {
				return 128000;
			}

			public int getEnchantability() {
				return 128000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -4f, new Item.Properties().group(AllModsItemItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Tu ne peux pas la test"));
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					PickaxeCheatToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("pickaxe_cheat"));
	}
}
