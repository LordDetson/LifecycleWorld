package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;
import org.springframework.lang.NonNull;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel implements Initializer {
    private final JLabel fieldLabel;
    private final JLabel valueLabel;

    public FieldPanel(GUIResources textLabel) {
        this(textLabel.getValue());
    }

    public FieldPanel(String textLabel) {
        fieldLabel = new JLabel(textLabel);
        valueLabel = new JLabel();
    }

    @Override
    public void initialize() {
        setLayout(new GridLayout(1, 2));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.GRAY));
        Dimension preferredSize = valueLabel.getPreferredSize();
        preferredSize.width = 70;
        valueLabel.setPreferredSize(preferredSize);
        add(fieldLabel);
        add(valueLabel);
    }

    public void updateValue(@NonNull String value) {
        valueLabel.setText(value);
    }
}
