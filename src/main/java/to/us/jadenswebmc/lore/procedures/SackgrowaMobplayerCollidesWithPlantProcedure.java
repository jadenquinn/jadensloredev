package to.us.jadenswebmc.lore.procedures;

import to.us.jadenswebmc.lore.ModJadensloreModElements;
import to.us.jadenswebmc.lore.ModJadensloreMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@ModJadensloreModElements.ModElement.Tag
public class SackgrowaMobplayerCollidesWithPlantProcedure extends ModJadensloreModElements.ModElement {
	public SackgrowaMobplayerCollidesWithPlantProcedure(ModJadensloreModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModJadensloreMod.LOGGER.warn("Failed to load dependency entity for procedure SackgrowaMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 110, (int) 1, (true), (false)));
	}
}
