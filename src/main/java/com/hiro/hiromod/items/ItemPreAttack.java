package com.hiro.hiromod.items;

import com.hiro.hiromod.Main;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class ItemPreAttack extends SwordItem {
    public ItemPreAttack(){
        super(CustomItemTier.PreciseAttack,1000000001,-2,new Item.Properties().tab(Main.HIRO_TAB));
    }
}
