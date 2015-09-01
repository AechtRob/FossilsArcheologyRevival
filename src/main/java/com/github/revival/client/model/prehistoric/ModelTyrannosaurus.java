package com.github.revival.client.model.prehistoric;

<<<<<<< HEAD
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelTyrannosaurus extends MowzieModelBase
=======
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelTyrannosaurus extends ModelPrehistoric
>>>>>>> origin/master
{
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer rightThigh;
    public MowzieModelRenderer leftThigh;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer leftTailFeather;
    public MowzieModelRenderer rightTailFeather;
    public MowzieModelRenderer middleTailFrontFeather;
    public MowzieModelRenderer middleTailBackFeather;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftUpperArm;
    public MowzieModelRenderer rightUpperArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headPivot;
    public MowzieModelRenderer leftCrest;
    public MowzieModelRenderer rightCrest;
    public MowzieModelRenderer middleCrest;
    public MowzieModelRenderer upperJaw;
    public MowzieModelRenderer lowerJaw;
    public MowzieModelRenderer teeth;
    public MowzieModelRenderer leftLowerArm;
    public MowzieModelRenderer rightLowerArm;
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer leftFoot;

    public ModelTyrannosaurus()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.middleCrest = new MowzieModelRenderer(this, 10, 53);
        this.middleCrest.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.middleCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(middleCrest, 0.16074482410867777F, -0.0F, 0.0F);
=======
        this.setRotateAngle(middleCrest, 0.16074482410867777F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.tail1 = new MowzieModelRenderer(this, 36, 47);
        this.tail1.setRotationPoint(0.0F, 0.2F, 11.0F);
        this.tail1.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 10, 0.0F);
        this.leftTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.leftTailFeather.setRotationPoint(1.0F, 1.7F, 0.0F);
        this.leftTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(leftTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 103, 49);
        this.tail3.setRotationPoint(0.0F, 0.7F, 10.0F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 8, 0.0F);
        ModelUtils.setRotateAngle(tail3, -0.14800392056911915F, -0.0F, 0.0F);
        this.rightCrest = new MowzieModelRenderer(this, 10, 53);
        this.rightCrest.setRotationPoint(-2.5F, -0.8F, -0.5F);
        this.rightCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(rightCrest, -0.07068583470577035F, -0.0F, 0.0F);
=======
        this.setRotateAngle(leftTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 103, 49);
        this.tail3.setRotationPoint(0.0F, 0.7F, 10.0F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 8, 0.0F);
        this.setRotateAngle(tail3, -0.14800392056911915F, -0.0F, 0.0F);
        this.rightCrest = new MowzieModelRenderer(this, 10, 53);
        this.rightCrest.setRotationPoint(-2.5F, -0.8F, -0.5F);
        this.rightCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightCrest, -0.07068583470577035F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.leftThigh = new MowzieModelRenderer(this, 2, 17);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(2.5F, 9.6F, 7.5F);
        this.leftThigh.addBox(0.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 74, 48);
        this.tail2.setRotationPoint(0.0F, 0.6F, 9.0F);
        this.tail2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 10, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(tail2, 0.03717551306747922F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 98, 31);
        this.leftLeg.setRotationPoint(2.5F, 4.5F, 1.5F);
        this.leftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        ModelUtils.setRotateAngle(leftLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 52, 0);
        this.neck.setRotationPoint(0.0F, -0.1F, -7.5F);
        this.neck.addBox(-2.5F, -3.0F, -9.0F, 5, 7, 9, 0.0F);
        ModelUtils.setRotateAngle(neck, -0.5895722213236846F, -0.0F, 0.0F);
        this.middleTailFrontFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailFrontFeather.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.middleTailFrontFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(middleTailFrontFeather, 0.3269001688985379F, -0.0F, 0.0F);
        this.leftUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.leftUpperArm.setRotationPoint(3.0F, 2.3F, -9.0F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(leftUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 3, 45);
        this.leftFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        ModelUtils.setRotateAngle(leftFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 98, 31);
        this.rightLeg.setRotationPoint(-2.5F, 4.5F, 1.5F);
        this.rightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        ModelUtils.setRotateAngle(rightLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.rightTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.rightTailFeather.setRotationPoint(-1.0F, 1.7F, 0.0F);
        this.rightTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(rightTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
=======
        this.setRotateAngle(tail2, 0.03717551306747922F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 98, 31);
        this.leftLeg.setRotationPoint(2.5F, 4.5F, 1.5F);
        this.leftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(leftLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 52, 0);
        this.neck.setRotationPoint(0.0F, -0.1F, -7.5F);
        this.neck.addBox(-2.5F, -3.0F, -9.0F, 5, 7, 9, 0.0F);
        this.setRotateAngle(neck, -0.5895722213236846F, -0.0F, 0.0F);
        this.middleTailFrontFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailFrontFeather.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.middleTailFrontFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(middleTailFrontFeather, 0.3269001688985379F, -0.0F, 0.0F);
        this.leftUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.leftUpperArm.setRotationPoint(3.0F, 2.3F, -9.0F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 3, 45);
        this.leftFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(leftFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 98, 31);
        this.rightLeg.setRotationPoint(-2.5F, 4.5F, 1.5F);
        this.rightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(rightLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.rightTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.rightTailFeather.setRotationPoint(-1.0F, 1.7F, 0.0F);
        this.rightTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-3.0F, 2.3F, -9.0F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.leftLowerArm.setRotationPoint(1.01F, 2.5F, -0.4F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 27, 12);
        this.lowerJaw.setRotationPoint(0.0F, 2.5F, -7.0F);
        this.lowerJaw.addBox(-2.0F, 0.0F, -6.0F, 4, 2, 6, 0.0F);
        ModelUtils.setRotateAngle(lowerJaw, 0.02199114857512855F, -0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 57, 20);
        this.lowerBody.setRotationPoint(0.0F, 4.6F, -1.0F);
        this.lowerBody.addBox(-4.0F, 0.0F, 0.0F, 8, 11, 12, 0.0F);
        ModelUtils.setRotateAngle(lowerBody, -0.03490658503988659F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.leftLowerArm.setRotationPoint(1.01F, 2.5F, -0.4F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 27, 12);
        this.lowerJaw.setRotationPoint(0.0F, 2.5F, -7.0F);
        this.lowerJaw.addBox(-2.0F, 0.0F, -6.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(lowerJaw, 0.02199114857512855F, -0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 57, 20);
        this.lowerBody.setRotationPoint(0.0F, 4.6F, -1.0F);
        this.lowerBody.addBox(-4.0F, 0.0F, 0.0F, 8, 11, 12, 0.0F);
        this.setRotateAngle(lowerBody, -0.03490658503988659F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightThigh = new MowzieModelRenderer(this, 2, 17);
        this.rightThigh.setRotationPoint(-2.5F, 9.6F, 7.5F);
        this.rightThigh.addBox(-4.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 3, 45);
        this.rightFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.rightFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.leftCrest = new MowzieModelRenderer(this, 10, 53);
        this.leftCrest.setRotationPoint(2.5F, -0.8F, -0.5F);
        this.leftCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(leftCrest, -0.07068583470577035F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.leftCrest = new MowzieModelRenderer(this, 10, 53);
        this.leftCrest.setRotationPoint(2.5F, -0.8F, -0.5F);
        this.leftCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftCrest, -0.07068583470577035F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.teeth = new MowzieModelRenderer(this, 44, 18);
        this.teeth.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.teeth.addBox(-2.5F, 0.0F, -6.0F, 5, 1, 7, 0.0F);
        this.upperJaw = new MowzieModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, -0.5F, -6.7F);
        this.upperJaw.addBox(-2.5F, -2.0F, -7.0F, 5, 5, 7, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(upperJaw, 0.03490658503988659F, -0.0F, 0.0F);
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -0.8F, -7.1F);
        this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0);
        ModelUtils.setRotateAngle(headPivot, 0.6457718232379019F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0F, 0F);
        this.head.addBox(-3.5F, -3.0F, -7.0F, 7, 8, 7, 0.0F);
        ModelUtils.setRotateAngle(head, 0F, -0.0F, 0.0F);
=======
        this.setRotateAngle(upperJaw, 0.03490658503988659F, -0.0F, 0.0F);
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -0.8F, -7.1F);
        this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0);
        this.setRotateAngle(headPivot, 0.6457718232379019F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0F, 0F);
        this.head.addBox(-3.5F, -3.0F, -7.0F, 7, 8, 7, 0.0F);
        this.setRotateAngle(head, 0F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-1.01F, 2.5F, -0.4F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 80, 0);
        this.upperBody.setRotationPoint(0.0F, 4.0F, 2.5F);
        this.upperBody.addBox(-3.0F, -4.0F, -10.0F, 6, 10, 10, 0.0F);
        ModelUtils.setRotateAngle(upperBody, 0.11309733552923257F, -0.0F, 0.0F);
        this.middleTailBackFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailBackFeather.setRotationPoint(0.0F, 1.5F, 5.0F);
        this.middleTailBackFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(middleTailBackFeather, 0.1759291886010284F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 80, 0);
        this.upperBody.setRotationPoint(0.0F, 4.0F, 2.5F);
        this.upperBody.addBox(-3.0F, -4.0F, -10.0F, 6, 10, 10, 0.0F);
        this.setRotateAngle(upperBody, 0.11309733552923257F, -0.0F, 0.0F);
        this.middleTailBackFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailBackFeather.setRotationPoint(0.0F, 1.5F, 5.0F);
        this.middleTailBackFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(middleTailBackFeather, 0.1759291886010284F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.head.addChild(this.middleCrest);
        this.lowerBody.addChild(this.tail1);
        this.tail3.addChild(this.leftTailFeather);
        this.tail2.addChild(this.tail3);
        this.head.addChild(this.rightCrest);
        this.tail1.addChild(this.tail2);
        this.leftThigh.addChild(this.leftLeg);
        this.upperBody.addChild(this.neck);
        this.tail3.addChild(this.middleTailFrontFeather);
        this.upperBody.addChild(this.leftUpperArm);
        this.leftLeg.addChild(this.leftFoot);
        this.rightThigh.addChild(this.rightLeg);
        this.tail3.addChild(this.rightTailFeather);
        this.upperBody.addChild(this.rightUpperArm);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.head.addChild(this.lowerJaw);
        this.rightLeg.addChild(this.rightFoot);
        this.head.addChild(this.leftCrest);
        this.upperJaw.addChild(this.teeth);
        this.head.addChild(this.upperJaw);
        this.headPivot.addChild(this.head);
        this.neck.addChild(this.headPivot);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.lowerBody.addChild(this.upperBody);
        this.tail3.addChild(this.middleTailBackFeather);
<<<<<<< HEAD
		ModelUtils.doMowzieStuff(false, boxList);
    }

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		ModelUtils.doMowzieStuff(true, boxList);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		ModelUtils.renderAll(boxList);
	}
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
		MowzieModelRenderer[] neckParts = {this.neck};
		MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

		this.faceTarget(head, 1, f3, f4);
		
		float speed = 0.5F;
		float speed2 = 0.1F;

		this.bob(lowerBody, speed2, 0.7F, false, entity.ticksExisted, 1);
		this.walk(leftThigh, speed, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftLeg, speed, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(leftFoot, speed, -0.4F, false, 4.5F, 0.4F, f, f1);
		this.walk(rightThigh, speed, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLeg, speed, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed, -0.4F, true, 4.5F, 0.4F, f, f1);
		this.chainWave(tailParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.15F, -3, entity.ticksExisted, 1);

	}

=======
       doMowzieStuff(false);
    }

>>>>>>> origin/master
   /* public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, f6);
        if (f6 instanceof EntityDinosaur)
        {
            if (!((EntityDinosaur) f6).isModelized())
            {

                tail1.rotateAngleY = 0.08F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
                tail2.rotateAngleY = 0.10F * MathHelper.sin(f2 * (float) 0.1F + f1 + 1);
                tail3.rotateAngleY = 0.15F * MathHelper.sin(f2 * (float) 0.1F + f1);

                // this.UpperLegRight.rotateAngleX = MathHelper.cos(f * 0.5662F) * 1.0F * f1;
                //  this.UpperLegLeft.rotateAngleX = MathHelper.cos(f * 0.5662F + (float)Math.PI) * 1.0F * f1;

                head.rotateAngleX = (f4 / (180F / (float) Math.PI));
                head.rotateAngleY = (f3 / (180F / (float) Math.PI));
                walk(leftThigh, 0.5F * 1, 0.8F, false, 0F, 0.4F, f, f1);
                //	walk(leftLeg, 0.5F * 1, 0.5F, false, 0F, 0F, f, f1);
                //	walk(leftFoot, 0.5F * 1, 1.5F, false, 0.5F, 1F, f, f1);
                walk(rightThigh, 0.5F * 1, 0.8F, true, 0F, 0.4F, f, f1);
                //	walk(rightLeg, 0.5F * 1, 0.5F, true, 0F, 0F, f, f1);
                //	walk(rightFoot, 0.5F * 1, 1.5F, true, 0.5F, 1F, f, f1);

            }
            else
            {
                tail1.rotateAngleY = 0F;
                tail2.rotateAngleY = 0F;
                tail3.rotateAngleY = 0F;

                head.rotateAngleX = 0F;
                head.rotateAngleY = 0F;
                rightThigh.rotateAngleX = 0F;
                leftThigh.rotateAngleX = 0F;
                rightLeg.rotateAngleX = -0.3270747018237373F;
                leftLeg.rotateAngleX = -0.3270747018237373F;
                rightFoot.rotateAngleX = 0.33161255787892263F;
                leftFoot.rotateAngleX = 0.33161255787892263F;
            }
        }
        else
        {

            tail1.rotateAngleY = 0.08F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
            tail2.rotateAngleY = 0.10F * MathHelper.sin(f2 * (float) 0.1F + f1 + 1);
            tail3.rotateAngleY = 0.15F * MathHelper.sin(f2 * (float) 0.1F + f1);

            // this.UpperLegRight.rotateAngleX = MathHelper.cos(f * 0.5662F) * 1.0F * f1;
            //  this.UpperLegLeft.rotateAngleX = MathHelper.cos(f * 0.5662F + (float)Math.PI) * 1.0F * f1;

            head.rotateAngleX = (f4 / (180F / (float) Math.PI));
            head.rotateAngleY = (f3 / (180F / (float) Math.PI));
            walk(leftThigh, 0.5F * 1, 0.8F, false, 0F, 0.4F, f, f1);
            //	walk(leftLeg, 0.5F * 1, 0.5F, false, 0F, 0F, f, f1);
            //	walk(leftFoot, 0.5F * 1, 1.5F, false, 0.5F, 1F, f, f1);
            walk(rightThigh, 0.5F * 1, 0.8F, true, 0F, 0.4F, f, f1);
            //	walk(rightLeg, 0.5F * 1, 0.5F, true, 0F, 0F, f, f1);
            //	walk(rightFoot, 0.5F * 1, 1.5F, true, 0.5F, 1F, f, f1);
        }
    }*/
<<<<<<< HEAD
=======


	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
	}
>>>>>>> origin/master
}
