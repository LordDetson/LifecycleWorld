package by.babanin.lifecycleworld.gui.util;

import java.awt.*;

public class SwingUtils {

    private SwingUtils() {}

    public static void doCenterScreen(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(
                screenSize.width / 2 - window.getSize().width / 2,
                screenSize.height / 2 - window.getSize().height / 2
        );
    }

}
