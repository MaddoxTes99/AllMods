package net.mcreator.allmods.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.BlockState;

import net.mcreator.allmods.block.Theblockframe2Block;
import net.mcreator.allmods.AllmodsModElements;

import java.util.Map;

@AllmodsModElements.ModElement.Tag
public class TheBlockTickAleatoireAfficheParLeClientProcedure extends AllmodsModElements.ModElement {
	public TheBlockTickAleatoireAfficheParLeClientProcedure(AllmodsModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure TheBlockTickAleatoireAfficheParLeClient!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure TheBlockTickAleatoireAfficheParLeClient!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure TheBlockTickAleatoireAfficheParLeClient!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TheBlockTickAleatoireAfficheParLeClient!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = Theblockframe2Block.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_bs.has(_property))
					_bs = _bs.with(_property, (Comparable) entry.getValue());
			}
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
