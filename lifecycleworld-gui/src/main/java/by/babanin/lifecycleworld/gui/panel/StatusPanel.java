package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel implements Initializer {
    private JProgressBar progressBar;

    @Override
    public void initialize() {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        initComponents();
    }

    private void initComponents() {
        JPanel westPanel = createWestPanel();
        progressBar = new JProgressBar();
        add(westPanel, BorderLayout.WEST);
        add(progressBar, BorderLayout.EAST);
    }

    private JPanel createWestPanel() {
        JPanel westPanel = new JPanel();
        FieldPanel generationPanel = new FieldPanel(GUIResources.GENERATION);
        generationPanel.initialize();
        FieldPanel populationPanel = new FieldPanel(GUIResources.POPULATION);
        populationPanel.initialize();
        generationPanel.updateValue("999999999");
        populationPanel.updateValue("999999999");
        westPanel.add(generationPanel);
        westPanel.add(populationPanel);
        return westPanel;
    }
}
