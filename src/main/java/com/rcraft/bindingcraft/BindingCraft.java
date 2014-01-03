package com.rcraft.bindingcraft;

import net.minecraft.creativetab.CreativeTabs;

import com.rcraft.bindingcraft.block.LoadBlocks;
import com.rcraft.bindingcraft.block.gen.GenerateBlocks;
import com.rcraft.bindingcraft.creativetab.CreativeTabBindingCraft;
import com.rcraft.bindingcraft.item.LoadItems;
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



@Mod(modid=BindingCraft.MODID, name = "BindingCraft", version=BindingCraft.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class BindingCraft {

	public static final String MODID = "bindingcraft";
	public static final String VERSION = "0.0.01";
	
	@SidedProxy(clientSide = "com.rcraft.bindingcraft.proxy.ClientProxy", serverSide = "com.rcraft.bindingcraft.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	
	@Instance(value = MODID)
	public static BindingCraft instance;
	
	public static CreativeTabs tabBindingCraft = new CreativeTabBindingCraft("tabBindingCraft");
	
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		LoadItems.init();
		LoadBlocks.init();
		
		GameRegistry.registerWorldGenerator(new GenerateBlocks());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
		
	}
}
