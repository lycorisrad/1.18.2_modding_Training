package com.hiro.hiromod.items;

import com.hiro.hiromod.Main;
import com.hiro.hiromod.entity.EntityM1897B;
import com.hiro.hiromod.init.ItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemM1897B extends Item {
    //篶硑よ猭(ㄧ计)
    public ItemM1897B(Item.Properties name){
        //膥┯Item 局Τ把计(Item.Properties name)篶硑よ猭(ㄧ计)
        super(name);
    }
    public ItemM1897B(){
        super(new Properties().tab(Main.HIRO_TAB).stacksTo(64));
    }
    public EntityM1897B createArrow(Level level, ItemStack stack, LivingEntity entityIn){
        EntityM1897B arrowentity = new EntityM1897B(level, entityIn);
        return arrowentity;
    }
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemM1897B.class;
    }

}
