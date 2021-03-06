package thebetweenlands.client.render.model.baked.modelbase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * BLRootManStatuette2 - TripleHeadedSheep
 * Created using Tabula 7.0.1
 */
public class ModelSimulacrumRootman2 extends ModelBase {
    public ModelRenderer body_base;
    public ModelRenderer body_mid;
    public ModelRenderer leg_left;
    public ModelRenderer leg_right;
    public ModelRenderer head;
    public ModelRenderer arms_main;
    public ModelRenderer face_mask_main;
    public ModelRenderer face_mask_left;
    public ModelRenderer face_mask_right;
    public ModelRenderer face_mask_left2;
    public ModelRenderer face_mask_right2a;
    public ModelRenderer arms_front;

    public ModelSimulacrumRootman2() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body_mid = new ModelRenderer(this, 0, 9);
        this.body_mid.setRotationPoint(0.0F, -4.0F, 4.0F);
        this.body_mid.addBox(-2.5F, -4.0F, -4.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(body_mid, 0.091106186954104F, 0.0F, 0.0F);
        this.face_mask_left2 = new ModelRenderer(this, 19, 20);
        this.face_mask_left2.setRotationPoint(2.0F, 2.0F, 0.0F);
        this.face_mask_left2.addBox(0.0F, 0.0F, -1.99F, 2, 2, 2, 0.0F);
        this.setRotateAngle(face_mask_left2, 0.0F, 0.0F, 0.22759093446006054F);
        this.leg_right = new ModelRenderer(this, 37, 20);
        this.leg_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg_right.addBox(-4.0F, -2.0F, -1.5F, 4, 2, 5, 0.0F);
        this.setRotateAngle(leg_right, 0.091106186954104F, 0.0F, -0.136659280431156F);
        this.head = new ModelRenderer(this, 0, 18);
        this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.head.addBox(-2.0F, -4.0F, -4.0F, 4, 4, 4, 0.0F);
        this.body_base = new ModelRenderer(this, 0, 0);
        this.body_base.setRotationPoint(0.0F, 24.0F, -1.0F);
        this.body_base.addBox(-2.5F, -4.0F, 0.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(body_base, -0.091106186954104F, 0.0F, 0.0F);
        this.arms_main = new ModelRenderer(this, 32, 0);
        this.arms_main.setRotationPoint(0.0F, -3.0F, -1.5F);
        this.arms_main.addBox(-3.5F, 0.0F, -1.0F, 7, 3, 2, 0.0F);
        this.setRotateAngle(arms_main, -0.40980330836826856F, 0.0F, 0.0F);
        this.arms_front = new ModelRenderer(this, 32, 6);
        this.arms_front.setRotationPoint(0.01F, 3.0F, 1.0F);
        this.arms_front.addBox(-3.5F, 0.0F, -2.0F, 7, 3, 2, 0.0F);
        this.setRotateAngle(arms_front, -0.6373942428283291F, 0.0F, 0.0F);
        this.face_mask_main = new ModelRenderer(this, 19, 0);
        this.face_mask_main.setRotationPoint(0.0F, -2.0F, -3.0F);
        this.face_mask_main.addBox(-2.0F, -4.0F, -2.0F, 4, 8, 2, 0.0F);
        this.face_mask_left = new ModelRenderer(this, 19, 12);
        this.face_mask_left.setRotationPoint(2.0F, -1.0F, -2.0F);
        this.face_mask_left.addBox(0.0F, -2.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(face_mask_left, 0.0F, -0.22759093446006054F, 0.0F);
        this.face_mask_right2a = new ModelRenderer(this, 28, 20);
        this.face_mask_right2a.setRotationPoint(-2.0F, 2.0F, 0.0F);
        this.face_mask_right2a.addBox(-2.0F, 0.0F, -1.99F, 2, 2, 2, 0.0F);
        this.setRotateAngle(face_mask_right2a, 0.0F, 0.0F, -0.22759093446006054F);
        this.leg_left = new ModelRenderer(this, 37, 12);
        this.leg_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg_left.addBox(0.0F, -2.0F, -1.5F, 4, 2, 5, 0.0F);
        this.setRotateAngle(leg_left, 0.091106186954104F, 0.0F, 0.136659280431156F);
        this.face_mask_right = new ModelRenderer(this, 28, 12);
        this.face_mask_right.setRotationPoint(-2.0F, -1.0F, -2.0F);
        this.face_mask_right.addBox(-2.0F, -2.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(face_mask_right, 0.0F, 0.22759093446006054F, 0.0F);
        this.body_base.addChild(this.body_mid);
        this.face_mask_main.addChild(this.face_mask_left2);
        this.body_base.addChild(this.leg_right);
        this.body_mid.addChild(this.head);
        this.body_mid.addChild(this.arms_main);
        this.arms_main.addChild(this.arms_front);
        this.head.addChild(this.face_mask_main);
        this.face_mask_main.addChild(this.face_mask_left);
        this.face_mask_main.addChild(this.face_mask_right2a);
        this.body_base.addChild(this.leg_left);
        this.face_mask_main.addChild(this.face_mask_right);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body_base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
