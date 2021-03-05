package com.punvy.command;

import com.punvy.base.HumanBeing;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Creater {
    public HumanBeing create() {
        Scanner scan = new Scanner(System.in);
        Class classHuman = HumanBeing.class;
        for (Field field : classHuman.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        return null;
    }
}
