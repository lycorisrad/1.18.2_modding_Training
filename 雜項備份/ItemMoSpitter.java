package com.hiro.hiromod.items;

import com.hiro.hiromod.Main;
import com.hiro.hiromod.entity.EntityMoSpitter;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class ItemMoSpitter extends Item{
    public ItemMoSpitter(Item.Properties name) {
        super(name);
    }

    public ItemMoSpitter() {

        super(new Properties().tab(Main.HIRO_TAB).stacksTo(64));
    }

    public EntityMoSpitter createArrow(Level level, ItemStack stack, LivingEntity entityIn) {

        EntityMoSpitter arrowentity = new EntityMoSpitter(level, entityIn);
        return arrowentity;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemMoSpitter.class;
    }

}

