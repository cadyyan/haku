package com.theisleoffavalon.minecraft.haku.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Soot spirits. Drops 0-2 coal and 0-2 gunpowder on death. Wander around randomly.
 */
public class Susuwatari extends EntityCreature
{
	private static final double MAX_HEALTH          = 1.0D;
	private static final double BASE_MOVEMENT_SPEED = 0.25D;
	
	public static String getName()
	{
		return "Susuwatari";
	}
	
	public Susuwatari(World world)
	{
		super(world);
		
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		
		// TODO: onLivingUpdate
	}
	
	@Override
	public void setAIMoveSpeed(float speed)
	{
		super.setAIMoveSpeed(speed);
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MAX_HEALTH);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(BASE_MOVEMENT_SPEED);
	}
	
	@Override
	protected String getLivingSound()
	{
		return "mob.chicken.say"; // TODO: set living sound
	}
	
	@Override
	protected String getHurtSound()
	{
		return "mob.chicken.hurt"; // TODO: set hurt sound
	}
	
	@Override
	protected String getDeathSound()
	{
		return "mob.chicken.hurt"; // TODO: set death sound
	}
	
	@Override
	protected void func_145780_a(int param0, int param1, int param2, Block block)
	{
		this.playSound("mob.chicken.step", 0.15F, 1.0F); // TODO: set step sound
	}
	
	@Override
	protected Item getDropItem()
	{
		return Items.coal;
	}
	
	@Override
	protected void dropFewItems(boolean hitByPlayer, int lootLevel)
	{
		int coalDrop      = this.rand.nextInt(3) + this.rand.nextInt(1 + lootLevel);
		int gunpowderDrop = this.rand.nextInt(3) + this.rand.nextInt(1 + lootLevel);
		
		this.dropItem(Items.coal, coalDrop);
		this.dropItem(Items.gunpowder, gunpowderDrop);
	}
}
