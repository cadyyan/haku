package com.theisleoffavalon.minecraft.haku;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class HakuCreativeTab extends CreativeTabs
{
	public HakuCreativeTab()
	{
		super(Haku.NAME);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Items.diamond; // TODO: set haku creative tab icon
	}
}
