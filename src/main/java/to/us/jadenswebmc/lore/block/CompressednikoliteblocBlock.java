
package to.us.jadenswebmc.lore.block;

import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.JadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@JadensloreModElements.ModElement.Tag
public class CompressednikoliteblocBlock extends JadensloreModElements.ModElement {
	@ObjectHolder("jadenslore:compressednikolitebloc")
	public static final Block block = null;
	public CompressednikoliteblocBlock(JadensloreModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(JlctItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).setLightLevel(s -> 0).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("compressednikolitebloc");
		}

		@Override
		public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
			return new float[]{0.4f, 0.4f, 0.4f};
		}

		@Override
		public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
			return 10f;
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.QUARTZ;
		}

		@Override
		public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Compressednikblock1Block.block, (int) (6)));
		}
	}
}
