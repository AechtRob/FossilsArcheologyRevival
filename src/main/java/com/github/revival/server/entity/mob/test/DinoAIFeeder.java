package com.github.revival.server.entity.mob.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.Revival;
import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.ai.DinoAINearestAttackableTargetSorter;
import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.message.MessageFoodParticles;
import com.github.revival.server.util.FoodMappings;

public class DinoAIFeeder extends EntityAIBase {
	private static final int NO_TARGET = -1;
	private static final int ITEM = 1;
	private static final int BLOCK = 2;
	private static final int FEEDER = 3;
	private final int searchRange;
	private final int USE_RANGE = 3;
	protected EntityCreature taskOwner;
	private EntityNewPrehistoric dinosaur;
	private double destX;
	private double destY;
	private double destZ;
	private int typeofTarget = NO_TARGET;
	private int TimeAtThisTarget = 0;
	private TileEntityNewFeeder targetFeeder;
	private EntityItem targetItem;
	private Vec3 targetBlock;
	private EntityLivingBase targetEntity;
	private DinoAINearestAttackableTargetSorter targetSorter;
	private World theWorld;
	private int entityPosX;
	private int entityPosY;
	private int entityPosZ;

	public DinoAIFeeder(EntityNewPrehistoric dinosaur, int targetRange) {
		this.theWorld = dinosaur.worldObj;
		this.targetFeeder = null;
		this.dinosaur = dinosaur;
		this.searchRange = targetRange;
		this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.dinosaur);
		this.TimeAtThisTarget = 0;
	}

	public boolean isInterruptible() {
		return false;
	}

	public boolean shouldExecute() {

		int range = this.searchRange;

		if (!theWorld.isRemote) {
			if (!FossilConfig.starvingDinos) {
				return false;
			}
		}

		if (!this.dinosaur.IsHungry()) {
			this.typeofTarget = NO_TARGET;
			return false;
		}

		PathNavigate pathnavigate = this.dinosaur.getNavigator();
		PathEntity pathentity = pathnavigate.getPath();

		if (pathentity != null && !pathentity.isFinished()) {
			PathPoint pathpoint = pathentity.getFinalPathPoint();
			this.entityPosX = pathpoint.xCoord;
			this.entityPosY = pathpoint.yCoord + 1;
			this.entityPosZ = pathpoint.zCoord;

			if (this.dinosaur.getDistanceSq((double) this.entityPosX, this.dinosaur.posY, (double) this.entityPosZ) <= 5.25D) {
				if (this.dinosaur.selfType.useFeeder()) {
					this.targetFeeder = this.dinosaur.getNearestFeeder(range / 2);

					if (this.targetFeeder != null) {
						Revival.printDebug("Found Feeder at: " + this.targetFeeder.xCoord + ", " + this.targetFeeder.yCoord + ", " + this.targetFeeder.zCoord);
						this.destX = this.targetFeeder.xCoord;
						this.destY = this.targetFeeder.yCoord;
						this.destZ = this.targetFeeder.zCoord;
						this.typeofTarget = FEEDER;
						return true;
					}
				}
			}
		}
		this.targetItem = this.getNearestItem(this.searchRange);
		if (this.targetItem != null) {
			this.destX = targetItem.posX;
			this.destY = targetItem.posY;
			this.destZ = targetItem.posZ;
			this.typeofTarget = ITEM;
			return true;
		}
		if (!this.dinosaur.selfType.FoodBlockList.IsEmpty())//Hasn't found anything and has blocks it can look for
		{
			Vec3 targetBlock = this.dinosaur.getBlockToEat(this.searchRange);

			if (targetBlock != null)//Found Item, go there and eat it
			{
				this.destX = targetBlock.xCoord;
				this.destY = targetBlock.yCoord;
				this.destZ = targetBlock.zCoord;
				this.typeofTarget = BLOCK;
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	@Override
	public boolean continueExecuting() {
		double Distance = Math.sqrt(Math.pow(this.dinosaur.posX - this.destX, 2.0D) + Math.pow(this.dinosaur.posZ - this.destZ, 2.0D));

		if (!this.dinosaur.IsHungry()) {
			endTask();
			return false;
		}

		if (Distance > this.searchRange) {
			Revival.printDebug("Target too far, discontinuing task. Distance: " + Distance + ", Range: " + this.searchRange);
			endTask();
			return false;
		}

		switch (this.typeofTarget) {
		case NO_TARGET:
		default:
			endTask();
			return false;
		case ITEM:
			return this.targetItem.isEntityAlive() && this.targetItem != null;
		case BLOCK:
			return this.dinosaur.selfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)) && this.targetBlock != null;
		case FEEDER:
			return !this.targetFeeder.isInvalid();
			//return targetFeeder != null;

		}

		//return ((this.dinosaur.IsHungry() || this.dinosaur.IsDeadlyHungry()) && (this.typeofTarget != -1));
	}

	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {
		dinosaur.worldObj.spawnParticle("smoke", dinosaur.posX, dinosaur.posY, dinosaur.posZ, 0, 0, 0);
		int Range = this.searchRange;
		this.dinosaur.setSitting(false);
		this.dinosaur.setOrder(EnumOrderType.FreeMove);
		double Distance = Math.sqrt(Math.pow(this.dinosaur.posX - this.destX, 2.0D) + Math.pow(this.dinosaur.posZ - this.destZ, 2.0D));

		if (this.typeofTarget == FEEDER) {
			Revival.printDebug("Update Feeder Task");
			if (this.targetFeeder == null) {
				endTask();
			}

			if (Distance < Range) {
				this.dinosaur.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, 1.0D);

				if (Distance < 4.5D) {
					if (this.targetFeeder != null) {
						if(this.dinosaur.ticksEating < 30){
							this.dinosaur.ticksEating++;
							int healval = MathHelper.floor_double(this.targetFeeder.feedDinosaur(this.dinosaur) / 15D);
							this.dinosaur.heal(healval);
							this.dinosaur.doFoodEffect(null);
							Revival.channel.sendToAll(new MessageFoodParticles(dinosaur.getEntityId()));
							dinosaur.worldObj.spawnParticle("smoke", dinosaur.posX, dinosaur.posY, dinosaur.posZ, 0, 0, 0);
						}else{
							dinosaur.ticksEating = 0;
							endTask();
						}
					}
				}
			} else {
				endTask();
			}

		}

		if (this.typeofTarget == ITEM) {

			if (Distance < this.searchRange && this.targetItem.isEntityAlive() && this.targetItem != null) {
				Revival.printDebug("Update Item Task");
				this.dinosaur.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, 1.0D);
				if (Distance < 2.5) {

					if (this.targetItem != null && this.targetItem.isEntityAlive()) {
						this.dinosaur.eatItem(this.targetItem.getEntityItem());
						endTask(); 
					}
				}
			} else {
				Revival.printDebug("Ending Item Task");
				endTask();
			}

		}

		if (this.typeofTarget == BLOCK) {
			Revival.printDebug("Update Block Task");
			if (!this.dinosaur.selfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ))) {
				endTask();
			}
			if (Distance < Range) {
				this.dinosaur.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, 1.0D);
				if (Distance < 2.5) {
					if (this.dinosaur.selfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ))) {
						this.dinosaur.heal(this.dinosaur.selfType.FoodBlockList.getBlockHeal(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)));
						this.dinosaur.increaseHunger(this.dinosaur.selfType.FoodBlockList.getBlockFood(Item.getItemFromBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ))));
						this.dinosaur.worldObj.setBlock((int) destX, (int) destY, (int) destZ, Blocks.air, 0, 2);
						endTask();
					}
				}
			} else {
				endTask();
			}
		}
	}

	public void endTask() {
		this.dinosaur.getNavigator().clearPathEntity();
		this.TimeAtThisTarget = 0;
		targetItem = null;
		targetBlock = null;
		targetFeeder = null;
		this.targetEntity = null;
		this.typeofTarget = NO_TARGET;
	}

	/**
	 * Resets the task
	 */
	public void resetTask() {
		this.TimeAtThisTarget = 0;
		targetItem = null;
		targetBlock = null;
		targetFeeder = null;
		this.targetEntity = null;
		this.typeofTarget = NO_TARGET;
	}

	private TileEntityNewFeeder getNearbyFeeder() {
		double range = 36;
		List<TileEntity> nearbyEntities = theWorld.getEntitiesWithinAABB(TileEntityNewFeeder.class, this.dinosaur.boundingBox.expand(range, range, range));

		for (TileEntity entityFeeder : nearbyEntities) {
			TileEntityNewFeeder nearbyFeeder = (TileEntityNewFeeder) entityFeeder;

			if (this.dinosaur.selfType.useFeeder()) {
				return nearbyFeeder;
			}
		}

		return null;
	}

	private EntityItem getNearestItem(int range) {
		List nearbyItems = this.dinosaur.worldObj.getEntitiesWithinAABB(EntityItem.class, this.dinosaur.boundingBox.expand(range, range, range));
		Collections.sort(nearbyItems, this.targetSorter);
		Iterator iterateNearbyItems = nearbyItems.iterator();
		EntityItem entityItem = null;

		while (iterateNearbyItems.hasNext()) {

			EntityItem entityItem1 = (EntityItem) iterateNearbyItems.next();
			if(entityItem1.getEntityItem() != null && entityItem1.getEntityItem().getItem() != null)
				if ((FoodMappings.instance().getItemFoodAmount(entityItem1.getEntityItem().getItem(), dinosaur.selfType.diet) != 0) && this.dinosaur.getDistanceSqToEntity(entityItem1) < range) {
					entityItem = entityItem1;
				}
		}
		return entityItem;
	}

	/*
    private Vec3 getNearestItem(int SEARCH_RANGE)
    {
        List nearbyItems = this.dinosaur.worldObj.getEntitiesWithinAABB(EntityItem.class, this.dinosaur.boundingBox.expand(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE));
        Collections.sort(nearbyItems, this.targetSorter);
        Iterator iterateNearbyItems = nearbyItems.iterator();
        Vec3 itemlocation = null;

        while (iterateNearbyItems.hasNext())
        {
            EntityItem entityItem = (EntityItem) iterateNearbyItems.next();

            if (this.dinosaur.selfType.FoodItemList.CheckItemById(entityItem.getEntityItem().itemID) || this.dinosaur.selfType.FoodBlockList.CheckBlockById(entityItem.getEntityItem().itemID))
            {
            	Revival.printDebug("targetItem: "+ entityItem);
            		this.targetItem = entityItem;            

                itemlocation = Vec3.createVectorHelper(entityItem.posX, entityItem.posY, entityItem.posZ);
                break;
            }
        }

        return itemlocation;
    }
	 */

}