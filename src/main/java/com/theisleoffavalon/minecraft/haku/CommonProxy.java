package com.theisleoffavalon.minecraft.haku;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import com.theisleoffavalon.minecraft.haku.entities.Susuwatari;

import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy
{
	/**
	 * ID counter for spawn eggs
	 */
	private int eggIDCounter = 300;
	
	public void registerHandlers()
	{
	}
	
	public void registerEntities()
	{
		int id = 0;
		
		EntityRegistry.registerModEntity(
			Susuwatari.class,
			Susuwatari.getName(),
			id++,
			Haku.instance,
			64,
			20,
			true
		);
		registerEntityEgg(Susuwatari.class, 0x323232, 0x282828);
	}
	
	public void registerEntityRenderers()
	{
	}
	
	private int getUniqueEntityEggID()
	{
		do
		{
			eggIDCounter++;
		}
		while (EntityList.getStringFromID(eggIDCounter) != null);
		
		return eggIDCounter;
	}
	
	@SuppressWarnings("unchecked")
	private void registerEntityEgg(Class<? extends Entity> entityClass, int primaryColor, int secondaryColor)
	{
		int eggID = getUniqueEntityEggID();
		
		EntityList.IDtoClassMapping.put(eggID, entityClass);
		EntityList.entityEggs.put(eggID, new EntityList.EntityEggInfo(eggID, primaryColor, secondaryColor));
	}
}
