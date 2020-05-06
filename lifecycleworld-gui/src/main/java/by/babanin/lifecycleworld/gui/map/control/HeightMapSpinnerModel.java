package by.babanin.lifecycleworld.gui.map.control;

public final class HeightMapSpinnerModel extends AbstractMapSpinnerModel {
    private static final Integer DEFAULT_MAP_SIZE = 100;
    private static final Integer MAX_MAP_SIZE = 1000;

    private static final HeightMapSpinnerModel INSTANCE = new HeightMapSpinnerModel();

    private HeightMapSpinnerModel() {
        super(DEFAULT_MAP_SIZE, MIN_MAP_SIZE, MAX_MAP_SIZE, SPINNER_STEP);
    }

    public static HeightMapSpinnerModel getInstance() {
        return INSTANCE;
    }
}
