package thebetweenlands.world.storage.chunk.storage;

import java.util.Iterator;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import thebetweenlands.world.storage.chunk.BetweenlandsChunkData;

public class StorageHelper {
	public static void addArea(World world, String name, AxisAlignedBB area) {
		int sx = MathHelper.floor_double(area.minX / 16.0D);
		int sz = MathHelper.floor_double(area.minZ / 16.0D);
		int ex = MathHelper.floor_double(area.maxX / 16.0D);
		int ez = MathHelper.floor_double(area.maxZ / 16.0D);
		for(int cx = sx; cx <= ex; cx++) {
			for(int cz = sz; cz <= ez; cz++) {
				Chunk chunk = world.getChunkFromChunkCoords(cx, cz);
				double csx = Math.max(area.minX, cx * 16);
				double csz = Math.max(area.minZ, cz * 16);
				double cex = Math.min(area.maxX, (cx+1) * 16);
				double cez = Math.min(area.maxZ, (cz+1) * 16);
				AxisAlignedBB clampedArea = AxisAlignedBB.getBoundingBox(csx, area.minY, csz, cex, area.maxY, cez);
				BetweenlandsChunkData chunkData = BetweenlandsChunkData.forChunk(world, chunk);
				chunkData.getStorage().add(new LocationStorage(chunk, name, clampedArea));
				chunkData.markDirty();
			}
		}
	}

	public static void removeArea(World world, String name, AxisAlignedBB area) {
		int sx = MathHelper.floor_double(area.minX / 16.0D);
		int sz = MathHelper.floor_double(area.minZ / 16.0D);
		int ex = MathHelper.floor_double(area.maxX / 16.0D);
		int ez = MathHelper.floor_double(area.maxZ / 16.0D);
		for(int cx = sx; cx <= ex; cx++) {
			for(int cz = sz; cz <= ez; cz++) {
				Chunk chunk = world.getChunkFromChunkCoords(cx, cz);
				BetweenlandsChunkData chunkData = BetweenlandsChunkData.forChunk(world, chunk);
				boolean changed = false;
				Iterator<ChunkStorage> storageIT = chunkData.getStorage().iterator();
				while(storageIT.hasNext()) {
					ChunkStorage storage = storageIT.next();
					if(storage instanceof LocationStorage) {
						LocationStorage areaStorage = (LocationStorage)storage;
						if(name.equals(areaStorage.getName())) {
							storageIT.remove();
							changed = true;
						}
					}
				}
				if(changed) {
					chunkData.markDirty();
				}
			}
		}
	}
}
