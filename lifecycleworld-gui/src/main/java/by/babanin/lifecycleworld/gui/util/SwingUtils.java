package by.babanin.lifecycleworld.gui.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SwingUtils {
    private static final Logger log = LoggerFactory.getLogger(SwingUtils.class);

    private SwingUtils() {}

    public static void doCenterScreen(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(
                screenSize.width / 2 - window.getSize().width / 2,
                screenSize.height / 2 - window.getSize().height / 2
        );
    }

    public static ImageIcon loadImage(String path, int width, int height) {
        return loadImage(path, new Dimension(width, height));
    }

    public static ImageIcon loadImage(String path, Dimension size) {
        ImageIcon imageIcon = null;
        try {
            InputStream imageResourceAsStream = SwingUtils.class.getClassLoader().getResourceAsStream(path);
            assert imageResourceAsStream != null;
            BufferedImage bufferedImage = ImageIO.read(imageResourceAsStream);
            bufferedImage = resizeImage(bufferedImage, size);
            imageIcon = new ImageIcon(bufferedImage);
        } catch (IOException e) {
            log.error(buildExceptionMessage(e));
        }
        return imageIcon;
    }

    private static BufferedImage resizeImage(BufferedImage resize, Dimension size) {
        Image tmp = resize.getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage((int) size.getWidth(), (int) size.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    public static String buildExceptionMessage(Exception e) {
        final StringBuilder builder = new StringBuilder().append(e.getClass().getName()).append(": ").append(e.getMessage()).append("\n");
        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> builder.append("\t").append(stackTraceElement.toString()).append("\n"));
        return builder.toString();
    }
}
