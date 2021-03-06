package to.us.jadenswebmc.lore.procedures;

import to.us.jadenswebmc.lore.item.CompnikoliteingotItem;
import to.us.jadenswebmc.lore.JadensloreModElements;
import to.us.jadenswebmc.lore.JadensloreMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import java.util.Map;

@JadensloreModElements.ModElement.Tag
public class CompressednikoliteblocBlockDestroyedByPlayerProcedure extends JadensloreModElements.ModElement {
	public CompressednikoliteblocBlockDestroyedByPlayerProcedure(JadensloreModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				JadensloreMod.LOGGER.warn("Failed to load dependency x for procedure CompressednikoliteblocBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				JadensloreMod.LOGGER.warn("Failed to load dependency y for procedure CompressednikoliteblocBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				JadensloreMod.LOGGER.warn("Failed to load dependency z for procedure CompressednikoliteblocBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				JadensloreMod.LOGGER.warn("Failed to load dependency world for procedure CompressednikoliteblocBlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(CompnikoliteingotItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}
	}
}
