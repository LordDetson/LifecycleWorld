package by.babanin.lifecycleworld.gui.config;

public enum GUIResources {
    TITLE_MAIN_FRAME("Lifecycle World"),
    TITLE_SETTINGS_FRAME("Settings"),
    TITLE_MAP_SIZE_PANEL("Map size"),
    COLUMNS("Columns"),
    ROWS("Rows"),
    TITLE_STEP_PANEL("Step"),
    PLAY("Play"),
    PAUSE("Pause"),
    RESTART("Restart"),
    FAST_FORWARD("Fast-forward"),
    REWIND("Rewind"),
    SETTINGS("Settings"),
    FULL_WINDOW("Full window"),
    GENERATION("Generation"),
    POPULATION("Population"),
    OK("OK"),
    CANCEL("Cancel");

    private final String value;

    GUIResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
