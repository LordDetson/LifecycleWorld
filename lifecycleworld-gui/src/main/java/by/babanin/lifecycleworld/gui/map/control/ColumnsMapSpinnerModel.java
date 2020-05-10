package by.babanin.lifecycleworld.gui.map.control;

import javax.swing.*;

public final class ColumnsMapSpinnerModel extends SpinnerNumberModel {
    public static final Integer DEFAULT_MAP_COLUMNS = 200;
    private static final Integer MAX_MAP_COLUMNS = 1600;
    private static final Integer MIN_MAP_COLUMNS = 20;
    private static final Integer SPINNER_STEP = 20;

    private static final ColumnsMapSpinnerModel INSTANCE = new ColumnsMapSpinnerModel();

    private ColumnsMapSpinnerModel() {
        super(DEFAULT_MAP_COLUMNS, MIN_MAP_COLUMNS, MAX_MAP_COLUMNS, SPINNER_STEP);
    }

    public static ColumnsMapSpinnerModel getInstance() {
        return INSTANCE;
    }
}
