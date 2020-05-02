package by.babanin.lifecycleworld.gui.action;

import by.babanin.lifecycleworld.gui.map.panel.MapPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DragMapAction extends MouseAdapter implements MouseMotionListener {
    private static final DragMapAction INSTANCE = new DragMapAction();
    private Point startMousePosition;
    private Point startMapPosition;

    private DragMapAction() {}

    public static DragMapAction getInstance() {
        return INSTANCE;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MapPanel map = (MapPanel) e.getSource();
        startMapPosition = map.getPosition();
        startMousePosition = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MapPanel map = (MapPanel) e.getSource();
        Point currentMousePosition = e.getPoint();
        Point movedMapPosition = new Point(
                startMapPosition.x + (currentMousePosition.x - startMousePosition.x),
                startMapPosition.y + (currentMousePosition.y - startMousePosition.y)
        );
        map.updateMapPosition(movedMapPosition);
    }
}
