package com.rcraft.bindingcraft.block.gen;

import java.util.Random;

import com.rcraft.bindingcraft.block.LoadBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateBlocks implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for(int rarity = 0; rarity < 16; rarity++){// Rarity is how many times a vein shows in a chunk.
			int firstBlockXCoord = chunkX + random.nextInt(16);
			int firstBlockYCoord = random.nextInt(64); //Height the ore stops generating at.
			int firstBlockZCoord = chunkZ + random.nextInt(16);
			//System.out.println("X:"+firstBlockXCoord +" Y:"+firstBlockYCoord+" Z:"+firstBlockZCoord);
			WorldGenMinable wgm = new WorldGenMinable(LoadBlocks.EnergyVein.blockID,1+random.nextInt(10));
			wgm.generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
		
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		
	}

}
