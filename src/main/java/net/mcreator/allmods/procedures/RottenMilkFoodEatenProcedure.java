package net.mcreator.allmods.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;

@AllmodsModElements.ModElement.Tag
public class RottenMilkFoodEatenProcedure extends AllmodsModElements.ModElement {
	public RottenMilkFoodEatenProcedure(AllmodsModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RottenMilkFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((true)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 120, (int) 1));
		}
	}
}
