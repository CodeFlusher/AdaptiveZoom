package me.codeflusher.adaptivezoom.mixin;

import javafx.scene.input.ZoomEvent;
import me.codeflusher.adaptivezoom.data.ScrollData;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityViewRenderEvent.FOVModifier.class, remap = false)
public abstract class MixinFOVModifier extends EntityViewRenderEvent {

    @Shadow
    private float fov;

    public MixinFOVModifier(EntityRenderer renderer, Entity entity, Block block, double renderPartialTicks) {
        super(renderer, entity, block, renderPartialTicks);
    }

    @Inject(at = @At("HEAD"), method = "getFOV", cancellable = true)
    public void injectFovModification(CallbackInfoReturnable<Float> cir) {
        if (ModKeyBinds.zoom.isKeyDown()) {
            Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            cir.setReturnValue(fov / (1 + ScrollData.getScroll()));
        }else{
            Minecraft.getMinecraft().gameSettings.smoothCamera = false;
        }
    }
}
