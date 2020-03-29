package by.babanin.lifecycleworld.gui.config;

public enum GUIResources {
    TITLE_MAIN_FRAME("Lifecycle World"),
    TITLE_SETTINGS_FRAME("Settings"),
    TITLE_MAP_SIZE_PANEL("Map size"),
    WIDTH("Width"),
    HEIGHT("Height"),
    TITLE_STEP_PANEL("Step");

    private final String value;

    GUIResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
