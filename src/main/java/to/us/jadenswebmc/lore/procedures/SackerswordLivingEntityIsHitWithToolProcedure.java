package to.us.jadenswebmc.lore.procedures;

import to.us.jadenswebmc.lore.ModJadensloreModElements;
import to.us.jadenswebmc.lore.ModJadensloreMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import java.util.Map;

@ModJadensloreModElements.ModElement.Tag
public class SackerswordLivingEntityIsHitWithToolProcedure extends ModJadensloreModElements.ModElement {
	public SackerswordLivingEntityIsHitWithToolProcedure(ModJadensloreModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ModJadensloreMod.LOGGER.warn("Failed to load dependency x for procedure SackerswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ModJadensloreMod.LOGGER.warn("Failed to load dependency y for procedure SackerswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ModJadensloreMod.LOGGER.warn("Failed to load dependency z for procedure SackerswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ModJadensloreMod.LOGGER.warn("Failed to load dependency world for procedure SackerswordLivingEntityIsHitWithTool!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.STRING, (int) (1)));
			entityToSpawn.setPickupDelay((int) 25);
			world.addEntity(entityToSpawn);
		}
	}
}
