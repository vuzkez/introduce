package org.example;

/**
 * Класс, представляющий металлическую деталь.
 * Наследуется от абстрактного класса Detail.
 * 
 * @author Ваше имя
 * @version 1.0
 * @see Detail
 */
 public class MetalDetail extends Detail {
    /**
     * Конструктор для создания металлической детали.
     * 
     * @param shape форма детали
     * @param material материал детали (должен быть металлом)
     * @param weight вес детали в килограммах
     * @param size размер детали в сантиметрах
     */
    public MetalDetail(Shape shape, Material material, double weight, double size) {
        super(shape, material, weight, size);
    }

    /**
     * Возвращает тип детали - "MetalDetail".
     * 
     * @return строку "MetalDetail"
     */
    @Override
    public String getDetailType() {
        return "MetalDetail";
    }
}