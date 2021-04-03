package com.punvy.inter;

/**
 * Интерфейс для разных UI
 */
public interface UI {

    /**
     * Запускает UI
     */
    void run();

    /**
     * @param type Тип сообщения
     * @param message Текст сообщения
     */
    void display(TypeMessage type, String message);

}
