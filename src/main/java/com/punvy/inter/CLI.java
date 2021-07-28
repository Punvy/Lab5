package com.punvy.inter;


import java.util.Scanner;

public class CLI extends AbstractUI{

    Scanner scanner;

    @Override
    public void display(TypeMessage type, String message) {
        System.out.print(type.getColor() + message + TypeMessage.INFO.getColor());
        if (type.equals(TypeMessage.ERROR)) {
            System.out.println();
        }
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