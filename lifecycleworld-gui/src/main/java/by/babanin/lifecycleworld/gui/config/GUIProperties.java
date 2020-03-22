package by.babanin.lifecycleworld.gui.config;

public class GUIProperties {
    public static final String SETTINGS_ICON_PATH = "settings.icon.path";

    private static final String JAVA_AWT_HEADLESS = "java.awt.headless";
    private static final String DEFAULT_SETTINGS_ICON_PATH = "img/icons/settings.png";

    private GUIProperties(){}

    public static void setUpProperties() {
        System.setProperty(JAVA_AWT_HEADLESS, Boolean.FALSE.toString());
        System.setProperty(SETTINGS_ICON_PATH, DEFAULT_SETTINGS_ICON_PATH);
    }
}
