package by.babanin.lifecycleworld.gui.dialog;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.map.panel.MapPanel;
import by.babanin.lifecycleworld.gui.map.panel.MapSizePanel;
import by.babanin.lifecycleworld.gui.panel.DefaultStepPanel;
import by.babanin.lifecycleworld.gui.panel.OkCancelButtonsPanel;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog implements Initializer {

    private final MapPanel mapPanel;

    private MapSizePanel mapSizePanel;
    private DefaultStepPanel stepPanel;
    private OkCancelButtonsPanel buttonsPanel;

    public SettingsDialog(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    @Override
    public void initialize() {
        setLayout(new GridBagLayout());
        initComponents();
        initActions();
        composeComponents();
        setTitle(GUIResources.TITLE_SETTINGS_FRAME.getValue());
        setModal(true);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        mapSizePanel = new MapSizePanel();
        mapSizePanel.initialize();
        stepPanel = new DefaultStepPanel();
        stepPanel.initialize();
        buttonsPanel = new OkCancelButtonsPanel(this);
        buttonsPanel.initialize();
    }

    private void initActions() {
        buttonsPanel.addOkAction(e -> {
            mapPanel.updateMapModelSize(mapSizePanel.getMapSize());
            dispose();
        });
    }

    private void composeComponents() {
        GridBagConstraints mapSizePanelConstraints = new GridBagConstraints();
        GridBagConstraints stepPanelConstraints = new GridBagConstraints();
        GridBagConstraints buttonsPanelConstraints = new GridBagConstraints();
        mapSizePanelConstraints.gridx = 0;
        mapSizePanelConstraints.gridy = 0;
        mapSizePanelConstraints.insets = new Insets(10, 10, 10, 5);
        stepPanelConstraints.gridx = 1;
        stepPanelConstraints.gridy = 0;
        stepPanelConstraints.insets = new Insets(10, 5, 10, 10);
        buttonsPanelConstraints.gridx = 1;
        buttonsPanelConstraints.gridy = 1;
        buttonsPanelConstraints.insets = new Insets(0, 0, 5, 10);
        buttonsPanelConstraints.anchor = GridBagConstraints.EAST;

        add(mapSizePanel, mapSizePanelConstraints);
        add(stepPanel, stepPanelConstraints);
        add(buttonsPanel, buttonsPanelConstraints);
    }

}
