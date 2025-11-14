package org.example;

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
     * Демонстрирует создание деталей, работу с коллекциями и анализ данных.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // создаем репозиторий для работы с деталями
        DetailRepository repository = new DetailRepository();
        
        // создаем формы деталей
        Shape circle = new Shape("Круг");
        Shape square = new Shape("Квадрат");
        Shape triangle = new Shape("Треугольник");
        
        // создаем материалы
        Material metal = new Material("Металл");
        Material plastic = new Material("Пластик");
        Material wood = new Material("Дерево");
        
        // добавляем несколько деталей в репозиторий
        System.out.println("добавляем детали в репозиторий:");
        repository.addDetail(new MetalDetail(circle, metal, 2.5, 5.0));
        repository.addDetail(new PlasticDetail(square, plastic, 1.2, 3.0));
        repository.addDetail(new WoodenDetail(triangle, wood, 0.8, 2.5));
        repository.addDetail(new MetalDetail(square, metal, 3.0, 6.0));
        
        // получаем деталь по индексу
        System.out.println("получаем деталь с индексом 1:");
        try {
            Detail detail = repository.getDetail(1);
            System.out.println("деталь: " + detail);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ошибка: " + e.getMessage());
        }
        System.out.println();
        
        // пробуем получить деталь с неверным индексом
        System.out.println("пробуем получить деталь с индексом 10:");
        try {
            Detail detail = repository.getDetail(10);
            System.out.println("деталь: " + detail);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("поймали ошибку: " + e.getMessage());
        }
        System.out.println();
        
        // обновляем деталь
        System.out.println("обновляем деталь с индексом 0:");
        try {
            Detail newDetail = new MetalDetail(circle, metal, 5.0, 10.0);
            Detail oldDetail = repository.updateDetail(0, newDetail);
            System.out.println("старая деталь: " + oldDetail);
            System.out.println("новая деталь: " + repository.getDetail(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ошибка: " + e.getMessage());
        }
        System.out.println();
        
        // удаляем деталь
        System.out.println("удаляем деталь с индексом 2:");
        try {
            Detail removedDetail = repository.removeDetail(2);
            System.out.println("удалили деталь: " + removedDetail);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ошибка: " + e.getMessage());
        }
        System.out.println();
        
        // проверяем добавление null
        System.out.println("пробуем добавить null:");
        try {
            repository.addDetail(null);
        } catch (IllegalArgumentException e) {
            System.out.println("поймали ошибку: " + e.getMessage());
        }
        System.out.println();
        
        // проверяем работу с пустым репозиторием
        System.out.println("пробуем получить деталь из пустого репозитория:");
        try {
            repository.getDetail(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("поймали ошибку: " + e.getMessage());
        }
    }
}