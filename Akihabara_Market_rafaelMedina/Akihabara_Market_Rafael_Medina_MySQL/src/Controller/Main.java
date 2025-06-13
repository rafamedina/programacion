package Controller;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import GUI.GUIGeneral;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("No se pudo aplicar FlatLaf: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            GUIGeneral controller = new GUIGeneral();
            controller.setVisible(true);
        });
    }
}
