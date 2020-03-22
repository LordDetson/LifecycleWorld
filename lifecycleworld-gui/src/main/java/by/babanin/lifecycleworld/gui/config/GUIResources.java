package by.babanin.lifecycleworld.gui.config;

public enum GUIResources {
    TITLE_MAIN_FRAME("Lifecycle World"),
    TITLE_SETTINGS_FRAME("Settings");

    private final String value;

    GUIResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
