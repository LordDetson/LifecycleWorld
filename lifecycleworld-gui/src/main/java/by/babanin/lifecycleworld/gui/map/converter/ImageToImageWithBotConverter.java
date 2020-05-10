package by.babanin.lifecycleworld.gui.map.converter;

import by.babanin.lifecycleworld.core.bot.BotFoodType;
import by.babanin.lifecycleworld.gui.map.hexagon.Hexagon;
import by.babanin.lifecycleworld.gui.util.GUIUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageToImageWithBotConverter {
    private static final Map<BotFoodType, Color> COLOR_BOT_FOOD_TYPE_MAP = new HashMap<>();

    static {
        COLOR_BOT_FOOD_TYPE_MAP.put(BotFoodType.HERBIVOROUS, Color.green);
        COLOR_BOT_FOOD_TYPE_MAP.put(BotFoodType.CARNIVORE, Color.red);
        COLOR_BOT_FOOD_TYPE_MAP.put(BotFoodType.OMNIVOROUS, Color.blue);
    }

    public static BufferedImage convert(BufferedImage image, BotFoodType botFoodType) {
        return drawCircle(GUIUtils.imageDeepClone(image), COLOR_BOT_FOOD_TYPE_MAP.get(botFoodType));
    }

    private static BufferedImage drawCircle(BufferedImage image, Color color) {
        Graphics2D imageGraphics = image.createGraphics();
        imageGraphics.setColor(color);
        imageGraphics.fillOval(calcX(), calcY(), calcWidth(), calcHeight());
        imageGraphics.dispose();
        return image;
    }

    private static int calcX() {
        return Hexagon.SIZE.width /4;
    }

    private static int calcY() {
        return Hexagon.SIZE.height / 4;
    }

    private static int calcWidth() {
        return Hexagon.SIZE.width / 2;
    }

    private static int calcHeight() {
        return Hexagon.SIZE.width / 2;
    }
}
