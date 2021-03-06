package com.nebulous.nebulousTools;

import com.nebulous.nebulousTools.blocks.BlockBase;
import com.nebulous.nebulousTools.blocks.BlockBaseSlab;
import com.nebulous.nebulousTools.blocks.BlockBaseSlab_Double;
import com.nebulous.nebulousTools.blocks.BlockBaseSlab_Half;
import com.nebulous.nebulousTools.blocks.BlockBaseStairs;
import com.nebulous.nebulousTools.blocks.BlockContainerBase;
import com.nebulous.nebulousTools.blocks.Machine;
import com.nebulous.nebulousTools.items.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static void addBlocks(){
		
		BlockBase darkStone = register(new BlockBase(Material.ROCK, "darkStone").setCreativeTab(CreativeTabs.REDSTONE));
		BlockBase darkStoneBrick = register(new BlockBase(Material.ROCK, "darkStoneBrick").setCreativeTab(CreativeTabs.REDSTONE));
		BlockBase darkStoneSmooth = register(new BlockBase(Material.ROCK, "darkStoneSmooth").setCreativeTab(CreativeTabs.REDSTONE));
		BlockBaseStairs darkStoneBrickStairs = register(new BlockBaseStairs(darkStone.getDefaultState(), "darkStoneBrickStairs"));
		BlockBaseSlab darkStoneBrickSlab = register(new BlockBaseSlab_Half(Material.ROCK, "darkStoneBrickSlab"));
		BlockBaseSlab darkStoneBrickSlab_double = register(new BlockBaseSlab_Double(Material.ROCK, "darkStoneBrickSlab_double"));
		
		BlockBase testBlock = register(new BlockBase(Material.ANVIL, "nebulous_block").setCreativeTab(CreativeTabs.REDSTONE));
		//BlockContainerBase machine = register(new Machine(Material.ANVIL, "nebulous_machine").setCreativeTab(CreativeTabs.REDSTONE));
	}
	
	 private static <T extends Block> T register (T block, ItemBlock itemBlock) {
		 GameRegistry.register(block);
		 if(itemBlock != null) GameRegistry.register(itemBlock);
		 if(block instanceof ItemModelProvider)
			 ((ItemModelProvider)block).registerItemModel(itemBlock);
		 return block;
	}
		 
	private static <T extends Block> T register(T block) {
		 ItemBlock itemBlock = new ItemBlock(block);
		 itemBlock.setRegistryName(block.getRegistryName());
		 return register(block, itemBlock);
	}
}
