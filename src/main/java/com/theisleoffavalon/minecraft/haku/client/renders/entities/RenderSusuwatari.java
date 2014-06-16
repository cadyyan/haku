package com.theisleoffavalon.minecraft.haku.client.renders.entities;

import org.lwjgl.opengl.GL11;

import com.theisleoffavalon.minecraft.haku.Haku;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSusuwatari extends Render
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("theisleoffavalon_haku", Haku.TEXTURE_PATH_ENTITIES + "/susuwatari.png");	
	
	private ModelRenderer box;
	
	public RenderSusuwatari()
	{
		box = new ModelRenderer(
			new ModelBase() {
			}
		);
		
		box.addBox(-4F, -4F, -4F, 8, 8, 8);
		box.rotationPointX = 0.0F;
		box.rotationPointY = 0.0F;
		box.rotationPointZ = 0.0F;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float f, float f1)
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslated(x, y, z);
		
		renderManager.renderEngine.bindTexture(TEXTURE);
		
		float factor = 1.0F / 16.0F;
		
		box.render(factor);
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		
		// TODO: handle susuwatari rendering
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return TEXTURE;
	}
}
