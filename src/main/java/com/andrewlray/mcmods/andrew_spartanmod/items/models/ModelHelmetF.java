package com.andrewlray.mcmods.andrew_spartanmod.items.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelHelmetF extends ModelBiped {
	// fields
	private ModelRenderer r2;
	private ModelRenderer r1;
	private ModelRenderer fr2;
	private ModelRenderer fr1;
	private ModelRenderer top;
	private ModelRenderer featherBk;
	private ModelRenderer featherFr;
	private ModelRenderer b1;
	private ModelRenderer b2;
	private ModelRenderer f1;
	private ModelRenderer f2;
	private ModelRenderer f3;
	private ModelRenderer f4;
	private ModelRenderer l1;
	private ModelRenderer l2;
	private ModelRenderer Shape2;
	private ModelRenderer Feather;
	private ModelRenderer right;
	private ModelRenderer back;
	private ModelRenderer front;
	private ModelRenderer left;

	public ModelHelmetF(float expand) {
		super(expand, 0, 64, 64);

		r2 = new ModelRenderer(this, 0, 53);
		r2.addBox(-5F, -5F, 0F, 1, 1, 4);
		r2.setRotationPoint(0F, 0F, 0F);
		r2.setTextureSize(64, 64);
		r2.mirror = true;
		setRotation(r2, 0F, 0F, 0F);
		r2.mirror = false;

		r1 = new ModelRenderer(this, 0, 42);
		r1.addBox(-5F, -8F, -4F, 1, 3, 8);
		r1.setRotationPoint(0F, 0F, 0F);
		r1.setTextureSize(64, 64);
		r1.mirror = true;
		setRotation(r1, 0F, 0F, 0F);
		r1.mirror = false;

		fr2 = new ModelRenderer(this, 36, 32);
		fr2.addBox(-1F, -13F, -6.5F, 2, 2, 13);
		fr2.setRotationPoint(0F, 0F, 0F);
		fr2.setTextureSize(64, 64);
		fr2.mirror = true;
		setRotation(fr2, 0F, 0F, 0F);

		fr1 = new ModelRenderer(this, 40, 49);
		fr1.addBox(-1F, -10F, -5.5F, 2, 1, 11);
		fr1.setRotationPoint(0F, 0F, 0F);
		fr1.setTextureSize(64, 64);
		fr1.mirror = true;
		setRotation(fr1, 0F, 0F, 0F);

		top = new ModelRenderer(this, 0, 53);
		top.addBox(-5F, -9F, -5F, 10, 1, 10);
		top.setRotationPoint(0F, 0F, 0F);
		top.setTextureSize(64, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);

		featherBk = new ModelRenderer(this, 51, 51);
		featherBk.addBox(-1F, -14.5F, 1F, 2, 7, 1);
		featherBk.setRotationPoint(0F, 0F, 0F);
		featherBk.setTextureSize(64, 64);
		featherBk.mirror = true;
		setRotation(featherBk, -0.3956661F, 0F, 0F);

		featherFr = new ModelRenderer(this, 41, 36);
		featherFr.addBox(-1F, -14.5F, -2F, 2, 7, 1);
		featherFr.setRotationPoint(0F, 0F, 0F);
		featherFr.setTextureSize(64, 64);
		featherFr.mirror = true;
		setRotation(featherFr, 0.3956661F, 0F, 0F);

		b1 = new ModelRenderer(this, 18, 47);
		b1.addBox(-5F, -8F, 4F, 10, 5, 1);
		b1.setRotationPoint(0F, 0F, 0F);
		b1.setTextureSize(64, 64);
		b1.mirror = true;
		setRotation(b1, 0F, 0F, 0F);

		b2 = new ModelRenderer(this, 18, 45);
		b2.addBox(-3F, -3F, 4F, 6, 1, 1);
		b2.setRotationPoint(0F, 0F, 0F);
		b2.setTextureSize(64, 64);
		b2.mirror = true;
		setRotation(b2, 0F, 0F, 0F);

		f1 = new ModelRenderer(this, 40, 61);
		f1.addBox(-5F, -8F, -5F, 10, 2, 1);
		f1.setRotationPoint(0F, 0F, 0F);
		f1.setTextureSize(64, 64);
		f1.mirror = true;
		setRotation(f1, 0F, 0F, 0F);

		f2 = new ModelRenderer(this, 6, 61);
		f2.addBox(-5F, -6F, -5F, 1, 1, 1);
		f2.setRotationPoint(0F, 0F, 0F);
		f2.setTextureSize(64, 64);
		f2.mirror = true;
		setRotation(f2, 0F, 0F, 0F);

		f3 = new ModelRenderer(this, 6, 61);
		f3.addBox(4F, -6F, -5F, 1, 1, 1);
		f3.setRotationPoint(0F, 0F, 0F);
		f3.setTextureSize(64, 64);
		f3.mirror = true;
		setRotation(f3, 0F, 0F, 0F);
		f3.mirror = false;

		f4 = new ModelRenderer(this, 0, 60);
		f4.addBox(-1F, -6F, -5F, 2, 2, 1);
		f4.setRotationPoint(0F, 0F, 0F);
		f4.setTextureSize(64, 64);
		f4.mirror = true;
		setRotation(f4, 0F, 0F, 0F);

		l1 = new ModelRenderer(this, 0, 42);
		l1.addBox(4F, -8F, -4F, 1, 3, 8);
		l1.setRotationPoint(0F, 0F, 0F);
		l1.setTextureSize(64, 64);
		l1.mirror = true;
		setRotation(l1, 0F, 0F, 0F);

		l2 = new ModelRenderer(this, 0, 53);
		l2.addBox(4F, -5F, 0F, 1, 1, 4);
		l2.setRotationPoint(0F, 0F, 0F);
		l2.setTextureSize(64, 64);
		l2.mirror = true;
		setRotation(l2, 0F, 0F, 0F);

		Shape2 = new ModelRenderer(this, 38, 34);
		Shape2.addBox(-1F, -11F, -6F, 2, 1, 12);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);

		Feather = new ModelRenderer(this, "Feather");
		Feather.setRotationPoint(0F, 0F, 0F);
		setRotation(Feather, 0.2268928F, 0F, 0F);
		Feather.mirror = true;

		/*
		 * right = new ModelRenderer(this, "right"); right.setRotationPoint(0F,
		 * 0F, 0F); setRotation(right, 0F, 0F, 0F); right.mirror = true;
		 * 
		 * 
		 * back = new ModelRenderer(this, "back"); back.setRotationPoint(0F, 0F,
		 * 0F); setRotation(back, 0F, 0F, 0F); back.mirror = true;
		 * 
		 * front = new ModelRenderer(this, "front"); front.setRotationPoint(0F,
		 * 0F, 0F); setRotation(front, 0F, 0F, 0F); front.mirror = true;
		 * 
		 * left = new ModelRenderer(this, "left"); left.setRotationPoint(0F, 0F,
		 * 0F); setRotation(left, 0F, 0F, 0F); left.mirror = true;
		 */

		this.bipedHead.addChild(r2);
		this.bipedHead.addChild(r1);
		this.bipedHead.addChild(fr1);
		this.bipedHead.addChild(fr2);
		this.bipedHead.addChild(top);
		this.bipedHead.addChild(featherBk);
		this.bipedHead.addChild(featherFr);
		this.bipedHead.addChild(b1);
		this.bipedHead.addChild(b2);
		this.bipedHead.addChild(f1);
		this.bipedHead.addChild(f2);
		this.bipedHead.addChild(f3);
		this.bipedHead.addChild(f4);
		this.bipedHead.addChild(l1);
		this.bipedHead.addChild(l2);
		this.bipedHead.addChild(Shape2);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
