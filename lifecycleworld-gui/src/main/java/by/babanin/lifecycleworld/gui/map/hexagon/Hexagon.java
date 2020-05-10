package by.babanin.lifecycleworld.gui.map.hexagon;

import by.babanin.lifecycleworld.core.bot.BotFoodType;
import by.babanin.lifecycleworld.gui.config.GUIProperties;
import by.babanin.lifecycleworld.gui.map.converter.ImageToImageWithBotConverter;
import by.babanin.lifecycleworld.gui.util.GUIUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Hexagon {
    public static final Dimension SIZE = new Dimension(27, 23);

    public final BufferedImage image;
    public final Point position;

    public Hexagon(HexagonType type, Point position) {
        image = HexagonImageMap.get(type);
        this.position = position;
    }

    public Hexagon(HexagonType type, BotFoodType botFoodType, Point position) {
        image = HexagonImageMap.getWithBot(type, botFoodType);
        this.position = position;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    private static class HexagonImageMap {
        private static final String EXTENSION = ".png";
        private static final String PATH = System.getProperty(GUIProperties.HEXAGON_IMAGES_PATH);
        private static final Map<HexagonType, BufferedImage> imageMap = new HashMap<>();
        private static final Map<HexagonType, Map<BotFoodType, BufferedImage>> imageMapWithBot = new HashMap<>();

        static {
            for (HexagonType hexagonType : HexagonType.values()) {
                imageMap.put(hexagonType, load(hexagonType));
                imageMapWithBot.put(hexagonType, convert(hexagonType));
            }
        }

        private static BufferedImage load(HexagonType type) {
            return GUIUtils.loadBufferedImage(PATH + type.name().toLowerCase() + EXTENSION, SIZE);
        }

        private static BufferedImage get(HexagonType type) {
            return imageMap.get(type);
        }

        private static BufferedImage getWithBot(HexagonType type, BotFoodType botFoodType) {
            return imageMapWithBot.get(type).get(botFoodType);
        }

        private static Map<BotFoodType, BufferedImage> convert(HexagonType type) {
            Map<BotFoodType, BufferedImage> imageMapByBotFoodType = new HashMap<>();
            for (BotFoodType botFoodType : BotFoodType.values()) {
                imageMapByBotFoodType.put(botFoodType, ImageToImageWithBotConverter.convert(get(type), botFoodType));
            }
            return imageMapByBotFoodType;
        }
    }
}
