package com.punvy.inter;

import com.punvy.base.*;
import com.punvy.checkers.CheckerValue;
import com.punvy.checkers.InfoForCommand;
import com.punvy.logic.Editor;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class AbstractUI implements UI{

    private final CheckerValue checker;
    private Editor editor;
    private InfoForCommand infoForCommand;

    AbstractUI(){
        checker = new CheckerValue();
        this.infoForCommand = new InfoForCommand();
        createUI();
    }

    /**
     * Запускает UI
     */
    @Override
    public void run() {
        while (editor == null) {
            try {
                editor = new Editor(inputFileFromVariableEnvironment());
            } catch (FileNotFoundException e) {
                display(TypeMessage.ERROR, "ТАКОГО ФАЙЛА НЕ СУЩЕСТВУЕТ! ВВЕДИТЕ ДРУГУЮ ПЕРЕМЕНУЮ ОКРУЖЕНИЯ!");
            }
        }
        while (true) {
            display(TypeMessage.INPUT, "Введите команду: ");
            String command = inputLine();
            if (editor.checkCommand(command)) {
                if (command.equals("execute_script")) {
                    try {
                        String[] commands = editor.executeCommand(command, null).split("\\r?\\n");
                        for (String i : commands){
                            if (editor.checkCommand(i)){
                                String nameCommand = i.split(" ")[0];
                                if (infoForCommand.commandNeedElementArg(nameCommand)) {
                                    editor.executeCommand(i,inputHumanBeingElement());
                                }
                                else {
                                    editor.executeCommand(i,null);
                                }
                            }
                        }
                    }catch (Exception exception) {
                        display(TypeMessage.ERROR,"Что-то не так с командой");
                    }
                }
                else {
                    String nameCommand = command.split(" ")[0];
                    HashMap<String,Object> valueForHumanBeing = null;
                    if (infoForCommand.commandNeedElementArg(nameCommand)) {
                        valueForHumanBeing = inputHumanBeingElement();
                    }
                    try {
                        String message = editor.executeCommand(command,valueForHumanBeing);
                        if (message != null) {
                            display(TypeMessage.INFO, message);
                        }
                    } catch (Exception e) {
                            display(TypeMessage.ERROR,"Что-то не так с командой");
                    }
                }
            }
            else {
                display(TypeMessage.ERROR,"Что-то не так с командой");
            }
        }
    }

    /**
     * Выводит сообщение пользователю
     * @param type Тип сообщения
     * @param message Текст сообщения
     */
    @Override
    public abstract void display(TypeMessage type, String message);

    /**
     * Метод который дает пользователю ввести значение поля, так же проверяет значения при вводе.
     * @param field Вводимое поле
     * @return Значение этого поля
     */
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
            String stringValue = inputLine();
            boolean fieldWithoutEmptyLine = field.getAnnotation(HumanBeing.WithoutEmptyLine.class) instanceof HumanBeing.WithoutEmptyLine;
            if(fieldWithoutEmptyLine) {
                while (!checker.checkStringValue(stringValue)) {
                    display(TypeMessage.ERROR, "НЕВЕРНОЕ ЗНАЧЕНИЕ!");
                    display(TypeMessage.INPUT,fieldName + ": ");
                    stringValue = inputLine();
                }
            }
            if (stringValue.equals("")) { return null; }
            else { return stringValue; }
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

    /**
     * Метод вводит все необходимые поля для элемента.
     * @return Hashmap с вводимыми значениями
     */
    public HashMap<String,Object> inputHumanBeingElement(){
        HashMap<String,Object> valueFields = new HashMap<>();
        for (Field field : HumanBeing.class.getDeclaredFields()){
            if( !field.getName().equals("id") && !field.getName().equals("creationDate") ) { valueFields.put(field.getName(),inputField(field)); }
        }
        return valueFields;
    }

    protected String inputFileFromVariableEnvironment(){
        while (true) {
            display(TypeMessage.INPUT, "Введите переменную окружения: ");
            String file = System.getenv().get(inputLine());
            if (file != null) {
                return file;
            }
            display(TypeMessage.ERROR, "Такой переменной окружения нет.");
        }
    }

    protected abstract void createUI();

    protected abstract String inputLine();
}