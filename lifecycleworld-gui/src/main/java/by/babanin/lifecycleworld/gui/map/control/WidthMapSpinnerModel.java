package by.babanin.lifecycleworld.gui.map.control;

public final class WidthMapSpinnerModel extends AbstractMapSpinnerModel {
    private static final Integer DEFAULT_MAP_SIZE = 200;
    private static final Integer MAX_MAP_SIZE = 1600;

    private static final WidthMapSpinnerModel INSTANCE = new WidthMapSpinnerModel();

    private WidthMapSpinnerModel() {
        super(DEFAULT_MAP_SIZE, MIN_MAP_SIZE, MAX_MAP_SIZE, SPINNER_STEP);
    }

    public static WidthMapSpinnerModel getInstance() {
        return INSTANCE;
    }
}
