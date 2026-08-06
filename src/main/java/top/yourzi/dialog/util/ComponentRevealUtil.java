package top.yourzi.dialog.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public final class ComponentRevealUtil {

    private ComponentRevealUtil() {}

    public static Component reveal(Component original, int visibleCharacters) {

        MutableComponent result = Component.empty();

        if (visibleCharacters <= 0) {
            return result;
        }

        AtomicInteger remaining = new AtomicInteger(visibleCharacters);

        original.visit((Style style, String text) -> {

            if (remaining.get() <= 0) {
                return Optional.of(Boolean.TRUE);
            }

            if (text.isEmpty()) {
                return Optional.empty();
            }

            int length = Math.min(text.length(), remaining.get());

            result.append(
                    Component.literal(text.substring(0, length))
                            .setStyle(style)
            );

            remaining.addAndGet(-length);

            return remaining.get() <= 0
                    ? Optional.of(Boolean.TRUE)
                    : Optional.empty();

        }, Style.EMPTY);

        return result;
    }
}