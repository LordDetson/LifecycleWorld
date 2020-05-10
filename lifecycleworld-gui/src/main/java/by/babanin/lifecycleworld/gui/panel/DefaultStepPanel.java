package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class DefaultStepPanel extends JPanel implements Initializer {
    private static final Integer DEFAULT_STEP = 5;
    private static final Integer MAX_STEP = 100;
    private static final Integer MIN_STEP = 0;
    private static final Integer MINOR_TS = 5;
    private static final Integer MAJOR_TS = 10;

    private JLabel stepLabel;

    @Override
    public void initialize() {
        setBorder(BorderFactory.createTitledBorder(GUIResources.TITLE_STEP_PANEL.getValue()));
        setLayout(new GridBagLayout());

        stepLabel = new JLabel(DEFAULT_STEP.toString(), SwingConstants.CENTER);
        stepLabel.setPreferredSize(new Dimension(25, 45));
        JSlider stepSlider = new SliderStep();
        stepSlider.setPreferredSize(new Dimension(200, 45));

        GridBagConstraints stepLabelConstraints = new GridBagConstraints();
        GridBagConstraints stepSliderConstraints = new GridBagConstraints();
        stepLabelConstraints.gridx = 0;
        stepLabelConstraints.gridy = 0;
        stepLabelConstraints.insets = new Insets(10, 5, 10, 5);
        stepSliderConstraints.gridx = 1;
        stepSliderConstraints.gridy = 0;
        stepSliderConstraints.insets = new Insets(10, 0, 10, 10);

        add(stepLabel, stepLabelConstraints);
        add(stepSlider, stepSliderConstraints);
    }

    private final class SliderStep extends JSlider implements ChangeListener {

        public SliderStep() {
            super(MIN_STEP, MAX_STEP, DEFAULT_STEP);
            setMinorTickSpacing(MINOR_TS);
            setMajorTickSpacing(MAJOR_TS);
            Hashtable<Integer, Component> position = new Hashtable<>();
            position.put(0, new JLabel("0"));
            position.put(20, new JLabel("20"));
            position.put(40, new JLabel("40"));
            position.put(60, new JLabel("60"));
            position.put(80, new JLabel("80"));
            position.put(100, new JLabel("100"));
            setLabelTable(position);
            setPaintTicks(true);
            setPaintLabels(true);
            addChangeListener(this);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            stepLabel.setText(String.valueOf(getValue()));
        }
    }
}
