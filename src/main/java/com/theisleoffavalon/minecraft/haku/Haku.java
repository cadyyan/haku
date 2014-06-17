package com.theisleoffavalon.minecraft.haku;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.theisleoffavalon.minecraft.haku.config.Config;
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
	public static final String MODID = "theisleoffavalon_haku";
	public static final String NAME  = "Haku";
	
	public static final String TEXTURE_PATH_ENTITIES = "textures/entities";
	
	@Instance(Haku.MODID)
	public static Haku instance;
	
	@SidedProxy(
		clientSide = "com.theisleoffavalon.minecraft.haku.ClientProxy",
		serverSide = "com.theisleoffavalon.minecraft.haku.CommonProxy"
	)
	public static CommonProxy proxy;
	
	public static final Logger log = LogManager.getLogger("HAKU");
	
	/**
	 * Mod configuration directory
	 */
	private File modDir;
	
	/**
	 * Mod entity event handler
	 */
	private EventHandlerEntity entityEventHandler;
	
	/**
	 * The creative mode inventory tab
	 */
	private CreativeTabs creativeTab;
	
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
		
		this.creativeTab = new HakuCreativeTab();
		
		this.entityEventHandler = new EventHandlerEntity();
		MinecraftForge.EVENT_BUS.register(this.entityEventHandler);
		
		Config.save();
		
		proxy.registerHandlers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerEntities();
		proxy.registerEntityRenderers();
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
	
	/**
	 * Get the creative mode tab for Haku.
	 * 
	 * @return the creative mode tab
	 */
	public CreativeTabs getCreativeTab()
	{
		return creativeTab;
	}
}
