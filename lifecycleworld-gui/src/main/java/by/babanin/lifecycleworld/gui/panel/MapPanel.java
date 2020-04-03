package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.action.DragMapAction;
import by.babanin.lifecycleworld.gui.action.ResizeMapAction;
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
        addMouseWheelListener(new ResizeMapAction(mapSize));
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

    public void fillFullArea() {
        Dimension panelSize = getSize();
        double areaCoefficient = panelSize.height / (panelSize.width * 1.0);
        double mapCoefficient = mapSize.height / (mapSize.width * 1.0);
        if (areaCoefficient > mapCoefficient) {
            mapSize.width = panelSize.width;
            mapSize.height = (int) (panelSize.width * mapCoefficient);
        } else {
            mapSize.width = (int) (panelSize.height / mapCoefficient);
            mapSize.height = panelSize.height;
        }
    }

    public void doCenterArea() {
        Dimension panelSize = getSize();
        if (mapSize.height < panelSize.height) {
            int interval = (panelSize.height - mapSize.height) / 2;
            getPosition().y += interval;
        } else {
            int interval = (panelSize.width - mapSize.width) / 2;
            getPosition().x += interval;
        }
    }

    public void repaintFullCenterArea() {
        fillFullArea();
        doCenterArea();
        repaint();
    }
}
