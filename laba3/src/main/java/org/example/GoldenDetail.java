package org.example;
/**
 * Класс, представляющий пластиковую деталь.
 * Наследуется от абстрактного класса Detail.
 * 
 * @author Ярик
 * @version 1.0
 * @see Detail
 */
public class GoldenDetail extends Detail {
    
    public GoldenDetail(Shape shape, Material material, double weight, double size) {
        super(shape, material, weight, size);
    }

     /**
     * Возвращает тип детали - "GoldenDetail".
     * 
     * @return строку "Goldenetail"
     */
    @Override
    public String getDetailType() {
        return "Goldenl";
    }
}
