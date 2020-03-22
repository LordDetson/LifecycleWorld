package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIProperties;
import by.babanin.lifecycleworld.gui.frame.SettingsFrame;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JToolBar implements Initializer {
    private static final String SETTINGS_ICON_PATH = System.getProperty(GUIProperties.SETTINGS_ICON_PATH);
    private JButton settingsButton;

    @Override
    public void initialize() {
        initComponents();
        initActions();
    }

    private void initComponents() {
        settingsButton = new JButton();
        settingsButton.setIcon(SwingUtils.loadImage(SETTINGS_ICON_PATH, 35, 35));
        settingsButton.setToolTipText("Settings");
        settingsButton.setMargin(new Insets(0, 0, 0, 0));
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusPainted(false);
        settingsButton.setContentAreaFilled(false);
        add(settingsButton);
    }

    private void initActions() {
        settingsButton.addActionListener(e -> {
            SettingsFrame settingsFrame = new SettingsFrame();
            settingsFrame.initialize();
            settingsFrame.setVisible(true);
        });
    }

}
