package by.babanin.lifecycleworld.gui.frame;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.panel.MapPanel;
import by.babanin.lifecycleworld.gui.panel.StatusPanel;
import by.babanin.lifecycleworld.gui.panel.ToolPanel;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Initializer {
    private static final int FRAME_WIDTH = 1430;
    private static final int FRAME_HEIGHT = 760;

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
        SwingUtils.doCenterScreen(this);
    }

    private void initComponents() {
        ToolPanel toolPanel = new ToolPanel();
        MapPanel mapPanel = new MapPanel();
        StatusPanel statusPanel = new StatusPanel();
        toolPanel.initialize();
        mapPanel.initialize();
        statusPanel.initialize();
        add(toolPanel, BorderLayout.NORTH);
        add(mapPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

}
