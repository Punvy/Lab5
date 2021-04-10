package com.punvy.inter;


import java.util.Scanner;

public class CLI extends AbstractUI{

    Scanner scanner;

    @Override
    public void display(TypeMessage type, String message) {
        if (type.equals(TypeMessage.INPUT)) {
            System.out.print(type.getColor() + message);
        }
        else {
            System.out.println(type.getColor() + message);
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
