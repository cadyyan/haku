package com.theisleoffavalon.minecraft.haku.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config
{
	public static Configuration config;
	
	public static final String CATEGORY_ENTITIES = "Entities";
	
	/**
	 * Initialize the configuration file if it doesn't exist and load data from the configuration
	 * file.
	 * 
	 * @param configFile - the config file
	 */
	public static void initialize(File configFile)
	{
		config = new Configuration(configFile);
		
		config.load();
	}
	
	/**
	 * Save the config to disk
	 */
	public static void save()
	{
		config.save();
	}
}
