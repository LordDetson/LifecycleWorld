package by.babanin.lifecycleworld.gui.config;

public class GUIProperties {
    public static final String ICONS_PATH = "icon.path";
    public static final String HEXAGON_IMAGES_PATH = "hexagon.image.path";

    private static final String JAVA_AWT_HEADLESS = "java.awt.headless";
    private static final String DEFAULT_ICONS_PATH = "img/icons/";
    private static final String DEFAULT_HEXAGON_IMAGES_PATH = "img/hexagon/";

    private GUIProperties(){}

    public static void setUpProperties() {
        System.setProperty(JAVA_AWT_HEADLESS, Boolean.FALSE.toString());
        System.setProperty(ICONS_PATH, DEFAULT_ICONS_PATH);
        System.setProperty(HEXAGON_IMAGES_PATH, DEFAULT_HEXAGON_IMAGES_PATH);
    }
}
