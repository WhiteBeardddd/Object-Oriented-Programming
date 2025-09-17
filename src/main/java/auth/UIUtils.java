package auth;

import javax.swing.*;
import java.awt.*;

public class UIUtils {
    public static void applyDarkTheme(JFrame frame) {
        frame.getContentPane().setBackground(new Color(40, 40, 40));
        frame.setSize(400, 300); // default size for all windows
        frame.setLocationRelativeTo(null); // center on screen

        // Apply global dark style to buttons & labels
        UIManager.put("Button.background", new Color(70, 70, 70));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("TextField.background", new Color(60, 60, 60));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("PasswordField.background", new Color(60, 60, 60));
        UIManager.put("PasswordField.foreground", Color.WHITE);
    }
}
