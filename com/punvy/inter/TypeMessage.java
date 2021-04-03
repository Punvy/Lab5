package com.punvy.inter;

/**
 * Перечесляемый тип сообщения
 */
public enum TypeMessage {
    INFO("\033[0m"),
    ERROR("\033[0;31m"),
    INPUT("\033[0;34m");

    public String getColor() {
        return color;
    }

    private String color;

    /**
     * Конструктор TypeMessage
     * @param color Цвет сообщения в консоли
     */
    TypeMessage(String color){
        this.color = color;
    }
}
