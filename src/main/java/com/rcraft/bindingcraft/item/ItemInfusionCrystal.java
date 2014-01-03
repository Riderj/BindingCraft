package com.rcraft.bindingcraft.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.rcraft.bindingcraft.block.LoadBlocks;

public class ItemInfusionCrystal extends ItemMain {

	private final int MAX_ENERGY = 1000;
	private int tick = 0;
	public ItemInfusionCrystal(int par1) {
		super(par1);
		this.setMaxDamage(MAX_ENERGY);
		this.setMaxStackSize(1);
	}

	/*
	 * EVENTS
	 */
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
		if(stack.getItemDamage() == 0){
			stack.setItemDamage(MAX_ENERGY);
		}
		/*tick++;
		if(tick>=60){
			if(!world.isRemote){
				if(!((EntityPlayer)entity).capabilities.isCreativeMode){
					if(stack.getItemDamage()<=MAX_ENERGY && stack.getItemDamage() > 0){
						decreaseEnergy(stack);
					}else{
						stack.setItemDamage(0);
					}
					System.out.println(stack.getItemDamage());
				}
				tick = 0;
			}
		}*/
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, int blockid, int par4, int par6, int par7, EntityLivingBase entitylb){
		Random random = new Random();
		if(blockid == LoadBlocks.EnergyVein.blockID){
			increaseEnergy(stack,random.nextInt(250));
		}
		return false;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		setDefaults(stack);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(world.isRemote){
			player.addChatMessage("Energy Level: "+(stack.getMaxDamage() - stack.getItemDamageForDisplay()));
		}
		return stack;
	}
	
	/*
	 * METHODS
	 */
	
	//Reason why increase is subtracting is because when damage = 1000 the bar is empty, and we want empty to represent... well no energy

	private ItemStack increaseEnergy(ItemStack stack) {
		stack.setItemDamage((int) (stack.getItemDamage()-((Math.random())*5)));
		return stack;
	}
	private ItemStack increaseEnergy(ItemStack stack, int amount) {
		stack.setItemDamage((int) (stack.getItemDamage()-amount));
		return stack;
	}
	private ItemStack decreaseEnergy(ItemStack stack) {
		stack.setItemDamage((int) (stack.getItemDamage()+((Math.random())*5)));
		return stack;
	}
	private ItemStack decreaseEnergy(ItemStack stack, int amount) {
		stack.setItemDamage((int) (stack.getItemDamage()+amount));
		return stack;
	}
	private void setDefaults(ItemStack stack) {
		stack.setItemDamage(MAX_ENERGY);
	}
	
	
	
}
