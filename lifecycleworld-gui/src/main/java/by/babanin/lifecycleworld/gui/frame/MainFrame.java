package by.babanin.lifecycleworld.gui.frame;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.map.model.MapModel;
import by.babanin.lifecycleworld.gui.map.panel.MapPanel;
import by.babanin.lifecycleworld.gui.panel.StatusPanel;
import by.babanin.lifecycleworld.gui.panel.ToolPanel;
import by.babanin.lifecycleworld.gui.util.GUIUtils;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Initializer {
    private static final int FRAME_WIDTH = 1430;
    private static final int FRAME_HEIGHT = 760;
    private MapPanel mapPanel;

    @Override
    public void initialize() {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        initComponents();
        setTitle(GUIResources.TITLE_MAIN_FRAME.getValue());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        GUIUtils.doCenterScreen(this);
    }

    private void initComponents() {
        initMapPanel();
        ToolPanel toolPanel = new ToolPanel();
        StatusPanel statusPanel = new StatusPanel();
        toolPanel.initialize();
        statusPanel.initialize();
        add(toolPanel, BorderLayout.NORTH);
        add(mapPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void initMapPanel() {
        MapModel mapModel = new MapModel(10, 10);
        mapPanel = new MapPanel(mapModel);
        mapPanel.initialize();
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }
}
