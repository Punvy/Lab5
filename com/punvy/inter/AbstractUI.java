package com.punvy.inter;

import com.punvy.base.HumanBeing;
import com.punvy.logic.CheckerValue;

import java.lang.reflect.Field;

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
            }
            if (optional.equalsIgnoreCase("n")) { return null; }
        }

        display(TypeMessage.INFO,fieldName + ": ");

        if (fieldType.equals(String.class)) {
            boolean fieldWithoutEmptyLine = field.getAnnotation(HumanBeing.WithoutEmptyLine.class) instanceof HumanBeing.WithoutEmptyLine;
            String stringValue = inputLine();
            if(fieldWithoutEmptyLine) {
                while (!checker.checkStringValue(stringValue)) {
                    display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                    stringValue = inputLine();
                }
            }
        }

        else if(fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
            String stringValue = inputLine();
            while (!checker.checkBooleanValue(stringValue)){
                display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
            }
        }
        else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
            String stringValue = inputLine();
            while (checker.checkIntegerValue("")) { }
        }
        return null;
    }

    protected abstract void createUI();

    protected abstract String inputLine();
}