package com.rcraft.bindingcraft.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value = Side.CLIENT)
public class ClientProxy implements CommonProxy{

	@Override
	public void registerRenderers() {
		
	}

}
