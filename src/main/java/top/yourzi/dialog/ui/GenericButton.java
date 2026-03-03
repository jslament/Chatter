package top.yourzi.dialog.ui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.network.chat.Component;

public class GenericButton extends ImageButton {

    public GenericButton(
            int x,
            int y,
            int width,
            int height,
            WidgetSprites sprites,
            OnPress onPress,
            Component message
    ) {
        super(x, y, width, height, sprites, onPress, message);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
    }
}