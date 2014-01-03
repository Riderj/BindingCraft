package com.rcraft.bindingcraft.block;

import java.util.Random;

import com.rcraft.bindingcraft.client.particle.EntityEnergyVeinFX;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockEnergyVein extends BlockMain {

	EffectRenderer effect;
	Minecraft mc;
	public BlockEnergyVein(int par1, Material blockMaterial) {
		super(par1, blockMaterial);
		this.setLightValue(1.0F);
	}
	@SideOnly(value=Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		sparkle(world,x,y,z);
		
		//world.spawnParticle("flame", (double)(fx+fdistance), (double)fy, (double)(fz+fdistance2), 0.0D, 0.0D, 0.0D);
		
	}
	
	
	
	 private void sparkle(World par1World, int par2, int par3, int par4)
	    {
	        Random random = par1World.rand;
	        double d0 = .2625D;

	        for (int l = 0; l < 6; ++l)
	        {
	            double d1 = (double)((float)par2 + random.nextFloat());
	            double d2 = (double)((float)par3 + random.nextFloat());
	            double d3 = (double)((float)par4 + random.nextFloat());

	            if (l == 0 && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4))
	            {
	                d2 = (double)(par3 + 1) + d0;
	            }

	            if (l == 1 && !par1World.isBlockOpaqueCube(par2, par3 - 1, par4))
	            {
	                d2 = (double)(par3 + 0) - d0;
	            }

	            if (l == 2 && !par1World.isBlockOpaqueCube(par2, par3, par4 + 1))
	            {
	                d3 = (double)(par4 + 1) + d0;
	            }

	            if (l == 3 && !par1World.isBlockOpaqueCube(par2, par3, par4 - 1))
	            {
	                d3 = (double)(par4 + 0) - d0;
	            }

	            if (l == 4 && !par1World.isBlockOpaqueCube(par2 + 1, par3, par4))
	            {
	                d1 = (double)(par2 + 1) + d0;
	            }

	            if (l == 5 && !par1World.isBlockOpaqueCube(par2 - 1, par3, par4))
	            {
	                d1 = (double)(par2 + 0) - d0;
	            }

	            if (d1 < (double)par2 || d1 > (double)(par2 + 1) || d2 < 0.0D || d2 > (double)(par3 + 1) || d3 < (double)par4 || d3 > (double)(par4 + 1))
	            {
	            	EntityFX entityfx = new EntityEnergyVeinFX(par1World,d1,d2,d3,1.01F,1.0F,1.0F,1.0F);
	        		Minecraft.getMinecraft().effectRenderer.addEffect(entityfx);
	            }
	        }
	    }
}
