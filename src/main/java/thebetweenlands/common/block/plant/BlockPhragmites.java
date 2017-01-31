package thebetweenlands.common.block.plant;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thebetweenlands.client.render.particle.BLParticles;
import thebetweenlands.common.item.herblore.ItemPlantDrop.EnumItemPlantDrop;

public class BlockPhragmites extends BlockDoublePlantBL {
	public BlockPhragmites() {
		this.setSickleDrop(EnumItemPlantDrop.PHRAGMITE_STEMS.create(1));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (world.rand.nextInt(15) == 0) {
			if (world.rand.nextInt(6) != 0) {
				BLParticles.FLY.spawn(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
			} else {
				BLParticles.MOTH.spawn(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
			}
		}
	}
}
