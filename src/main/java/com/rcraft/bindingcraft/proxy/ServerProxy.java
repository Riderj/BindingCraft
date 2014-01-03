package com.rcraft.bindingcraft.proxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value = Side.SERVER)
public class ServerProxy implements CommonProxy{

	@Override
	public void registerRenderers() {
		//Server doesn't render anything?
	}

}
