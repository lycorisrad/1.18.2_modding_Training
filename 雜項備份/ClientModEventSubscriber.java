package com.hiro.hiromod;

import com.hiro.hiromod.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber
{
   @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
    /*
       event.registerEntityRenderer(EntityInit.MOSPITTER.get(), RenderMoSpitter::new);
   */
   }


}
