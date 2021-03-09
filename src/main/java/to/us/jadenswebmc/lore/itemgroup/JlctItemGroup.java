
package to.us.jadenswebmc.lore.itemgroup;

import to.us.jadenswebmc.lore.ModJadensloreModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@ModJadensloreModElements.ModElement.Tag
public class JlctItemGroup extends ModJadensloreModElements.ModElement {
	public JlctItemGroup(ModJadensloreModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabjlct") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.WHEAT_SEEDS, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
