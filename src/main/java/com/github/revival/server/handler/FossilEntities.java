package com.github.revival.server.handler;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.github.revival.Revival;
import com.github.revival.server.entity.EntityAncientJavelin;
import com.github.revival.server.entity.EntityAnuEffect;
import com.github.revival.server.entity.EntityAnuLightning;
import com.github.revival.server.entity.EntityDinoEgg;
import com.github.revival.server.entity.EntityJavelin;
import com.github.revival.server.entity.EntityStoneboard;
import com.github.revival.server.entity.mob.EntityAlligatorGar;
import com.github.revival.server.entity.mob.EntityAnu;
import com.github.revival.server.entity.mob.EntityAnuDead;
import com.github.revival.server.entity.mob.EntityAnubite;
import com.github.revival.server.entity.mob.EntityBones;
import com.github.revival.server.entity.mob.EntityCoelacanth;
import com.github.revival.server.entity.mob.EntityFailuresaurus;
import com.github.revival.server.entity.mob.EntityFriendlyPigZombie;
import com.github.revival.server.entity.mob.EntityNautilus;
import com.github.revival.server.entity.mob.EntitySentryPigman;
import com.github.revival.server.entity.mob.EntitySturgeon;
import com.github.revival.server.entity.mob.EntityTarSlime;
import com.github.revival.server.entity.toy.EntityToyBall;
import com.github.revival.server.entity.toy.EntityToyScratchingPost;
import com.github.revival.server.entity.toy.EntityToyTetheredLog;
import com.github.revival.server.enums.EnumMobType;
import com.github.revival.server.enums.EnumPrehistoric;

import cpw.mods.fml.common.registry.EntityRegistry;

public class FossilEntities {

	static int startEntityId = 300;

	public static void registerEntities() {
		EntityRegistry.registerModEntity(EntityStoneboard.class, "StoneBoard", 1, Revival.INSTANCE, 80, Integer.MAX_VALUE, false);
		EntityRegistry.registerModEntity(EntityJavelin.class, "Javelin", 2, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAncientJavelin.class, "AncientJavelin", 3, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAnuLightning.class, "FriendlyLighting", 4, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityFailuresaurus.class, "Failuresaurus", 5, 0x61ffbd, 0xf4eee6);
		registerSpawnable(EntityBones.class, "Bones", 6, 12698049, 4802889);
		EntityRegistry.registerModEntity(EntityDinoEgg.class, "DinoEgg", 8, Revival.INSTANCE, 80, 1, false);
		EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 12, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 34, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityAnubite.class, "Anubite", 39, 0X2E1E14, 0X601200);
		EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 41, Revival.INSTANCE, 80, 3, true);
		registerSpawnable(EntityTarSlime.class, "TarSlime", 99, 0X222222, 0x0B0B0B);
		registerSpawnable(EntityAnu.class, "PigBoss", 101, 0X0F0F0F, 0XF72D00);
		registerSpawnable(EntitySentryPigman.class, "SentryPigman", 102, 15373203, 0XD0A750);
		EntityRegistry.registerModEntity(EntityToyBall.class, "ToyBall", 103, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityToyTetheredLog.class, "ToyTetheredLog", 104, Revival.INSTANCE, 80, 3, true);
		EntityRegistry.registerModEntity(EntityToyScratchingPost.class, "ToyScratchingPost", 105, Revival.INSTANCE, 80, 3, true);
		for (int i = 0; i < EnumPrehistoric.values().length; i++) {
			if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN && EnumPrehistoric.values()[i].type != EnumMobType.VANILLA)
				registerSpawnable(EnumPrehistoric.values()[i].getDinoClass(), EnumPrehistoric.values()[i].name(), 200 + i, EnumPrehistoric.values()[i].mainSpawnColor, EnumPrehistoric.values()[i].secondSpawnColor);
		}

		BiomeGenBase[] swamps = BiomeDictionary.getBiomesForType(Type.SWAMP); 
		BiomeGenBase[] rivers = BiomeDictionary.getBiomesForType(Type.RIVER); 
		BiomeGenBase[] oceans = BiomeDictionary.getBiomesForType(Type.OCEAN); 
		SpawnListEntry sturgeon = new SpawnListEntry(EntitySturgeon.class, 20, 1, 1); 
		SpawnListEntry alligatorgar = new SpawnListEntry(EntityAlligatorGar.class, 10, 1, 1); 
		SpawnListEntry coelacanth = new SpawnListEntry(EntityCoelacanth.class, 5, 1, 1); 
		SpawnListEntry nautilus = new SpawnListEntry(EntityNautilus.class, 4, 1, 1); 
		if(Revival.CONFIG.spawnSturgeon){
			for(int i = 0; i < rivers.length; i++) {
				rivers[i].getSpawnableList(EnumCreatureType.waterCreature).add(sturgeon);
			}
		}
		if(Revival.CONFIG.spawnAlligatorGar){
			for(int i = 0; i < swamps.length; i++) {
				swamps[i].getSpawnableList(EnumCreatureType.waterCreature).add(alligatorgar);
			}
		}
		if(Revival.CONFIG.spawnCoelacanth){
			for(int i = 0; i < oceans.length; i++) {
				oceans[i].getSpawnableList(EnumCreatureType.waterCreature).add(coelacanth);
			}
		}
		if(Revival.CONFIG.spawnNautilus){
			for(int i = 0; i < oceans.length; i++) {
				oceans[i].getSpawnableList(EnumCreatureType.waterCreature).add(nautilus);
			}
		}
	}

	public static void registerSpawnable(Class entityClass, String name, int entityId, int mainColor, int subColor) {
		EntityRegistry.registerModEntity(entityClass, name, entityId, Revival.INSTANCE, 80, 3, true);
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entityClass);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, mainColor, subColor));
	}

	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}
}
