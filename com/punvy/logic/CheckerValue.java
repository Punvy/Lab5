package com.punvy.logic;

import com.punvy.inter.TypeMessage;

public class CheckerValue {

    /**
     * Проверяет можно ли превратить строку в INTEGER
     * @return True - значение можно превратить в Integer; False - значение нельзя превратить в Integer
     * @param stringValue Проверяемая строка
     */
    public boolean checkIntegerValue(String stringValue){
        try {
            Integer.valueOf(stringValue);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Так же проверяет меньше ли значение чем min.
     * @return Если меньше - False, Больше или равно - True
     * @param min Минимально возможное значение
     */
    public boolean checkIntegerValue(String stringValue, int min){
        if (checkIntegerValue(stringValue)) {
            if(Integer.valueOf(stringValue) >= min) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Так же проверяет больше ли значение чем min.
     * @return Если больше - False, меньше или равно - True
     * @param min Минимально возможное значение
     * @param max Минимально возможное значение
     */
    public boolean checkIntegerValue(String stringValue, int min, int max){
        if(checkIntegerValue(stringValue, min)) {
            return Integer.valueOf(stringValue) <= max;
        }
        return false;
    }

    /**
     * Соответвует {@link #checkIntegerValue(String)} для Long
     * @param stringValue Проверяемая строка
     */
    public boolean checkLongValue(String stringValue){
        try {
            Long.valueOf(stringValue);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Соответвует {@link #checkIntegerValue(String, int)} для Long
     * @param stringValue Проверяемая строка
     * @param min Минимально возможное значение
     */
    public boolean checkIntegerValue(String stringValue, long min){
        if (checkIntegerValue(stringValue)) {
            return Long.valueOf(stringValue) >= min;
        }
        return false;
    }

    /**
     * Соответвует {@link #checkIntegerValue(String, int, int)} для Long
     * @param stringValue Проверяемая строка
     * @param min Минимально возможное значение
     * @param max Минимально возможное значение
     */
    public boolean checkIntegerValue(String stringValue, long min, long max){
        if(checkIntegerValue(stringValue, min)) {
            return Integer.valueOf(stringValue) <= max;
        }
        return false;
    }

    /**
     * Проверяет пуста ли строка
     * @return "" - false, остальное - true
     * @param value Проверяеммая строка
     */
    public boolean checkStringValue(String value) {
        if (value.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    /**
     * Проверяет соответсвует ли строка одному из значений Mood
     * @param stringValue Проверяеммая строка
     */
    public boolean checkMoodValue(String stringValue){
        if (stringValue.equalsIgnoreCase("LONGING") || stringValue.equalsIgnoreCase("GLOOM")
                || stringValue.equalsIgnoreCase("APATHY")) { return true; }
        return false;
    }

    /**
     * Проверяет соответсвует ли строка значению true или false
     * @param stringValue Проверяеммая строка
     */
    public boolean checkBooleanValue(String stringValue) {
        if(stringValue.equalsIgnoreCase("true") || stringValue.equalsIgnoreCase("false")) {
            return true;
        }
        return false;
    }

    /**
     * Соответсвует {@link #checkIntegerValue(String)} для Double
     * @param stringValue Проверяемая строка
     */
    public boolean checkDoubleValue(String stringValue){
        try {
            Double.valueOf(stringValue);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Соответсвует {@link #checkIntegerValue(String)} для Float
     * @param stringValue Проверяемая строка
     */
    public boolean checkFloatValue(String stringValue){
        try {
            Float.valueOf(stringValue);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
