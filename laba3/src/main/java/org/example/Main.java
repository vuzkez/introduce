package org.example;

/**
 * Основной класс приложения для демонстрации работы с деталями.
 * Содержит main метод и демонстрирует функциональность системы деталей.
 * 
 * @author Ваше имя
 * @version 1.0
 * @see Detail
 * @see Shape
 * @see Material
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * Основной метод приложения.
     * Демонстрирует создание деталей, работу с коллекциями и анализ данных.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        List<Detail> details = new ArrayList<>();

        // Создание объектов форм
        Shape circle = new Shape("Круг");
        Shape square = new Shape("Квадрат");
        Shape triangle = new Shape("Треугольник");
        Shape rectangle = new Shape("Прямоугольник");
        Shape oval = new Shape("Овал");

        // Создание объектов материалов
        Material metal = new Material("Металл");
        Material plastic = new Material("Пластик");
        Material wood = new Material("Дерево");

        // Создание не менее 10 объектов деталей
        details.add(new MetalDetail(circle, metal, 2.5, 5.0));
        details.add(new PlasticDetail(square, plastic, 1.2, 3.0));
        details.add(new WoodenDetail(triangle, wood, 0.8, 2.5));
        details.add(new MetalDetail(circle, metal, 3.0, 6.0));
        details.add(new MetalDetail(square, metal, 2.0, 4.0));
        details.add(new PlasticDetail(rectangle, plastic, 1.5, 3.5));
        details.add(new MetalDetail(triangle, metal, 2.2, 5.5));
        details.add(new WoodenDetail(circle, wood, 1.0, 4.0));
        details.add(new MetalDetail(rectangle, metal, 3.3, 7.0));
        details.add(new WoodenDetail(square, wood, 1.7, 3.8));
        details.add(new MetalDetail(oval, wood, 2, 3.4));

        System.out.println("Все детали");
        for (Detail d : details) {
            System.out.println(d);
        }
        System.out.println();

        // Подсчет общего веса деталей с одинаковой формой
        Map<String, Double> weightByShape = new HashMap<>();
        for (Detail d : details) {
            String shapeType = d.getShape().getType();
            weightByShape.put(shapeType,
                    weightByShape.getOrDefault(shapeType, 0.0) + d.getWeight());
        }

        System.out.println("Общий вес деталей по форме");
        for (Map.Entry<String, Double> entry : weightByShape.entrySet()) {
            System.out.printf("Форма: %s, общий вес: %.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        // Вывод количества деталей
        System.out.println("Количество деталей");
        System.out.println("Общее количество деталей: " + details.size());
        System.out.println();

        // Поиск детали, которая отличается своей формой
        Map<String, Integer> shapeCount = new HashMap<>();
        for (Detail d : details) {
            String shapeType = d.getShape().getType();
            shapeCount.put(shapeType, shapeCount.getOrDefault(shapeType, 0) + 1);
        }

        String uniqueShape = null;
        for (Map.Entry<String, Integer> entry : shapeCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueShape = entry.getKey();
                break;
            }
        }

        if (uniqueShape != null) {
            final String finalUniqueShape = uniqueShape;
            for (Detail d : details) {
                if (d.getShape().getType().equals(finalUniqueShape)) {
                    System.out.println("Деталь с уникальной формой: " + d);
                    break;
                }
            }
        } else {
            System.out.println("Деталь с уникальной формой не найдена.");
        }
    }
}