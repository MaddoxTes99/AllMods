
package net.mcreator.allmods.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.allmods.AllmodsModElements;

@AllmodsModElements.ModElement.Tag
public class AllModsItemItemGroup extends AllmodsModElements.ModElement {
	public AllModsItemItemGroup(AllmodsModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("taball_mods_item") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.SHEARS, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
