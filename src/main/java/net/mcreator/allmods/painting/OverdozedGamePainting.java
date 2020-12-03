
package net.mcreator.allmods.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.allmods.AllmodsModElements;

@AllmodsModElements.ModElement.Tag
public class OverdozedGamePainting extends AllmodsModElements.ModElement {
	public OverdozedGamePainting(AllmodsModElements instance) {
		super(instance, 21);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(30, 30).setRegistryName("overdozed_game"));
	}
}
