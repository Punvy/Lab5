package com.punvy.checkers;

public class CommandChecker {

    private InfoForCommand infoForCommand;

    public CommandChecker() {
        infoForCommand = new InfoForCommand();
    }

    public Boolean checkCommand(String command){
        String[] partCommands = command.split(" ");
        String nameCommand = partCommands[0];
        Integer countCommandPart = partCommands.length;
        if (infoForCommand.isCommand(nameCommand){
            if (countCommandPart == 2 && )
        }
        return false;
    }
}
