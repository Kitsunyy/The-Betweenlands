package thebetweenlands.common.world.event;

import java.util.Calendar;
import java.util.GregorianCalendar;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import thebetweenlands.common.DistUtils;
import thebetweenlands.common.TheBetweenlands;
import thebetweenlands.common.lib.ModInfo;
import thebetweenlands.common.registries.ModelRegistry;
import thebetweenlands.common.world.DimensionBetweenlands;

public class EventSpoopy extends SeasonalEnvironmentEvent {
	public static final ResourceLocation ID = new ResourceLocation(ModInfo.ID, "spook");

	private static final long SPOOPY_DATE = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), 9, 23, 0, 0).getTime().getTime();

	private float skyTransparency = 0.0F;
	private float lastSkyTransparency = 0.0F;

	public EventSpoopy(BLEnvironmentEventRegistry registry) {
		super(registry);
	}

	@Override
	public long getStartDateInMs() {
		return SPOOPY_DATE;
	}

	@Override
	public int getDurationInDays() {
		return 8;
	}

	public void setSkyTransparency(float transparency) {
		this.lastSkyTransparency = this.skyTransparency;
		this.skyTransparency = transparency;
	}

	public float getSkyTransparency(float partialTicks) {
		return (this.skyTransparency + (this.skyTransparency - this.lastSkyTransparency) * partialTicks) / 2.0F;
	}

	@Override
	public ResourceLocation getEventName() {
		return ID;
	}

	@Override
	public void setActive(boolean active) {
		//Mark blocks in range for render update to update block textures
		if(active != this.isActive() && DistUtils.getClientWorld() != null && DistUtils.getClientPlayer() != null) {
			updateModelActiveState(active);

			EntityPlayer player = DistUtils.getClientPlayer();
			int px = MathHelper.floor(player.posX) - 256;
			int py = MathHelper.floor(player.posY) - 256;
			int pz = MathHelper.floor(player.posZ) - 256;
			DistUtils.getClientWorld().markBlockRangeForRenderUpdate(px, py, pz, px + 512, py + 512, pz + 512);
		}

		super.setActive(active);
	}

	@Override
	public void update(World world) {
		super.update(world);

		if(world.isRemote()) {
			if(this.isActive()) {
				if(this.skyTransparency < 1.0F) {
					this.setSkyTransparency(this.skyTransparency + 0.003F);
				}
				if(this.skyTransparency > 1.0F) {
					this.setSkyTransparency(1.0F);
				}
			} else {
				if(this.skyTransparency > 0.0F) {
					this.setSkyTransparency(this.skyTransparency - 0.003F);
				}
				if(this.skyTransparency < 0.0F) {
					this.setSkyTransparency(0.0F);
				}
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onClientTick(ClientTickEvent event) {
		World world = Minecraft.getInstance().world;
		if(world != null && world.dimension instanceof DimensionBetweenlands) {
			updateModelActiveState(((DimensionBetweenlands)world.dimension).getEnvironmentEventRegistry().spoopy.isActive());
		} else {
			updateModelActiveState(false);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static void updateModelActiveState(boolean active) {
		ModelRegistry.SPOOK_EVENT.setActive(active);
	}

	@Override
	protected void showStatusMessage(EntityPlayer player) {
		player.sendStatusMessage(new TextComponentTranslation("chat.event.spook"), true);
	}
}
