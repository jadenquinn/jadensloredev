
package to.us.jadenswebmc.lore.block;

import to.us.jadenswebmc.lore.procedures.TwerkerBlockDestroyedByExplosionProcedure;
import to.us.jadenswebmc.lore.itemgroup.JlctItemGroup;
import to.us.jadenswebmc.lore.item.SackerswordItem;
import to.us.jadenswebmc.lore.item.SackItem;
import to.us.jadenswebmc.lore.JadensloreModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@JadensloreModElements.ModElement.Tag
public class TwerkerBlock extends JadensloreModElements.ModElement {
	@ObjectHolder("jadenslore:twerker")
	public static final Block block = null;
	public TwerkerBlock(JadensloreModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(JlctItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(0.25f, 20f).setLightLevel(s -> 4)
					.harvestLevel(3).harvestTool(ToolType.HOE).setRequiresTool().doesNotBlockMovement().slipperiness(0.3f));
			setRegistryName("twerker");
		}

		@Override
		public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
			return new float[]{0f, 1f, 1f};
		}

		@Override
		public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
			return 12f;
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(SackItem.block, (int) (1));
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.PUSH_ONLY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SackerswordItem.block, (int) (1)));
		}

		@Override
		public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
			super.onExplosionDestroy(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				TwerkerBlockDestroyedByExplosionProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
