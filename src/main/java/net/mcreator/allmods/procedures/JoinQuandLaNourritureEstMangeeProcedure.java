package net.mcreator.allmods.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;

@AllmodsModElements.ModElement.Tag
public class JoinQuandLaNourritureEstMangeeProcedure extends AllmodsModElements.ModElement {
	public JoinQuandLaNourritureEstMangeeProcedure(AllmodsModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JoinQuandLaNourritureEstMangee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999, (int) 5, (false), (false)));
		}
		if ((Math.random() < 0.9)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 6000, (int) 20, (false), (false)));
		}
		if ((Math.random() < 0.1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 9999999, (int) 5, (false), (false)));
		}
		if ((Math.random() < 0.9)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 6000, (int) 10, (false), (false)));
		}
	}
}
