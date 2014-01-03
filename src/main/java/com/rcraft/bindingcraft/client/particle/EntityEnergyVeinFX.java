package com.rcraft.bindingcraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class EntityEnergyVeinFX extends EntityFX {

	private float energyParticleScale;

    private String texture = "bindingcraft:textures/particle/EnergyParticle.png";

	public EntityEnergyVeinFX(World par1World, double par2, double par4,double par6, double par8, float par9, float par10, float par11) {
		
		super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;

        if (par9 == 0.0F)
        {
            par9 = 1.0F;
        }

        float f4 = (float)Math.random() * 0.4F + 0.6F;
        this.particleRed = ((float)(0.20000000298023224D) + 0.8F) * par9 * f4;
        this.particleGreen = ((float)( 0.20000000298023224D) + 0.8F) * par10 * f4;
        this.particleBlue = ((float)( 0.20000000298023224D) + 0.8F) * par11 * f4;
        this.particleScale *= 0.75F;
        this.particleScale *= par8;
        this.energyParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * par8);
        this.noClip = false;
	}

	public EntityEnergyVeinFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10){
        this(par1World, par2, par4, par6, 1.0F, par8, par9, par10);
	}
	
	@Override
    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f = ((float)this.particleAge + par2) / (float)this.particleMaxAge * 32.0F;

        if (f < 0.0F)
        {
            f = 0.0F;
        }

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        particleScale = .35F;
        
        Tessellator tessellator = par1Tessellator;

        tessellator.draw();
        GL11.glPushMatrix();

        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(770, 1);

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(texture));

        float f6 = (float)this.particleTextureIndexX / 16.0F;
        float f7 = f6 + 0.0624375F;
        float f8 = (float)this.particleTextureIndexY / 16.0F;
        float f9 = f8 + 0.0624375F;
        float f10 = 0.1F * this.particleScale;

        if (this.particleIcon != null)
        {
            f6 = this.particleIcon.getMinU();
            f7 = this.particleIcon.getMaxU();
            f8 = this.particleIcon.getMinV();
            f9 = this.particleIcon.getMaxV();
        }

        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)par2 - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)par2 - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)par2 - interpPosZ);

        tessellator.startDrawingQuads();
        tessellator.setBrightness(175);

        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, 1.0F);
        tessellator.addVertexWithUV((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f7, (double)f9);
        tessellator.addVertexWithUV((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f7, (double)f8);
        tessellator.addVertexWithUV((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f6, (double)f8);
        tessellator.addVertexWithUV((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f6, (double)f9);

        tessellator.draw();

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);

        GL11.glPopMatrix();

        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("textures/particle/particles.png"));
        tessellator.startDrawingQuads();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }
        this.setParticleTextureIndex(0);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }


}
