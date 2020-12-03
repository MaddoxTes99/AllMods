package net.mcreator.allmods.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;

@AllmodsModElements.ModElement.Tag
public class PickaxeCheatToolInHandTickProcedure extends AllmodsModElements.ModElement {
	public PickaxeCheatToolInHandTickProcedure(AllmodsModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PickaxeCheatToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 0, (int) 255, (false), (false)));
	}
}
