package org.example;

/**
 * Класс, представляющий пластиковую деталь.
 * Наследуется от абстрактного класса Detail.
 * 
 * @author Ярик
 * @version 1.0
 * @see Detail
 */
public class PlasticDetail extends Detail {
    /**
     * Конструктор для создания пластиковой детали.
     * 
     * @param shape форма детали
     * @param material материал детали (должен быть пластиком)
     * @param weight вес детали в килограммах
     * @param size размер детали в сантиметрах
     */
    public PlasticDetail(Shape shape, Material material, double weight, double size) {
        super(shape, material, weight, size);
    }

    /**
     * Возвращает тип детали - "PlasticDetail".
     * 
     * @return строку "PlasticDetail"
     */
    @Override
    public String getDetailType() {
        return "PlasticDetail";
    }
}