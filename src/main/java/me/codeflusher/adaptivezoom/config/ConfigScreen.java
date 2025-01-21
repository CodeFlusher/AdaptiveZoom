package me.codeflusher.adaptivezoom.config;

import me.codeflusher.adaptivezoom.data.ToggledData;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiCheckBox;

public class ConfigScreen extends GuiScreen {

    private final GuiScreen parent;

    public ConfigScreen(GuiScreen parent) {
        this.parent = parent;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiCheckBox(0, this.width / 2 - 100, this.height / 6 + 24, "Use linear with factor 2", ModConfig.useLinear2));
        this.buttonList.add(new GuiCheckBox(1, this.width / 2 - 100, this.height / 6 + 24*2, "Use linear with factor 3", ModConfig.useLinear3));
        this.buttonList.add(new GuiCheckBox(2, this.width / 2 - 100, this.height / 6 + 24*3, "Use linear with factor 4", ModConfig.useLinear4));
        this.buttonList.add(new GuiCheckBox(3, this.width / 2 - 100, this.height / 6 + 24*4, "Use exponential with base 2", ModConfig.useExponent2));
        this.buttonList.add(new GuiCheckBox(4, this.width / 2 - 100, this.height / 6 + 24*5, "Use exponential with base 3", ModConfig.useExponent3));
        this.buttonList.add(new GuiCheckBox(5, this.width / 2 - 100, this.height / 6 + 24*6, "Use exponential with base 4", ModConfig.useExponent4));
        this.buttonList.add(new GuiCheckBox(6, this.width / 2 - 100, this.height / 6 + 24*7, "Use cinematic camera in zoom", ModConfig.useCinematic));
        this.buttonList.add(new GuiButton(7, this.width / 2 - 100, this.height / 6 + 24*8, "Go back"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                ModConfig.useLinear2 = !ModConfig.useLinear2;
                break;
            case 1:
                ModConfig.useLinear3 = !ModConfig.useLinear3;
                break;
            case 2:
                ModConfig.useLinear4 = !ModConfig.useLinear4;
                break;
            case 3:
                ModConfig.useExponent2 = !ModConfig.useExponent2;
                break;
            case 4:
                ModConfig.useExponent3 = !ModConfig.useExponent3;
                break;
            case 5:
                ModConfig.useExponent4 = !ModConfig.useExponent4;
                break;
            case 6:
                ModConfig.useCinematic = !ModConfig.useCinematic;
                break;
            default:
                this.mc.displayGuiScreen(this.parent);
                break;
        }
        ModConfig.save();
        ToggledData.reload();

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "Configuration GUI", this.width / 2, this.height / 6 - 12, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
