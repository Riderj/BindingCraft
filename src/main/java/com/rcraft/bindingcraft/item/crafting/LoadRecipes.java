package com.rcraft.bindingcraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.rcraft.bindingcraft.item.LoadItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class LoadRecipes {
	public static void init(){
		
		//InfusionCrystal
		GameRegistry.addRecipe(new ItemStack(LoadItems.InfusionCrystal), " e ","ege"," e ",'e',LoadItems.EnergyShard,'g',Block.glass);
		//EnergyStick
		GameRegistry.addRecipe(new ItemStack(LoadItems.EnergyStick), "   "," e "," e ", 'e',LoadItems.EnergyShard);
		//EnergyPickaxe
		GameRegistry.addRecipe(new ItemStack(LoadItems.EnergyPickaxe),"eee"," s "," s ", 'e', LoadItems.EnergyShard, 's',LoadItems.EnergyStick);
	}
}
