package org.example;

/**
 * Класс, представляющий деревянную деталь.
 * Наследуется от абстрактного класса Detail.
 * 
 * @author Ярик
 * @version 1.0
 * @see Detail
 */
public class WoodenDetail extends Detail {
    /**
     * Конструктор для создания деревянной детали.
     * 
     * @param shape форма детали
     * @param material материал детали (должен быть деревом)
     * @param weight вес детали в килограммах
     * @param size размер детали в сантиметрах
     */
    public WoodenDetail(Shape shape, Material material, double weight, double size) {
        super(shape, material, weight, size);
    }

    /**
     * Возвращает тип детали - "WoodenDetail".
     * 
     * @return строку "WoodenDetail"
     */
    @Override
    public String getDetailType() {
        return "WoodenDetail";
    }
}