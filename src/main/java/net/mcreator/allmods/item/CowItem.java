
package net.mcreator.allmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.allmods.itemgroup.AllModsItemItemGroup;
import net.mcreator.allmods.AllmodsModElements;

import java.util.List;

@AllmodsModElements.ModElement.Tag
public class CowItem extends AllmodsModElements.ModElement {
	@ObjectHolder("allmods:cow")
	public static final Item block = null;
	public CowItem(AllmodsModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AllmodsModElements.sounds.get(new ResourceLocation("allmods:discow")),
					new Item.Properties().group(AllModsItemItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("cow");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Dl'a bonne musiqueeeeee"));
		}
	}
}
