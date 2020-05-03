package by.babanin.lifecycleworld.gui.map.action;

import by.babanin.lifecycleworld.gui.map.panel.MapPanel;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

public class MapZoomer implements MouseWheelListener {
    private static final int MIN_ZOOM = 1;
    private static final int MAX_ZOOM = 15;
    private static final float STEP = 0.5f;
    private static final List<Float> zooms = new ArrayList<>();
    static {
        for (float i = MIN_ZOOM; i <= MAX_ZOOM; i += STEP) {
            zooms.add(i);
        }
    }

    private static final MapZoomer INSTANCE = new MapZoomer();

    private int currentIndexSize = 0;
    private final List<Dimension> sizes = new ArrayList<>();
    private boolean isFirst = true;

    private MapZoomer() {}

    public static MapZoomer getInstance() {
        return INSTANCE;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MapPanel mapPanel = (MapPanel) e.getSource();
        if (isFirst) {
            isFirst = false;
            Dimension originalSize = mapPanel.getMapSize();
            zooms.forEach(zoom ->
                    sizes.add(new Dimension((int) (originalSize.width * zoom), (int) (originalSize.height * zoom))));
        }
        mapPanel.updateMapSize(e.getWheelRotation() > 0 ? previous() : next());
    }

    private Dimension next() {
        if (currentIndexSize + 1 < sizes.size()) {
            currentIndexSize++;
        }
        return sizes.get(currentIndexSize);
    }

    private Dimension previous() {
        if (currentIndexSize > 0) {
            currentIndexSize--;
        }
        return sizes.get(currentIndexSize);
    }

}
