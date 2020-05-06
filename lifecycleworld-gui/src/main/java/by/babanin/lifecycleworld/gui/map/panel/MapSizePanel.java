package by.babanin.lifecycleworld.gui.map.panel;

import by.babanin.lifecycleworld.gui.config.GUIResources;
import by.babanin.lifecycleworld.gui.map.control.HeightMapSpinnerModel;
import by.babanin.lifecycleworld.gui.map.control.WidthMapSpinnerModel;
import by.babanin.lifecycleworld.gui.map.model.MapSize;
import by.babanin.lifecycleworld.gui.util.Initializer;

import javax.swing.*;
import java.awt.*;

public class MapSizePanel extends JPanel implements Initializer {

    private JLabel columnsMapLabel;
    private JSpinner columnsMapField;
    private JLabel rowsMapLabel;
    private JSpinner rowsMapField;

    @Override
    public void initialize() {
        setBorder(BorderFactory.createTitledBorder(GUIResources.TITLE_MAP_SIZE_PANEL.getValue()));
        setLayout(new GridBagLayout());

        initComponents();
        composeComponents();
    }

    private void initComponents() {
        columnsMapLabel = new JLabel(GUIResources.COLUMNS.getValue());
        columnsMapField = new JSpinner(WidthMapSpinnerModel.getInstance());
        rowsMapLabel = new JLabel(GUIResources.ROWS.getValue());
        rowsMapField = new JSpinner(HeightMapSpinnerModel.getInstance());
    }

    private void composeComponents() {
        GridBagConstraints mapColumnsLabelConstraints = new GridBagConstraints();
        GridBagConstraints mapColumnsFieldConstraints = new GridBagConstraints();
        GridBagConstraints mapRowsLabelConstraints = new GridBagConstraints();
        GridBagConstraints mapRowsFieldConstraints = new GridBagConstraints();
        mapColumnsLabelConstraints.gridx = 0;
        mapColumnsLabelConstraints.gridy = 0;
        mapColumnsLabelConstraints.insets = new Insets(7, 4, 1, 4);
        mapColumnsLabelConstraints.anchor = GridBagConstraints.WEST;
        mapColumnsFieldConstraints.gridx = 1;
        mapColumnsFieldConstraints.gridy = 0;
        mapColumnsFieldConstraints.insets = new Insets(7, 4, 1, 4);
        mapRowsLabelConstraints.gridx = 0;
        mapRowsLabelConstraints.gridy = 1;
        mapRowsLabelConstraints.insets = new Insets(1, 4, 7, 4);
        mapRowsLabelConstraints.anchor = GridBagConstraints.WEST;
        mapRowsFieldConstraints.gridx = 1;
        mapRowsFieldConstraints.gridy = 1;
        mapRowsFieldConstraints.insets = new Insets(1, 4, 7, 4);

        add(columnsMapLabel, mapColumnsLabelConstraints);
        add(columnsMapField, mapColumnsFieldConstraints);
        add(rowsMapLabel, mapRowsLabelConstraints);
        add(rowsMapField, mapRowsFieldConstraints);
    }

    public MapSize getMapSize() {
        return new MapSize((Integer) rowsMapField.getValue(), (Integer) columnsMapField.getValue());
    }
}
