
package to.us.jadenswebmc.lore.item;

import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.ModJadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@ModJadensloreModElements.ModElement.Tag
public class Nikolitesword1Item extends ModJadensloreModElements.ModElement {
	@ObjectHolder("mod_jadenslore:nikolitesword_1")
	public static final Item block = null;
	public Nikolitesword1Item(ModJadensloreModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 16000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 33.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, 0f, new Item.Properties().group(JlctItemGroup.tab)) {
		}.setRegistryName("nikolitesword_1"));
	}
}
