package com.rcraft.bindingcraft.block;

import com.rcraft.bindingcraft.BindingCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;

public class BlockMain extends Block {

	public BlockMain(int id, Material par2Material) {
		super(id, par2Material);
		this.setCreativeTab(BindingCraft.tabBindingCraft);
		this.setHardness(1.0F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister){
		blockIcon = iconRegister.registerIcon((BindingCraft.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.')+1)));
	}

}
