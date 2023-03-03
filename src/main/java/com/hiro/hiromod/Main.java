package com.hiro.hiromod;

import com.hiro.hiromod.init.BlockInit;
import com.hiro.hiromod.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hiromod")
public class Main {
    public static final String MOD_ID ="hiromod";
    public static final CreativeModeTab HIRO_TAB =new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)

        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.EXAMPLE_BLOCK.get());
        }
    };
    public Main(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static void setup(){
        IEventBus bus =MinecraftForge.EVENT_BUS;
    }
}
