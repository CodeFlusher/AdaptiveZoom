package me.codeflusher.adaptivezoom.mixin;

import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryPlayer.class)
public class MixinInventoryPlayer {
    @Inject(method = "changeCurrentItem", at = @At("HEAD"), cancellable = true)
    public void changeCurrentItem(int direction, CallbackInfo ci) {
        if (ModKeyBinds.zoom.isKeyDown()) {
            ci.cancel();
        }
    }
}
