package com.rcraft.bindingcraft.item;

import com.rcraft.bindingcraft.BindingCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class LoadItems {
	
	
	//Items
	public static Item Rune;
	public static Item BindingCream;
	public static Item InfusionCrystal;
	public static Item EnergyShard;
	public static Item EnergyStick;
	public static Item EnergyPickaxe;
	
	//Tools
	
	
	public static void init(){
		
		//Items
		Rune = new ItemRune(5000).setUnlocalizedName("rune");
		BindingCream = new ItemBindingCream(5001).setUnlocalizedName("binding_cream");
		InfusionCrystal = new ItemInfusionCrystal(5002).setUnlocalizedName("infusion_crystal");
		EnergyShard = new ItemEnergyShard(5003).setUnlocalizedName("energy_shard");
		EnergyStick = new ItemEnergyShard(5005).setUnlocalizedName("energy_stick");
		
		//Tools
		EnergyPickaxe = new ItemEnergyPickaxe(5004,BindingCraft.energyMaterial).setUnlocalizedName("energy_pickaxe").setTextureName("bindingcraft:energy_pickaxe");

		//Game Registry
		
		//items
		GameRegistry.registerItem(Rune, Rune.getUnlocalizedName());
		GameRegistry.registerItem(BindingCream, BindingCream.getUnlocalizedName());
		GameRegistry.registerItem(InfusionCrystal,InfusionCrystal.getUnlocalizedName());
		GameRegistry.registerItem(EnergyShard,EnergyShard.getUnlocalizedName());
		GameRegistry.registerItem(EnergyStick,EnergyStick.getUnlocalizedName());
		
		//tools
		GameRegistry.registerItem(EnergyPickaxe,EnergyPickaxe.getUnlocalizedName());
	}
}
