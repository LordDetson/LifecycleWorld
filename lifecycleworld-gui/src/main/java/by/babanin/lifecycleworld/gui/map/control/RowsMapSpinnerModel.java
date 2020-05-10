package by.babanin.lifecycleworld.gui.map.control;

import javax.swing.*;

public final class RowsMapSpinnerModel extends SpinnerNumberModel {
    public static final Integer DEFAULT_MAP_ROWS = 100;
    private static final Integer MAX_MAP_ROWS = 1000;
    private static final Integer MIN_MAP_ROWS = 20;
    private static final Integer SPINNER_STEP = 20;

    private static final RowsMapSpinnerModel INSTANCE = new RowsMapSpinnerModel();

    private RowsMapSpinnerModel() {
        super(DEFAULT_MAP_ROWS, MIN_MAP_ROWS, MAX_MAP_ROWS, SPINNER_STEP);
    }

    public static RowsMapSpinnerModel getInstance() {
        return INSTANCE;
    }
}
