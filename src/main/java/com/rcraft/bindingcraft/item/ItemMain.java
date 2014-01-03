package com.rcraft.bindingcraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.rcraft.bindingcraft.BindingCraft;

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
