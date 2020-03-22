package by.babanin.lifecycleworld.gui.panel;

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
        JLabel generationLabel = new JLabel("Generation");
        JLabel generationValue = new JLabel("0");
        JLabel populationLabel = new JLabel("Population");
        JLabel populationValue = new JLabel("0");
        westPanel.add(generationLabel);
        westPanel.add(generationValue);
        westPanel.add(populationLabel);
        westPanel.add(populationValue);
        return westPanel;
    }
}
