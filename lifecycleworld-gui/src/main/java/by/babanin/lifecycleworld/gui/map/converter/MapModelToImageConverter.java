package by.babanin.lifecycleworld.gui.map.converter;

import by.babanin.lifecycleworld.gui.map.hexagon.Hexagon;
import by.babanin.lifecycleworld.gui.map.model.MapModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class MapModelToImageConverter {
    public static BufferedImage convert(MapModel mapModel, Color backgroundColor, ImageObserver observer) {
        BufferedImage image = new BufferedImage(calcWidth(mapModel), calcHeight(mapModel), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        for (int i = 0; i < mapModel.getRows(); i++) {
            for (int j = 0; j < mapModel.getColumns(); j++) {
                Hexagon hexagon = mapModel.get(i, j);
                g.drawImage(hexagon.image, (int) hexagon.getX(), (int) hexagon.getY(), observer);
            }
        }
        return image;
    }

    private static int calcHeight(MapModel mapModel) {
        int rows = mapModel.getRows();
        return rows * Hexagon.SIZE.height + Hexagon.SIZE.height / 2;
    }

    private static int calcWidth(MapModel mapModel) {
        return (int) ((mapModel.getColumns() * (Hexagon.SIZE.width * 0.75)) + (Hexagon.SIZE.width * 0.25));
    }
}
