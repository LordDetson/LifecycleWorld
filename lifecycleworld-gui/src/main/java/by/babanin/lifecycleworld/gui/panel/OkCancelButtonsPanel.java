package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OkCancelButtonsPanel extends JPanel implements Initializer {
    private final Window owner;
    private JButton okButton;
    private JButton cancelButton;

    public OkCancelButtonsPanel(Window owner) {
        this.owner = owner;
    }

    @Override
    public void initialize() {
        setLayout(new GridLayout(1, 2, 5, 5));

        initComponents();
        initActions();
        composeComponents();
    }

    private void initComponents() {
        okButton = new JButton(GUIResources.OK.getValue());
        cancelButton = new JButton(GUIResources.CANCEL.getValue());
    }

    private void initActions() {
        cancelButton.addActionListener(e -> owner.dispose());
    }

    private void composeComponents() {
        add(okButton);
        add(cancelButton);
    }

    public void addOkAction(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    public void addCancelAction(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

}
