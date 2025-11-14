package org.example;

/**
 * Абстрактный базовый класс, представляющий деталь.
 * Содержит основные свойства детали: форму, материал, вес и размер.
 * Является родительским классом для всех конкретных типов деталей.
 * 
 * @author Ярик
 * @version 1.0
 * @see Shape
 * @see Material
 * @see MetalDetail
 * @see PlasticDetail
 * @see WoodenDetail
 */
public abstract class Detail {
    private Shape shape;
    private Material material;
    private double weight;
    private double size;

    /**
     * Конструктор для создания нового объекта детали.
     * 
     * @param shape форма детали
     * @param material материал детали
     * @param weight вес детали в килограммах
     * @param size размер детали в сантиметрах
     * @throws IllegalArgumentException если вес или размер отрицательные
     */
    public Detail(Shape shape, Material material, double weight, double size) {
        this.shape = shape;
        this.material = material;
        this.weight = weight;
        this.size = size;
    }

    /**
     * Возвращает форму детали.
     * 
     * @return объект Shape, представляющий форму детали
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Возвращает материал детали.
     * 
     * @return объект Material, представляющий материал детали
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Возвращает вес детали.
     * 
     * @return вес детали в килограммах
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Возвращает размер детали.
     * 
     * @return размер детали в сантиметрах
     */
    public double getSize() {
        return size;
    }

    /**
     * Абстрактный метод для получения типа детали.
     * Должен быть реализован в классах-наследниках.
     * 
     * @return строковое представление типа детали
     */
    public abstract String getDetailType();

    /**
     * Возвращает строковое представление детали.
     * 
     * @return строка в формате "ТипДетали{shape=форма, material=материал, weight=вес, size=размер}"
     */
    @Override
    public String toString() {
        return getDetailType() + ": " +
                "shape=" + shape +
                ", material=" + material +
                ", weight=" + weight +
                ", size=" + size;
    }
}