
package net.mcreator.allmods.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.allmods.AllmodsModElements;

@AllmodsModElements.ModElement.Tag
public class AllModsBlockItemGroup extends AllmodsModElements.ModElement {
	public AllModsBlockItemGroup(AllmodsModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("taball_mods_block") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.POLISHED_ANDESITE, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
