package com.rcraft.bindingcraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.rcraft.bindingcraft.BindingCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMain extends Item {

	public ItemMain(int par1) {
		super(par1);
		this.setCreativeTab(BindingCraft.tabBindingCraft);
		this.setMaxStackSize(64); //can be overwritten in the items class
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister){
		itemIcon = iconRegister.registerIcon((BindingCraft.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.')+1)));
	}
	

}
