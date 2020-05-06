package by.babanin.lifecycleworld.gui.map.control;

import javax.swing.*;

public abstract class AbstractMapSpinnerModel extends SpinnerNumberModel {
    protected static final Integer MIN_MAP_SIZE = 20;
    protected static final Integer SPINNER_STEP = 20;

    protected AbstractMapSpinnerModel(int value, int minimum, int maximum, int stepSize) {
        super(value, minimum, maximum, stepSize);
    }
}
