package com.rcraft.bindingcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LoadItems {
	
	public static Item Rune;
	public static Item BindingCream;
	public static Item InfusionCrystal;
	
	public static void init(){
		Rune = new ItemRune(5000).setUnlocalizedName("rune");
		BindingCream = new ItemBindingCream(5001).setUnlocalizedName("binding_cream");
		InfusionCrystal = new ItemInfusionCrystal(5002).setUnlocalizedName("infusion_crystal");
		
		//Game Registry
		GameRegistry.registerItem(Rune, Rune.getUnlocalizedName());
		GameRegistry.registerItem(BindingCream, BindingCream.getUnlocalizedName());
		GameRegistry.registerItem(InfusionCrystal,InfusionCrystal.getUnlocalizedName());
	}
}
