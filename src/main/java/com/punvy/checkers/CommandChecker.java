package com.punvy.checkers;

import com.punvy.command.CommandFactory;

public class CommandChecker {

    private InfoForCommand infoForCommand;

    public CommandChecker() {
        infoForCommand = new InfoForCommand();
    }

    public Boolean checkCommand(String command){
        String[] partCommands = command.split(" ");
        if (partCommands.length > 2 && partCommands.length < 1) return false;
        String nameCommand = partCommands[0];
        String argCommand = null;
        if (partCommands.length == 2) {
            argCommand = partCommands[1];
        }
        if (infoForCommand.commandNeedSimpleArg(command) && argCommand == null ||
                !infoForCommand.commandNeedSimpleArg(command) && argCommand != null) return false;
        return true;
    }
}
