package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.action.PullOverAction;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.GUIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapPanel extends JPanel implements Initializer {

    private final Point point = new Point(10, 40);
    private transient BufferedImage image;

    @Override
    public void initialize() {
        image = GUIUtils.loadBufferedImage("image.jpg");
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        addMouseListener(PullOverAction.getInstance());
        addMouseMotionListener(PullOverAction.getInstance());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (int) point.getX(), (int) point.getY(), this);
    }

    public void updateMapPosition(Point updated) {
        setPoint(updated);
        repaint();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point.x = point.x;
        this.point.y = point.y;
    }
}
