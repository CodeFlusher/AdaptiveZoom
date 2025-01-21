package me.codeflusher.adaptivezoom.mixin;

import me.codeflusher.adaptivezoom.data.ScrollData;
import me.codeflusher.adaptivezoom.data.ToggledData;
import me.codeflusher.adaptivezoom.settings.ModKeyBinds;
import me.codeflusher.adaptivezoom.utils.Utils;
import net.minecraft.util.MouseHelper;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHelper.class)
public class MixinMouseHelper {

    @Shadow public int deltaX;

    @Shadow public int deltaY;



    @Inject(method = "mouseXYChange", at=@At("TAIL"))
    public void mouseXYChange(CallbackInfo ci) {
        if (ModKeyBinds.zoom.isKeyDown()){
            this.deltaX = Utils.computeDelta(this.deltaX);
            this.deltaY = Utils.computeDelta(this.deltaY);
        }
    }

}
