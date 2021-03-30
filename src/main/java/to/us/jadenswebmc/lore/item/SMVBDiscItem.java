
package to.us.jadenswebmc.lore.item;

import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.JadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

@JadensloreModElements.ModElement.Tag
public class SMVBDiscItem extends JadensloreModElements.ModElement {
	@ObjectHolder("jadenslore:smvb_disc")
	public static final Item block = null;
	public SMVBDiscItem(JadensloreModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, JadensloreModElements.sounds.get(new ResourceLocation("jadenslore:suckmyvanillabeanfull")),
					new Item.Properties().group(JlctItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("smvb_disc");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("This harnesses the power of Andre within you"));
		}
	}
}
