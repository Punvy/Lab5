package com.punvy.command.infoCommands;

import com.punvy.checkers.InfoForCommand;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;

public class HelpCommand extends AbstractCommand {

    List<AbstractCommand> commands;

    public HelpCommand() {
        super("help", " вывести справку по доступным командам", TypeParametr.NONE);
        commands = new InfoForCommand().getAllCommand();
    }

    public HelpCommand(ArrayDeque collection) {
        super("help", " вывести справку по доступным командам", TypeParametr.NONE, collection);
        commands = new InfoForCommand().getAllCommand();
    }
    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        for (AbstractCommand command : commands) {
            stringBuilder.append(command.getNameCommand() + " - " + command.getHelpCommand());
        }
        return null;
    }
}
