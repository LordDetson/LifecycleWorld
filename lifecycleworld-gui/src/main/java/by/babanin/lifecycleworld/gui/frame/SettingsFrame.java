package by.babanin.lifecycleworld.gui.frame;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;
import by.babanin.lifecycleworld.gui.util.SwingUtils;

import javax.swing.*;

public class SettingsFrame extends JFrame implements Initializer {

    @Override
    public void initialize() {
        setTitle(GUIResources.TITLE_SETTINGS_FRAME.getValue());
        setSize(400, 600);
        SwingUtils.doCenterScreen(this);
    }

}
