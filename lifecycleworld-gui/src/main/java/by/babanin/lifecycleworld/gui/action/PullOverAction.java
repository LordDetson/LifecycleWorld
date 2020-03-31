package by.babanin.lifecycleworld.gui.action;

import by.babanin.lifecycleworld.gui.panel.MapPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PullOverAction extends MouseAdapter implements MouseMotionListener {
    private static final PullOverAction INSTANCE = new PullOverAction();
    private Point startMousePosition;
    private Point startMapPosition;

    private PullOverAction() {}

    public static PullOverAction getInstance() {
        return INSTANCE;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MapPanel map = (MapPanel) e.getSource();
        startMapPosition = new Point(map.getPoint());
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
