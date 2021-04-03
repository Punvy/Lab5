package com.punvy.inter;

import com.punvy.base.HumanBeing;
import com.punvy.base.MaxLongValue;
import com.punvy.base.Mood;
import com.punvy.logic.CheckerValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public abstract class AbstractUI implements UI{

    CheckerValue checker;

    AbstractUI(){
         checker = new CheckerValue();
    }

    @Override
    public void run() {

    }

    @Override
    public abstract void display(TypeMessage type, String message);

    protected Object inputField(Field field){
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
        else if (fieldType.equals(Mood.class)){
            display(TypeMessage.INPUT,fieldName + "(LONGING/GLOOM/APATHY): ");
            String stringValue = inputLine();
            while (!checker.checkMoodValue(stringValue)) {
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                display(TypeMessage.INPUT,fieldName + "(LONGING/GLOOM/APATHY): ");
                stringValue = inputLine();
            }
            return Mood.valueOf(stringValue);
        }

        return null;
    }

    protected abstract void createUI();

    protected abstract String inputLine();
}