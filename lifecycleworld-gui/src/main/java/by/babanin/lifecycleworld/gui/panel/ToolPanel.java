package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIProperties;
import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.frame.SettingsFrame;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JToolBar implements Initializer {
    private static final Dimension BUTTON_SIZE = new Dimension(35, 35);
    private static final String ICON_PATH = System.getProperty(GUIProperties.ICONS_PATH);
    private static final String ICON_PLAY_FILENAME = "play.png";
    private static final String ICON_PAUSE_FILENAME = "pause.png";
    private static final String ICON_RESTART_FILENAME = "restart.png";
    private static final String ICON_FAST_FORWARD_FILENAME = "fast-forward.png";
    private static final String ICON_REWIND_FILENAME = "rewind.png";
    private static final String ICON_SETTING_FILENAME = "settings.png";
    private static final String ICON_HAND_FILENAME = "hand.png";
    private static final String ICON_SCALING_FILENAME = "scaling.png";

    private JButton playPauseButton;
    private JButton fastForwardButton;
    private JButton rewindButton;
    private JButton restartButton;
    private JButton settingsButton;
    private JButton handButton;
    private JButton scalingButton;

    @Override
    public void initialize() {
        initComponents();
        initActions();
    }

    private void initComponents() {
        playPauseButton = buildButton(ICON_PLAY_FILENAME, GUIResources.PLAY.getValue());
        fastForwardButton = buildButton(ICON_FAST_FORWARD_FILENAME, GUIResources.FAST_FORWARD.getValue());
        rewindButton = buildButton(ICON_REWIND_FILENAME, GUIResources.REWIND.getValue());
        restartButton = buildButton(ICON_RESTART_FILENAME, GUIResources.RESTART.getValue());
        settingsButton = buildButton(ICON_SETTING_FILENAME, GUIResources.SETTINGS.getValue());
        handButton = buildButton(ICON_HAND_FILENAME, GUIResources.HAND.getValue());
        scalingButton = buildButton(ICON_SCALING_FILENAME, GUIResources.SCALING.getValue());
        add(rewindButton);
        add(playPauseButton);
        add(fastForwardButton);
        addSeparator();
        add(restartButton);
        add(settingsButton);
        addSeparator();
        add(handButton);
        add(scalingButton);
    }

    private JButton buildButton(String iconFilename, String toolTipText) {
        JButton button = new JButton();
        button.setIcon(SwingUtils.loadImage(ICON_PATH + iconFilename, BUTTON_SIZE));
        button.setToolTipText(toolTipText);
        button.setFocusPainted(false);
        return button;
    }

    private void initActions() {
        playPauseButton.addActionListener(e -> {
            if (playPauseButton.getToolTipText().equals(GUIResources.PLAY.getValue())) {
                playPauseButton.setIcon(SwingUtils.loadImage(ICON_PATH + ICON_PAUSE_FILENAME, BUTTON_SIZE));
                playPauseButton.setToolTipText(GUIResources.PAUSE.getValue());
            } else {
                playPauseButton.setIcon(SwingUtils.loadImage(ICON_PATH + ICON_PLAY_FILENAME, BUTTON_SIZE));
                playPauseButton.setToolTipText(GUIResources.PLAY.getValue());
            }
        });
        settingsButton.addActionListener(e -> {
            SettingsFrame settingsFrame = new SettingsFrame();
            settingsFrame.initialize();
            settingsFrame.setVisible(true);
        });
    }

}
