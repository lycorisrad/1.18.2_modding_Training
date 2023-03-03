package com.hiro.hiromod.init;

import com.hiro.hiromod.Main;
import com.hiro.hiromod.entity.EntityM1897B;

import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Main.MOD_ID);

    public static final RegistryObject<EntityType<EntityM1897B>> M1897B =
            ENTITY_TYPES.register("m1897b", () -> EntityType.Builder.<EntityM1897B>of
                    (EntityM1897B::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("m1897"));

}