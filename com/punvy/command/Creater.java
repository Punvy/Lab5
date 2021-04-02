package com.punvy.command;

import com.punvy.base.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Creater {
    HashMap<String, Object> valueFields = new HashMap<>();
    ArrayList<Field> fields = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public final String RESET = "\033[0m";  // Text Reset
    public final String RED = "\033[0;31m";     // RED

    public HumanBeing createHumanBeing() {

        for(Field field : fields) {
            String fieldName = field.getName();
            Class fieldType = field.getType();

            boolean fieldAbleBeNull = field.getAnnotation(HumanBeing.AbleBeNull.class) instanceof HumanBeing.AbleBeNull;

            if (fieldAbleBeNull) {
                System.out.printf("%s(%s) %s%n%s", "Это поле", fieldName, "опционально. Y - ввести поле, " +
                                "N - пропустить ввод поля.", "Введите(Y/N): ");
                String cont = scan.nextLine();
                while (!cont.equalsIgnoreCase("y")) {
                    if (cont.equalsIgnoreCase("n")) { break; }
                    System.out .println(RED + "Некорректное значение!");
                    System.out.print(RESET + "Введите(Y/N): ");
                    cont = scan.nextLine();
                }
                if (cont.equalsIgnoreCase("n")) { continue; }
            }
            if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
                System.out.printf("%s %s", fieldName , "(Возможные значение: TRUE/FALSE): ");
                valueFields.put(fieldName,creatBool());
            }
            if (fieldType.equals(Integer.class)) {
                System.out.printf("%s %s", fieldName , "(Возможные значение целые числа" +
                        "от -2147483648 до 2147483647): ");
                valueFields.put(fieldName,creatInteger());
            }
            
        }

        return null;
    }

    private boolean creatBool() {
        String boolString = scan.nextLine();
        while (!boolString.equalsIgnoreCase("true") && !boolString.equalsIgnoreCase("false")) {
            System.out.println(RED + "НЕВЕРНОЕ ЗНАЧЕНИЕ");
            System.out.print(RESET + "Введите(TRUE/FALSE): ");
            boolString = scan.nextLine();
        }
        return Boolean.valueOf(boolString);
    }

    private int creatInteger() {
        String intString = scan.nextLine();
        boolean isInteger = false;
        while (!isInteger) {
            try {
                Integer.valueOf(intString);
                isInteger = true;
            }catch (Exception e){
                System.err.println("НЕВЕРНОЕ ЗНАЧЕНИЕ");
                System.out.print("Введите(от -2147483648 до 2147483647): ");
                intString = scan.nextLine();
            }
        }
        return Integer.valueOf(intString);
    }

    public Creater() {
        for(Field field : HumanBeing.class.getDeclaredFields()) {
            if(!field.getName().equals("id") && !field.getName().equalsIgnoreCase("creationDate")) {
                fields.add(field);
            }
        }
    }
}
