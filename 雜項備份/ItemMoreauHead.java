package com.hiro.hiromod.items;

import com.hiro.hiromod.Main;

import com.hiro.hiromod.init.ItemInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ItemMoreauHead extends ProjectileWeaponItem implements Vanishable {
    public ItemMoreauHead(){
        super(new Item.Properties().tab(Main.HIRO_TAB).stacksTo(1));

    }
    public ItemMoreauHead(Item.Properties name){
        super(name);
    }
    /*
    public void releaseUsing(ItemStack p_77615_1_, Level level, LivingEntity p_77615_3_,int p_77615_4_){
        if(p_77615_3_ instanceof Player){
            Player Player =(Player)p_77615_3_;
            boolean flag = Player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS,p_77615_1_) > 0;

            Player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,200,1,true,true));

            ItemStack itemstack = this.findAmmo(Player);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_,level ,Player,i,!itemstack.isEmpty() || flag);
            if(i<0) return;
            if(!itemstack.isEmpty() || flag){
                if(itemstack.isEmpty()){
                    itemstack = new ItemStack(ItemInit.MOSPITTER.get().asItem());
                }
                float f = getPowerForTime(i);
                if(!((double)f <0.1D)){
                    boolean flag1 =Player.getAbilities().instabuild || (itemstack.getItem() instanceof ItemMoSpitter && ((ItemMoSpitter)itemstack.getItem()).isInfinite(itemstack,p_77615_1_,Player));
                    if(!level.isClientSide){
                        ItemMoSpitter arrowitem =(ItemMoSpitter) (itemstack.getItem() instanceof ItemMoSpitter ? itemstack.getItem() : ItemInit.MOSPITTER.get().asItem());

                        EntityMoSpitter abstractarrowentity =arrowitem.createArrow(level,itemstack,Player);
                        abstractarrowentity = customArrow(abstractarrowentity);

                        abstractarrowentity.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0.2F,f * 30.0F,0.75F);

                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE,abstractarrowentity.getX(),abstractarrowentity.getY(),abstractarrowentity.getZ(),abstractarrowentity.position().x,abstractarrowentity.position().y,abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundEvents.ARROW_SHOOT,2.5F,2.5F);

                        if(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS,p_77615_1_)>0){
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1,Player,(p_220009_1_) ->{
                            p_220009_1_.broadcastBreakEvent(Player.getUsedItemHand());
                        });

                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE_POP, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.08D, abstractarrowentity.position().z * -0.2D);

                        level.addFreshEntity(abstractarrowentity);
                        Player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60,1,true,true));

                    }

                    level.playSound((Player)null, Player.getX(), Player.getY(), Player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.4F, 1.4F / (Player.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !Player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            Player.getInventory().removeItem(itemstack);
                        }
                    }

                    Player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
*/
    /*
    public InteractionResultHolder<ItemStack> use(Level level, Player palyerIn, InteractionHand handIn) {
        ItemStack itemstack = palyerIn.getItemInHand(handIn);
        boolean flag = !this.findAmmo(palyerIn).isEmpty();
//        boolean flag;
//        if (!(itemstack.getItem() instanceof ShootableItem)) {
//            flag=false;
//        }


        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, palyerIn, handIn, flag);
        if (ret != null) return ret;

        if (!palyerIn.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            palyerIn.startUsingItem(handIn);
            return InteractionResultHolder.consume(itemstack);
        }
    }
*/
    public static float getPowerForTime(int p_185059_0_) {
        float f = (float)p_185059_0_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }



    public int getUseDuration(ItemStack p_77626_1_) {
        return 600;
    }


    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }
/*
    public  EntityMoSpitter customArrow(EntityMoSpitter arrow) {
        return arrow;
    }
    */
    public int getDefaultProjectileRange() {
        return 11;
    }

    /*
    protected ItemStack findAmmo(Player player)
    {
        if (this.isMoSpitter(player.getItemInHand(InteractionHand.OFF_HAND)))
        {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        }
        else if (this.isMoSpitter(player.getItemInHand(InteractionHand.MAIN_HAND)))
        {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i)
            {
                ItemStack itemstack = player.getInventory().getItem(i);

                if (this.isMoSpitter(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
    */

    /*
    protected boolean isMoSpitter(ItemStack stack)
    {
        return stack.getItem() instanceof ItemMoSpitter;
    }
    */

}

