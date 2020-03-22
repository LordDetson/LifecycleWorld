package by.babanin.lifecycleworld.gui.spring.listener;

import by.babanin.lifecycleworld.gui.config.GUIProperties;
import by.babanin.lifecycleworld.gui.frame.MainFrame;
import by.babanin.lifecycleworld.gui.util.SwingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class GUILauncher {
    private static final Logger log = LoggerFactory.getLogger(GUILauncher.class);

    @EventListener
    public void launch(ContextRefreshedEvent event) {
        try {
            GUIProperties.setUpProperties();
            SwingUtilities.invokeLater(() -> {
                MainFrame mainFrame = new MainFrame();
                mainFrame.initialize();
                mainFrame.setVisible(true);
            });
        } catch (Exception e) {
            log.error(SwingUtils.buildExceptionMessage(e));
        }
    }
}
