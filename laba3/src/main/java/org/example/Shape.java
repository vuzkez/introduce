package org.example;

/**
 * Класс, представляющий форму детали.
 * Используется в композиции с классом Detail.
 * 
 * @author Ваше имя
 * @version 1.0
 * @see Detail
 */
public class Shape {
    private String type;

    /**
     * Конструктор для создания новой формы.
     * 
     * @param type тип формы (например, "Круг", "Квадрат", "Треугольник")
     */
    public Shape(String type) {
        this.type = type;
    }

    /**
     * Возвращает тип формы.
     * 
     * @return строковое представление типа формы
     */
    public String getType() {
        return type;
    }

    /**
     * Возвращает строковое представление формы.
     * 
     * @return тип формы
     */
    @Override
    public String toString() {
        return type;
    }
}