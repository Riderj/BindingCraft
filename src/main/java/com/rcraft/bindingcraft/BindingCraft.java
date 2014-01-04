package com.rcraft.bindingcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

import com.rcraft.bindingcraft.block.LoadBlocks;
import com.rcraft.bindingcraft.block.gen.GenerateBlocks;
import com.rcraft.bindingcraft.creativetab.CreativeTabBindingCraft;
import com.rcraft.bindingcraft.item.LoadItems;
import com.rcraft.bindingcraft.item.crafting.LoadRecipes;
import com.rcraft.bindingcraft.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
//Setup the basic mod info.
@Mod(modid=BindingCraft.MODID, name = "BindingCraft", version=BindingCraft.VERSION)

//Is it client/server required?
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class BindingCraft {

	//Basic mod variables
	public static final String MODID = "bindingcraft";
	public static final String VERSION = "0.0.102";
	
	
	@SidedProxy(clientSide = "com.rcraft.bindingcraft.proxy.ClientProxy", serverSide = "com.rcraft.bindingcraft.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	
	@Instance(value = MODID)
	public static BindingCraft instance;
	
	
	//Creative Tab Variables
	public static CreativeTabs tabBindingCraft = new CreativeTabBindingCraft("tabBindingCraft");
	
	//Custom enum
	public static final EnumToolMaterial energyMaterial = EnumHelper.addToolMaterial("energyMaterial", 3, 1600, 20.0F, 8.0F, 22);	
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		LoadItems.init();
		LoadBlocks.init();
		LoadRecipes.init();
		
		GameRegistry.registerWorldGenerator(new GenerateBlocks());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
		
	}
}
