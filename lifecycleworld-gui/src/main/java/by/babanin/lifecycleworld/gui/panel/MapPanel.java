package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.action.DragMapAction;
import by.babanin.lifecycleworld.gui.action.MouseWheelEventDemo;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.GUIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapPanel extends JPanel implements Initializer {

    private Point position = new Point(0, 0);
    private Dimension mapSize;
    private transient BufferedImage image;

    @Override
    public void initialize() {
        image = GUIUtils.loadBufferedImage("image.jpg");
        mapSize = new Dimension(image.getWidth(), image.getHeight());
        addMouseListener(DragMapAction.getInstance());
        addMouseMotionListener(DragMapAction.getInstance());
        addMouseWheelListener(new MouseWheelEventDemo(mapSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (int) position.getX(), (int) position.getY(), mapSize.width, mapSize.height, this);
    }

    public void updateMapPosition(Point newPosition) {
        setPosition(newPosition);
        repaint();
    }

    public void updateMapSize(Dimension newSize) {
        setMapSize(newSize);
        repaint();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getMapSize() {
        return mapSize;
    }

    public void setMapSize(Dimension mapSize) {
        this.mapSize = mapSize;
    }
}
