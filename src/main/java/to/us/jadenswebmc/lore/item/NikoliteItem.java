
package to.us.jadenswebmc.lore.item;

import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.ModJadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@ModJadensloreModElements.ModElement.Tag
public class NikoliteItem extends ModJadensloreModElements.ModElement {
	@ObjectHolder("mod_jadenslore:nikolite")
	public static final Item block = null;
	public NikoliteItem(ModJadensloreModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(JlctItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("nikolite");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
