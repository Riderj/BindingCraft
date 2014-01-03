package com.rcraft.bindingcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class LoadBlocks {
	
	public static Block HellishDirt;
	public static Block EnergyVein;
	
	public static void init(){
		HellishDirt = new BlockHellishDirt(500,Material.ground).setUnlocalizedName("hellish_dirt");
		EnergyVein = new BlockEnergyVein(501, Material.rock).setUnlocalizedName("energyvein");
		
		//Register the blocks
		GameRegistry.registerBlock(HellishDirt, "hellish_dirt");
		GameRegistry.registerBlock(EnergyVein, "energyvein");
	}
}
