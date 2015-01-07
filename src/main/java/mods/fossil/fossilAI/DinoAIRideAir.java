package mods.fossil.fossilAI;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityPrehistoric;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

/*
 * AI for player-controlled air movements.
 */

public class DinoAIRideAir extends DinoAIRide {
    private static final float PLAYER_SPEED = 0.98f;
    private final double speed;
    
    private int lastTimeSeenWhip = -1;
    public int FollowTimeWithoutWhip= 120;

    public DinoAIRideAir(EntityPrehistoric dinosaur, double speed) {
        super(dinosaur);
        this.speed = speed;
    }

    public static boolean hasEquipped(EntityPlayer player, Item item) {
    	if(player == null)
    		return false;
    	
        ItemStack itemStack = player.getCurrentEquippedItem();

        if (itemStack == null) {
            return false;
        }

        return itemStack.getItem() == item;
    }
    
    
    public boolean shouldExecute() {
    	super.shouldExecute();
    	if ( hasEquipped(rider, Fossil.whip) )
    		this.lastTimeSeenWhip=0;

    	return this.lastTimeSeenWhip != -1 && this.dinosaur.riddenByEntity != null;
    	
    }
    
    @Override
    public void startExecuting() {
        dinosaur.getNavigator().clearPathEntity();
        this.lastTimeSeenWhip=-1;
    }


    @Override
    public void resetTask() {
        this.lastTimeSeenWhip=-1;
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
    	if(rider != null) {
        float speedX = rider.moveForward / PLAYER_SPEED;
        float speedY = rider.moveStrafing / PLAYER_SPEED;

        if (hasEquipped(rider, Fossil.whip) || (this.lastTimeSeenWhip < FollowTimeWithoutWhip && this.lastTimeSeenWhip != -1)) {
            float speedPlayer = Math.max(Math.abs(speedX), Math.abs(speedY));
            Vec3 look = rider.getLookVec();
            float dir = Math.min(speedX, 0) * -1;
            dir += speedY / (speedX * 2 + (speedX < 0 ? -2 : 2));

            if (dir != 0) {
                look.rotateAroundY((float) Math.PI * dir);
            }

            if (speedPlayer > 0) {
                dinosaur.getMoveHelper().setMoveTo(dinosaur.posX + look.xCoord, dinosaur.posY + 2, dinosaur.posZ + look.zCoord, speed * speedPlayer);

                //This block checks if the dinosaur can be ridden in water, if so, handle Y velocity. Still looking for elegant way.
                if(!dinosaur.shouldDismountInWater(rider) && dinosaur.isInWater()) {	
                	if(Math.abs(look.yCoord) > 0.4) {
                		dinosaur.motionY = Math.max(-0.15, Math.min(0.15, look.yCoord));
                	}
                }            
            }

            this.lastTimeSeenWhip++;
        }
    	}
    }
}