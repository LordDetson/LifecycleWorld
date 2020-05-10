package by.babanin.lifecycleworld.gui.map.panel;

import by.babanin.lifecycleworld.gui.map.action.DragMapAction;
import by.babanin.lifecycleworld.gui.map.action.MapZoomer;
import by.babanin.lifecycleworld.gui.map.converter.MapModelToImageConverter;
import by.babanin.lifecycleworld.gui.map.model.MapModel;
import by.babanin.lifecycleworld.gui.map.model.MapSize;
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
        initComponents();
        initActions();
    }

    private void initComponents() {
        mapImage = MapModelToImageConverter.convert(mapModel, BACKGROUND_COLOR, this);
        mapSize = new Dimension(mapImage.getWidth(), mapImage.getHeight());
        setBackground(BACKGROUND_COLOR);
    }

    private void initActions() {
        addMouseListener(DragMapAction.getInstance());
        addMouseMotionListener(DragMapAction.getInstance());
        addMouseWheelListener(MapZoomer.getInstance());
    }

    private void updateMap() {
        initComponents();
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

    public void updateMapModelSize(MapSize mapSize) {
        mapModel.setMapSize(mapSize);
        updateMap();
        repaintFullCenterArea();
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
        getPosition().y = (panelSize.height - mapSize.height) / 2;
        getPosition().x = (panelSize.width - mapSize.width) / 2;
    }

    public void repaintFullCenterArea() {
        fillFullArea();
        doCenterArea();
        repaint();
    }
}
