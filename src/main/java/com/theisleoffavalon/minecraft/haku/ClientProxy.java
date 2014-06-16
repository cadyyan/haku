package com.theisleoffavalon.minecraft.haku;

import com.theisleoffavalon.minecraft.haku.client.renders.entities.RenderSusuwatari;
import com.theisleoffavalon.minecraft.haku.entities.Susuwatari;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerEntityRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(Susuwatari.class, new RenderSusuwatari());
	}
}
