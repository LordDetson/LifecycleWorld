package by.babanin.lifecycleworld.gui.map.panel;

import by.babanin.lifecycleworld.gui.action.DragMapAction;
import by.babanin.lifecycleworld.gui.action.ResizeMapAction;
import by.babanin.lifecycleworld.gui.map.model.MapModel;
import by.babanin.lifecycleworld.gui.map.hexagon.Hexagon;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapPanel extends JPanel implements Initializer {
    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private final transient MapModel mapModel;
    private Point position = new Point(0, 0);
    private Dimension mapSize;
    private transient BufferedImage mapImage;

    public MapPanel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    @Override
    public void initialize() {
        mapImage = createMapImage();
        mapSize = new Dimension(mapImage.getWidth(), mapImage.getHeight());
        addMouseListener(DragMapAction.getInstance());
        addMouseMotionListener(DragMapAction.getInstance());
        addMouseWheelListener(new ResizeMapAction(mapSize));
        setBackground(BACKGROUND_COLOR);
    }

    private BufferedImage createMapImage() {
        BufferedImage image = new BufferedImage(calcWidth(), calcHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        for (int i = 0; i < mapModel.getRows(); i++) {
            for (int j = 0; j < mapModel.getColumnsByRow(i); j++) {
                Hexagon hexagon = mapModel.get(i, j);
                g.drawImage(hexagon.image, (int) hexagon.getX(), (int) hexagon.getY(), this);
            }
        }
        return image;
    }

    private int calcHeight() {
        int rows = mapModel.getRows();
        int height = (int) (Math.ceil(rows / 2.) * Hexagon.SIZE.height);
        return rows % 2 == 0 ? height + Hexagon.SIZE.height / 2 : height;
    }

    private int calcWidth() {
        return (mapModel.getMaxColumns() * (Hexagon.SIZE.width + Hexagon.SIZE.width / 2)) - Hexagon.SIZE.width / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapImage, (int) position.getX(), (int) position.getY(), mapSize.width, mapSize.height, this);
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
