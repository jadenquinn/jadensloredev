
package to.us.jadenswebmc.lore.block;

import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.item.CompnikoliteingotItem;
import to.us.jadenswebmc.lore.JadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@JadensloreModElements.ModElement.Tag
public class DoublecompnikblockBlock extends JadensloreModElements.ModElement {
	@ObjectHolder("jadenslore:doublecompnikblock")
	public static final Block block = null;
	public DoublecompnikblockBlock(JadensloreModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(JlctItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3f, 20f).setLightLevel(s -> 0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("doublecompnikblock");
		}

		@Override
		public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
			return new float[]{0.2f, 0.6f, 1f};
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(CompnikoliteingotItem.block, (int) (1)));
		}
	}
}
