package by.babanin.lifecycleworld.gui.config;

public class GUIProperties {
    private static final String JAVA_AWT_HEADLESS = "java.awt.headless";

    private GUIProperties(){}

    public static void setUpProperties() {
        System.setProperty(JAVA_AWT_HEADLESS, Boolean.FALSE.toString());
    }

}
