package to.us.jadenswebmc.lore.procedures;

import to.us.jadenswebmc.lore.JadensloreModElements;
import to.us.jadenswebmc.lore.JadensloreMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@JadensloreModElements.ModElement.Tag
public class SackgrowaMobplayerCollidesWithPlantProcedure extends JadensloreModElements.ModElement {
	public SackgrowaMobplayerCollidesWithPlantProcedure(JadensloreModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				JadensloreMod.LOGGER.warn("Failed to load dependency entity for procedure SackgrowaMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 110, (int) 1, (true), (false)));
	}
}
