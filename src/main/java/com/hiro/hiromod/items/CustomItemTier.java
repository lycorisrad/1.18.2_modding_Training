package com.hiro.hiromod.items;

import com.google.common.base.Supplier;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum CustomItemTier implements Tier {
    exampleToolTier(10,120,8.0F,10.0F,100,() ->{
        return Ingredient.of(Items.DIAMOND);
    }),
    PreciseAttack(3,2,8.0F,10.0F,100,()->{
        return Ingredient.of(Items.DIAMOND);
    });
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchatmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private CustomItemTier(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_){
        this.level = p_43332_;
        this.uses = p_43333_;
        this.speed = p_43334_;
        this.damage = p_43335_;
        this.enchatmentValue = p_43336_;
        this.repairIngredient =new LazyLoadedValue<>(p_43337_);
    }
    public int getUses(){
        return  this.uses;
    }
    public float getSpeed(){
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }


    public int getLevel(){
        return  this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    public Ingredient getRepairIngredient(){
        return this.repairIngredient.get();
    }
}
