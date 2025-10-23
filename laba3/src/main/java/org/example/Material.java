package org.example;

/**
 * Класс, представляющий материал детали.
 * Используется в композиции с классом Detail.
 * 
 * @author Ваше имя
 * @version 1.0
 * @see Detail
 */
public class Material {
    private String name;

    /**
     * Конструктор для создания нового материала.
     * 
     * @param name название материала (например, "Металл", "Пластик", "Дерево")
     */
    public Material(String name) {
        this.name = name;
    }

    /**
     * Возвращает название материала.
     * 
     * @return название материала
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает строковое представление материала.
     * 
     * @return название материала
     */
    @Override
    public String toString() {
        return name;
    }
}