package com.punvy.inter;


import java.util.Scanner;

public class CLI extends AbstractUI{

    Scanner scanner;

    @Override
    public void display(TypeMessage type, String message) {
        if (type.equals(TypeMessage.INPUT)) {
            System.out.print(type.getColor() + message + TypeMessage.INFO.getColor());
        }
        else {
            System.out.println(type.getColor() + message);
        }
        System.out.print(TypeMessage.INFO.getColor());
    }

    @Override
    protected void createUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    protected String inputLine() {
        return scanner.nextLine();
    }
}