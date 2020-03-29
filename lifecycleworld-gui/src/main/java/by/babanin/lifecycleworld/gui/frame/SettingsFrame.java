package by.babanin.lifecycleworld.gui.frame;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.panel.DefaultMapSizePanel;
import by.babanin.lifecycleworld.gui.panel.DefaultStepPanel;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame implements Initializer {

    @Override
    public void initialize() {
        setLayout(new GridBagLayout());
        initComponents();
        setTitle(GUIResources.TITLE_SETTINGS_FRAME.getValue());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        DefaultMapSizePanel mapSizePanel = new DefaultMapSizePanel();
        mapSizePanel.initialize();
        DefaultStepPanel stepPanel = new DefaultStepPanel();
        stepPanel.initialize();

        GridBagConstraints mapSizePanelConstraints = new GridBagConstraints();
        GridBagConstraints stepPanelConstraints = new GridBagConstraints();
        mapSizePanelConstraints.gridx = 0;
        mapSizePanelConstraints.gridy = 0;
        mapSizePanelConstraints.insets = new Insets(10, 10, 10, 5);
        stepPanelConstraints.gridx = 1;
        stepPanelConstraints.gridy = 0;
        stepPanelConstraints.insets = new Insets(10, 5, 10, 10);

        add(mapSizePanel, mapSizePanelConstraints);
        add(stepPanel, stepPanelConstraints);
    }
}
