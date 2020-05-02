package by.babanin.lifecycleworld.gui.action;

import by.babanin.lifecycleworld.gui.map.panel.MapPanel;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ResizeMapAction implements MouseWheelListener {
    private static final int COEFFICIENT = 15;
    private final Dimension interval;

    public ResizeMapAction(Dimension size) {
        this(size.width, size.height);
    }

    public ResizeMapAction(int width, int height) {
        interval = new Dimension(width / COEFFICIENT, height / COEFFICIENT);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MapPanel mapPanel = (MapPanel) e.getSource();
        Dimension size = mapPanel.getMapSize();
        size.width = size.width + e.getWheelRotation() * interval.width;
        size.height = size.height + e.getWheelRotation() * interval.height;
        mapPanel.updateMapSize(size);
    }
}
