package net.mcreator.allmods.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;

@AllmodsModElements.ModElement.Tag
public class FroumageFoodEatenProcedure extends AllmodsModElements.ModElement {
	public FroumageFoodEatenProcedure(AllmodsModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FroumageFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.9)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 1200, (int) 1));
		}
		if ((Math.random() < 0.3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 2400, (int) 5));
		}
		if ((Math.random() < 0.5)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 2400, (int) 1));
		}
		if ((Math.random() < 0.6)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 1200, (int) 3));
		}
		if ((Math.random() < 0.1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 600, (int) 10));
		}
	}
}
