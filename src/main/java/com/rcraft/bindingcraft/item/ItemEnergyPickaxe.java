package com.rcraft.bindingcraft.item;

import com.rcraft.bindingcraft.BindingCraft;
import com.rcraft.bindingcraft.block.LoadBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;

public class ItemEnergyPickaxe extends ItemPickaxe{
    public static final Block[] blocksEffectiveAgainst = new Block[] {LoadBlocks.EnergyVein};
	public ItemEnergyPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setCreativeTab(BindingCraft.tabBindingCraft);
	}
}
