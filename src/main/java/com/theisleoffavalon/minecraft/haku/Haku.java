package com.theisleoffavalon.minecraft.haku;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.theisleoffavalon.minecraft.haku.config.Config;
import com.theisleoffavalon.minecraft.haku.config.ConfigEntities;
import com.theisleoffavalon.minecraft.haku.events.EventHandlerEntity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Haku.MODID, name = Haku.NAME)
public class Haku
{
	public static final String MODID   = "theisleoffavalon_haku";
	public static final String NAME    = "Haku";
	
	@Instance(Haku.MODID)
	public static Haku instance;
	
	@SidedProxy(
		clientSide = "com.theisleoffavalon.minecraft.haku.CommonProxy",
		serverSide = "com.theisleoffavalon.minecraft.haku.CommonProxy"
	)
	public static CommonProxy proxy;
	
	public static final Logger log = LogManager.getLogger("HAKU");
	
	/**
	 * Mod configuration directory
	 */
	private File modDir;
	
	private EventHandlerEntity entityEventHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.modDir = event.getModConfigurationDirectory();
		
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		}
		catch (Exception ex)
		{
			log.error("Haku encountered a problem when loading it's configuration");
		}
		finally
		{
			if (Config.config != null)
				Config.save();
		}
		
		this.entityEventHandler = new EventHandlerEntity();
		MinecraftForge.EVENT_BUS.register(this.entityEventHandler);
		
		Config.save();
		
		proxy.registerHandlers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ConfigEntities.initialize();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// TODO: post initialization
	}
	
	/**
	 * Get the mod configuration directory.
	 * 
	 * @return mod configuration directory
	 */
	public File getModDir()
	{
		return modDir;
	}
}