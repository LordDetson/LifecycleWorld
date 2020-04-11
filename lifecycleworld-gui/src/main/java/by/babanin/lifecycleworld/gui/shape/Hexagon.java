package by.babanin.lifecycleworld.gui.shape;

import by.babanin.lifecycleworld.gui.util.GUIUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hexagon extends Point{
    public static final BufferedImage IMAGE = GUIUtils.loadBufferedImage("hexagon.png");
    public static final Dimension SIZE = new Dimension(IMAGE.getWidth(), IMAGE.getHeight());

    public Hexagon(Point p) {
        super(p);
    }

    public Hexagon(int x, int y) {
        super(x, y);
    }
}
