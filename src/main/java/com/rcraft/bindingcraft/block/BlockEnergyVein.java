package com.rcraft.bindingcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;

import com.rcraft.bindingcraft.client.particle.EntityEnergyVeinFX;
import com.rcraft.bindingcraft.item.LoadItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockEnergyVein extends BlockMain {

	private boolean minedByCrystal = false;

	public BlockEnergyVein(int par1, Material blockMaterial) {
		super(par1, blockMaterial);
		this.setLightValue(1.0F);
		this.setHardness(5.0F);
	}
	@SideOnly(value=Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		sparkle(world,x,y,z);
		
		//world.spawnParticle("flame", (double)(fx+fdistance), (double)fy, (double)(fz+fdistance2), 0.0D, 0.0D, 0.0D);
		
	}
	
	
	@SideOnly(value = Side.CLIENT)
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
	 
	 
	 	@Override
	 	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
 			ItemStack itemInUse = player.inventory.getCurrentItem();
 			if(itemInUse != null){
		 		System.out.println(itemInUse.itemID);
		 		if(itemInUse.itemID == LoadItems.InfusionCrystal.itemID){
		 			minedByCrystal = true;
		 			this.setHardness(.025F);
		 		}else{
		 			minedByCrystal = false;
		 			this.setHardness(5.0F);
		 		}
 			}
	 	}
	 	
	 	@Override
	 	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata){
	 		if(!world.isRemote){
		 		if(minedByCrystal == true){
		 		}
	 		}
	 	}
	 	
	 	  /**
	     * Returns the ID of the items to drop on destruction.
	     */
	 	@Override
	    public int idDropped(int metadata, Random par2Random, int fortune)
	    {
	 		
	 		/*
	 		 * When we get the essences put in I want to allow this block to randomly drop an essence, and every other block you mine. Have a 
	 		 * different rate (e.g: 1/100)
	 		 */
	 		if(!minedByCrystal){
	 			return LoadItems.EnergyShard.itemID;
	 		}
	 		return -1;
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	 	@Override
	    public int quantityDropped(Random par1Random)
	    {
	        return 1 + par1Random.nextInt(3);
	    }
}
