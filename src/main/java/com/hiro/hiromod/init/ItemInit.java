package com.hiro.hiromod.init;

import com.google.common.base.Supplier;
import com.hiro.hiromod.Main;

import com.hiro.hiromod.items.ItemM1897B;
import com.hiro.hiromod.items.ItemPreAttack;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Main.MOD_ID);

    public static RegistryObject<Item> M1897B = ITEMS.register("m1897b",()->
    {
        return  new ItemM1897B();
    });

    public static final RegistryObject<Item> EXAMPLE_ITEM =register("example_item",
            () -> new Item(new Item.Properties().tab(Main.HIRO_TAB)));

    public static RegistryObject<Item> PREATTACK = register("preciseattack",()->{
        return new ItemPreAttack();
    });
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
        return  ITEMS.register(name , item);
    }

}
