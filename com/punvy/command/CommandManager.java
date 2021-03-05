package com.punvy.command;
import java.util.List;
import java.util.Arrays;

public class CommandManager {
    public void executeCommand(String commandWithArgs){
        String command;
        List<String> args = Arrays.asList(commandWithArgs.split(" "));
        if (!args.isEmpty()) {
            command = args.get(0);
            try {
                args.remove(0);
            } catch (Exception e) {

            }
        }
        else {
            command = commandWithArgs;
        }
        if(command.equalsIgnoreCase("exit")) {
            System.out.println("Вы вышли :(");
            new ExitCommand().execute();
        }
        else {
            System.out.println("Что-то не так... Я не знаю такой команды :(");
        }
    }
}
