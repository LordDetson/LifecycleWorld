package by.babanin.lifecycleworld.gui.frame;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int FRAME_WIDTH = 1430;
    private static final int FRAME_HEIGHT = 760;

    public void initialize() {
        setTitle(GUIResources.TITLE_MAIN_FRAME.getValue());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        SwingUtils.doCenterScreen(this);
    }
}