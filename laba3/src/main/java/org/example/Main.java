package org.example;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Основной класс приложения для демонстрации работы с деталями.
 * Содержит main метод и демонстрирует функциональность системы деталей.
 * 
 * @author Ярик
 * @version 1.0
 * @see Detail
 * @see Shape
 * @see Material
 */

public class Main {

    /**
     * Основной метод приложения.
     * Запускает графический интерфейс для управления деталями.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Установка системного Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            try {
                // Fallback на кроссплатформенный стиль
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Запуск графического интерфейса в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DetailGUI gui = new DetailGUI();
                gui.setVisible(true);
            }
        });
    }
}