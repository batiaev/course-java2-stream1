package com.batiaev.java1.lesson7;

/**
 * ContainsFood
 *
 * @author anton
 * @since 12/02/18
 */
public interface ContainsFood {
    double getAmountOfFood();

    void setAmountOfFood(double amountOfFood);

    /**
     * Используется при добавлении пользователем еды
     *
     * @param amount  - количество еды
     */
    void addSomeFood(double amount);

    /**
     * Кошка при еде, уменьшает количество еды в миске
     * @param amount
     */
    boolean decreaseFood(double amount);
}
