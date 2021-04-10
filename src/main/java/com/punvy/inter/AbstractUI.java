package com.punvy.inter;

import com.punvy.base.*;
import com.punvy.checkers.CheckerValue;

import java.lang.reflect.Field;

public abstract class AbstractUI implements UI{

    CheckerValue checker;


    AbstractUI(){
        checker = new CheckerValue();
        createUI();
    }

    @Override
    public void run() {

    }

    @Override
    public abstract void display(TypeMessage type, String message);

    public Object inputField(Field field) {
        String fieldName = field.getName();
        Class fieldType = field.getType();
        boolean fieldAbleBeNull = field.getAnnotation(HumanBeing.AbleBeNull.class) instanceof HumanBeing.AbleBeNull;
        if (fieldAbleBeNull) {
            display(TypeMessage.INFO, "Это поле(" + fieldName +") опционально. Y - ввести поле. N - пропустить ввод поля.");
            display(TypeMessage.INPUT, "Введите(Y/N): ");
            String optional = inputLine();
            while (!optional.equalsIgnoreCase("y") && !optional.equalsIgnoreCase("n")){
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT, "Введите(Y/N): ");
                optional = inputLine();
            }
            if (optional.equalsIgnoreCase("n")) { return null; }
        }
        if (fieldType.equals(String.class)) {
            display(TypeMessage.INPUT,fieldName + ": ");
            boolean fieldWithoutEmptyLine = field.getAnnotation(HumanBeing.WithoutEmptyLine.class) instanceof HumanBeing.WithoutEmptyLine;
            String stringValue = inputLine();
            if(fieldWithoutEmptyLine) {
                while (!checker.checkStringValue(stringValue)) {
                    display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                    display(TypeMessage.INPUT,fieldName + ": ");
                    stringValue = inputLine();
                }
                return stringValue;
            }
        }
        else if(fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
            display(TypeMessage.INPUT,fieldName + "(true/false): ");
            String stringValue = inputLine();
            while (!checker.checkBooleanValue(stringValue)){
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + "(true/false): ");
                stringValue = inputLine();
            }
            return Boolean.valueOf(stringValue);
        }
        else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
            display(TypeMessage.INPUT,fieldName + ": ");
            String stringValue = inputLine();
            while (!checker.checkIntegerValue(stringValue)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + ": ");
                stringValue = inputLine();
            }
            return Integer.valueOf(stringValue);
        }
        else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
            MaxLongValue fieldHaveMax = field.getAnnotation(MaxLongValue.class) ;
            long max = Long.MAX_VALUE;
            if (fieldHaveMax instanceof MaxLongValue) {
                max = fieldHaveMax.max();
            }
            display(TypeMessage.INPUT,fieldName + ": ");
            String stringValue = inputLine();
            while (!checker.checkLongValue(stringValue, max)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + ": ");
                stringValue = inputLine();
            }
            return Long.valueOf(stringValue);
        }
        else if (fieldType.equals(Float.class) || fieldType.equals(float.class)) {
            display(TypeMessage.INPUT,fieldName + ": ");
            String stringValue = inputLine();
            while (!checker.checkFloatValue(stringValue)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + ": ");
                stringValue = inputLine();
            }
            return Float.valueOf(stringValue);
        }
        else if (fieldType.equals(double.class) || fieldType.equals(double.class)){
            display(TypeMessage.INPUT,fieldName + ": ");
            String stringValue = inputLine();
            while (!checker.checkDoubleValue(stringValue)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + ": ");
                stringValue = inputLine();
            }
            return Double.valueOf(stringValue);
        }
        else if (fieldType.equals(Mood.class)){
            display(TypeMessage.INPUT,fieldName + "(LONGING/GLOOM/APATHY): ");
            String stringValue = inputLine();
            while (!checker.checkMoodValue(stringValue)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + "(LONGING/GLOOM/APATHY): ");
                stringValue = inputLine();
            }
            if(stringValue.equalsIgnoreCase("LONGING")){
                return Mood.LONGING;
            }
            else if(stringValue.equalsIgnoreCase("GLOOM")){
                return Mood.GLOOM;
            }
            else if(stringValue.equalsIgnoreCase("APATHY")){
                return Mood.APATHY;
            }
        }
        else if (fieldType.equals(Car.class)) {
            display(TypeMessage.INFO,fieldName + ": ");
            try {
                return new Car((Boolean)inputField(Car.class.getDeclaredField("cool")));
            } catch (NoSuchFieldException e) {
                return null;
            }
        }
        else if (fieldType.equals(Coordinates.class)) {
            display(TypeMessage.INFO, fieldName + ": ");
            try {
                return new Coordinates((Long) inputField(Coordinates.class.getDeclaredField("x")),
                        (Double) inputField(Coordinates.class.getDeclaredField("y")));
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }

    protected abstract void createUI();

    protected abstract String inputLine();
}