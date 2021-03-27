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
    ArrayList<Field> Fields = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public HumanBeing create() {

        for (int i = 1; i < Fields.size(); i++) {
            Field field = Fields.get(i);
            String nameField = field.getName();
            String value = "";
            while (value.equals("")) {
                System.out.print(nameField + ": ");
                value = scan.nextLine();
                if(nameField.equals("mood")) {
                    Mood mood = null;
                }
                else if(nameField.equals("mood")) {

                }
                else if(nameField.equals("mood")) {

                }
                if(field.getAnnotation(HumanBeing.AbleBeNull.class) instanceof HumanBeing.AbleBeNull) {
                    break;
                }
            }
            if (field.getAnnotation(HumanBeing.AbleBeNull.class) instanceof HumanBeing.AbleBeNull) {
                continue;
            }
            else {
                valueFields.put(nameField, value);
            }
        }
        return null;
    }

    public Creater() {
        Fields.addAll(Arrays.asList(HumanBeing.class.getDeclaredFields()));
    }
}
