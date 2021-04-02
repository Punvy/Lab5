package com.punvy.command;

import com.punvy.base.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Creater {
    HashMap<String, String> valueFields = new HashMap<>();
    ArrayList<Field> fields = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public HumanBeing createHumanBeing() {

        for(Field field : fields) {
            String fieldName = field.getName();
            Class fieldType = field.getType();
            boolean fieldAbleBeNull = field.getAnnotation(HumanBeing.AbleBeNull.class) instanceof HumanBeing.AbleBeNull;

            String inputLine = fieldName;

            if (fieldAbleBeNull) {
                final String RESET = "\033[0m";  // Text Reset
                final String RED = "\033[0;31m";     // RED

                System.out.printf("%s(%s) %s%n%s", "Это поле", fieldName, "опционально. Y - продолжить ввод поля, " +
                                "N - пропустить ввод этого поля.", "Введите(Y/N): ");
                String cont = scan.nextLine();
                while (!cont.equalsIgnoreCase("y")) {
                    if (cont.equalsIgnoreCase("n")) { break; }
                    System.out .println(RED + "Некорректное значение!");
                    System.out.print(RESET + "Введите(Y/N): ");
                    cont = scan.nextLine();
                }
                if (cont.equalsIgnoreCase("n")) { continue; }
            }

            if (fieldType.equals(Boolean.class)) {

            }
        }

        return null;
    }

    public Creater() {
        fields.addAll(Arrays.asList(HumanBeing.class.getDeclaredFields()));
    }
}
