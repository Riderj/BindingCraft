package com.rcraft.bindingcraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;

import com.rcraft.bindingcraft.item.LoadItems;

public class CreativeTabBindingCraft extends CreativeTabs{

	public CreativeTabBindingCraft(String label) {
		super(label);
	}
	
	@Override
	public int getTabIconItemIndex(){
		return LoadItems.InfusionCrystal.itemID;
	}

}
