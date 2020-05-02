package by.babanin.lifecycleworld.gui.map.hexagon;

import by.babanin.lifecycleworld.gui.config.GUIProperties;
import by.babanin.lifecycleworld.gui.util.GUIUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Hexagon {
    public static final Dimension SIZE = new Dimension(27, 23);

    public final BufferedImage image;
    public final Point position;

    public Hexagon(Point position) {
        this(HexagonType.DEFAULT, position);
    }

    public Hexagon(HexagonType type, Point position) {
        image = HexagonImageMap.get(type);
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

        static {
            imageMap.put(HexagonType.DEFAULT, load(HexagonType.GRASS));
            imageMap.put(HexagonType.COAST, load(HexagonType.COAST));
            imageMap.put(HexagonType.GRASS, load(HexagonType.GRASS));
            imageMap.put(HexagonType.HILL, load(HexagonType.HILL));
            imageMap.put(HexagonType.OCEAN, load(HexagonType.OCEAN));
            imageMap.put(HexagonType.SANDS, load(HexagonType.SANDS));
        }

        private static BufferedImage load(HexagonType type) {
            return GUIUtils.loadBufferedImage(PATH + type.name().toLowerCase() + EXTENSION, SIZE);
        }

        private static BufferedImage get(HexagonType type) {
            return imageMap.get(type);
        }
    }
}
