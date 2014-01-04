package com.rcraft.bindingcraft.item;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.rcraft.bindingcraft.block.LoadBlocks;

public class ItemInfusionCrystal extends ItemMain {
	public ItemInfusionCrystal(int par1) {
		super(par1);
	}
	
	
	private void setupTags(ItemStack stack) {
		stack.setTagCompound(new NBTTagCompound());
		stack.stackTagCompound.setString("energyname", "Energy Level:");
		stack.stackTagCompound.setInteger("energylevel", 0);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		setupTags(stack);
	}


	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int thing, boolean thing2){
	}
	
	@Override
    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(stack.stackTagCompound !=null){
			par3List.add(EnumChatFormatting.DARK_RED+""+stack.stackTagCompound.getTag("energyname")+EnumChatFormatting.WHITE+" "+stack.stackTagCompound.getTag("energylevel"));
		}else{
			par3List.add(EnumChatFormatting.DARK_RED+"Energy Level: "+EnumChatFormatting.WHITE+ "0");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
			if(stack.stackTagCompound != null){
				player.addChatMessage(EnumChatFormatting.DARK_RED+""+stack.stackTagCompound.getTag("energyname")+EnumChatFormatting.WHITE+" "+stack.stackTagCompound.getTag("energylevel"));
			}
		}
		return stack;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, int blockid, int a, int b, int c, EntityLivingBase entity){
		Random random = new Random();
		
		if(stack.stackTagCompound == null){
			setupTags(stack);
		}
		
		if(!world.isRemote){
			if(blockid == LoadBlocks.EnergyVein.blockID){
				stack.stackTagCompound.setInteger("energylevel",stack.stackTagCompound.getInteger("energylevel")+(10+random.nextInt(50)));
				System.out.println(stack.stackTagCompound.getInteger("energylevel"));
			}
		}
		return false;
	}
}
