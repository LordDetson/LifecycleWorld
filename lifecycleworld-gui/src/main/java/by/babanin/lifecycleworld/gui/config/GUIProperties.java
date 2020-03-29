package by.babanin.lifecycleworld.gui.config;

public class GUIProperties {
    public static final String ICONS_PATH = "icon.path";

    private static final String JAVA_AWT_HEADLESS = "java.awt.headless";
    private static final String DEFAULT_ICONS_PATH = "img/icons/";

    private GUIProperties(){}

    public static void setUpProperties() {
        System.setProperty(JAVA_AWT_HEADLESS, Boolean.FALSE.toString());
        System.setProperty(ICONS_PATH, DEFAULT_ICONS_PATH);
    }
}
