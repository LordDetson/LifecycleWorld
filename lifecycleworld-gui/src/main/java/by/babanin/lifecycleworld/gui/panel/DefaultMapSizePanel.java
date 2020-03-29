package by.babanin.lifecycleworld.gui.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class DefaultMapSizePanel extends JPanel implements Initializer {
    private static final Integer INSETS1 = 10;
    private static final Integer INSETS2 = 5;
    private static final Integer INSETS3 = 1;

    @Override
    public void initialize() {
        setBorder(BorderFactory.createTitledBorder(GUIResources.TITLE_MAP_SIZE_PANEL.getValue()));
        setLayout(new GridBagLayout());

        JLabel mapWidthLabel = new JLabel(GUIResources.WIDTH.getValue());
        JSpinner mapWidthField = new JSpinner(new DefaultSpinnerMapModel());
        JLabel mapHeightLabel = new JLabel(GUIResources.HEIGHT.getValue());
        JSpinner mapHeightField = new JSpinner(new DefaultSpinnerMapModel());

        GridBagConstraints mapWidthLabelConstraints = new GridBagConstraints();
        GridBagConstraints mapWidthFieldConstraints = new GridBagConstraints();
        GridBagConstraints mapHeightLabelConstraints = new GridBagConstraints();
        GridBagConstraints mapHeightFieldConstraints = new GridBagConstraints();
        mapWidthLabelConstraints.gridx = 0;
        mapWidthLabelConstraints.gridy = 0;
        mapWidthLabelConstraints.insets = new Insets(INSETS1, INSETS1, INSETS3, INSETS2);
        mapWidthFieldConstraints.gridx = 1;
        mapWidthFieldConstraints.gridy = 0;
        mapWidthFieldConstraints.insets = new Insets(INSETS1, INSETS2, INSETS3, INSETS1);
        mapHeightLabelConstraints.gridx = 0;
        mapHeightLabelConstraints.gridy = 1;
        mapHeightLabelConstraints.insets = new Insets(INSETS3, INSETS1, INSETS1, INSETS2);
        mapHeightFieldConstraints.gridx = 1;
        mapHeightFieldConstraints.gridy = 1;
        mapHeightFieldConstraints.insets = new Insets(INSETS3, INSETS2, INSETS1, INSETS1);

        add(mapWidthLabel, mapWidthLabelConstraints);
        add(mapWidthField, mapWidthFieldConstraints);
        add(mapHeightLabel, mapHeightLabelConstraints);
        add(mapHeightField, mapHeightFieldConstraints);
    }

    private static final class DefaultSpinnerMapModel extends SpinnerNumberModel {
        private static final Integer DEFAULT_MAP_SIZE = 5;
        private static final Integer MAX_MAP_SIZE = 100;
        private static final Integer MIN_MAP_SIZE = 1;
        private static final Integer SPINNER_STEP = 1;

        public DefaultSpinnerMapModel() {
            super(DEFAULT_MAP_SIZE, MIN_MAP_SIZE, MAX_MAP_SIZE, SPINNER_STEP);
        }
    }
}
