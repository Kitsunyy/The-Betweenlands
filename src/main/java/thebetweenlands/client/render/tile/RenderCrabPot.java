package thebetweenlands.client.render.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.Constants;
import thebetweenlands.common.entity.mobs.EntitySiltCrab;
import thebetweenlands.common.item.misc.ItemMob;
import thebetweenlands.common.tile.TileEntityCrabPot;

public class RenderCrabPot extends TileEntitySpecialRenderer<TileEntityCrabPot> {
	//public static final ResourceLocation TEXTURE = new ResourceLocation("thebetweenlands:textures/tiles/crab_pot.png");
	//public static final ModelCrabPot MODEL = new ModelCrabPot();

	@Override
	public void render(TileEntityCrabPot te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5f, (float) y, (float) z + 0.5f);
		GlStateManager.pushMatrix();
		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.translate(0, 1.5f, 0);
		GlStateManager.scale(1F, -1F, -1F);
	//	GlStateManager.disableCull();

	//	bindTexture(TEXTURE);
	//	MODEL.render();
	//	GlStateManager.enableCull();
		GlStateManager.popMatrix();

		if (te != null) {
			// inputs
			if (!te.getStackInSlot(0).isEmpty()) {
				if (isSafeMobItem(te) && te.getEntity() != null)
					renderMobInSlot(te.getEntity(), 0F, 0.0625F + (float)te.fallCounter * 0.0625F, 0F);
				else
					renderItemInSlot(te.getStackInSlot(0), 0F, 0.5F, 0F, 0.5F);
			}
		}
		GlStateManager.popMatrix();
	}

	public boolean isSafeMobItem(TileEntityCrabPot te) {
		return te.getStackInSlot(0).getItem() instanceof ItemMob && te.getStackInSlot(0).getTagCompound() != null && te.getStackInSlot(0).getTagCompound().hasKey("Entity", Constants.NBT.TAG_COMPOUND);
	}

	public void renderMobInSlot(Entity entity, float x, float y, float z) {
		if (entity != null) {
			float scale2 = 1F / ((Entity) entity).width * 0.5F;
			float offsetRotation = 180F;
			float offsetY = 0F;

			GlStateManager.pushMatrix();
			if(entity instanceof EntitySiltCrab) {
				offsetY = 0.0625F;
				scale2 = 0.95F;
				offsetRotation = 90F;
			}
			GlStateManager.translate(x, y + offsetY, z);
			GlStateManager.scale(scale2, scale2, scale2);
			GlStateManager.rotate(offsetRotation - Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
			Render renderer = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(entity);
			renderer.doRender(entity, 0, 0, 0, 0, 0);
			GlStateManager.popMatrix();
		}
	}

	public void renderItemInSlot(ItemStack stack, float x, float y, float z, float scale) {
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y, z);
			GlStateManager.scale(scale, scale, scale);
			GlStateManager.rotate(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.FIXED);
			GlStateManager.popMatrix();
		}
	}
}