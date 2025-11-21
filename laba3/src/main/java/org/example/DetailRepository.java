package org.example;

import java.util.ArrayList;
import java.util.List;  

/**
 * Класс-репозиторий для управления коллекцией деталей.
 * Обеспечивает базовые операции (создание, чтение, обновление, удаление).
 * 
 * @author Ярик
 * @version 1.1
 * @see Detail
 */
public class DetailRepository {
    /**
     * Коллекция для хранения экземпляров деталей.
     * Используется ArrayList для эффективного доступа по индексу.
     */
    private List<Detail> details;

    /**
     * Конструктор по умолчанию.
     * Инициализирует пустую коллекцию деталей.
     */
    public DetailRepository() {
        this.details = new ArrayList<>();
    }

    /**
     * Конструктор с инициализацией существующей коллекцией.
     * 
     * @param details начальная коллекция деталей
     */
    public DetailRepository(List<Detail> details) {
        this.details = details;
    }

    /**
     * Добавляет новую деталь в коллекцию.
     * 
     * @param detail деталь для добавления
     * @return true если деталь успешно добавлена, false в противном случае
     * @throws IllegalArgumentException если передан null
     */
    public boolean addDetail(Detail detail) {
        if (detail == null) {
            throw new IllegalArgumentException("Деталь не может быть null");
        }
        return details.add(detail);
    }

    /**
     * Удаляет деталь из коллекции по индексу.
     * 
     * @param index индекс удаляемой детали
     * @return удаленная деталь
     * @throws IndexOutOfBoundsException если индекс выходит за границы коллекции
     */
    public Detail removeDetail(int index) {
        if (index < 0 || index >= details.size()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы коллекции");
        }
        return details.remove(index);
    }

    /**
     * Удаляет деталь из коллекции по объекту.
     * 
     * @param detail деталь для удаления
     * @return true если деталь была найдена и удалена, false в противном случае
     */
    public boolean removeDetail(Detail detail) {
        return details.remove(detail);
    }

    /**
     * Обновляет деталь в коллекции по индексу.
     * 
     * @param index индекс обновляемой детали
     * @param newDetail новая деталь
     * @return предыдущая деталь
     * @throws IndexOutOfBoundsException если индекс выходит за границы коллекции
     * @throws IllegalArgumentException если новая деталь равна null
     */
    public Detail updateDetail(int index, Detail newDetail) {
        if (index < 0 || index >= details.size()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы коллекции");
        }
        if (newDetail == null) {
            throw new IllegalArgumentException("Новая деталь не может быть null");
        }
        return details.set(index, newDetail);
    }

    /**
     * Возвращает деталь по индексу.
     * 
     * @param index индекс запрашиваемой детали
     * @return деталь по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за границы коллекции
     */
    public Detail getDetail(int index) {
        if (index < 0 || index >= details.size()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы коллекции");
        }
        return details.get(index);
    }

    /**
     * Возвращает количество деталей в репозитории.
     * 
     * @return размер коллекции
     */
    public int size() {
        return details.size();
    }

    /**
     * Возвращает все детали в виде списка.
     * 
     * @return список всех деталей
     */
    public List<Detail> getAllDetails() {
        return new ArrayList<>(details);
    }
}