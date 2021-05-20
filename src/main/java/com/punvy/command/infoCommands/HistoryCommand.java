package com.punvy.command.infoCommands;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class HistoryCommand extends AbstractCommand {
    public HistoryCommand() {
        super("history", "вывести последние 6 команд (без их аргументов)", TypeParametr.NONE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
