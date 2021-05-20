package com.punvy.command.infoCommands;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class FilterNameCommand extends AbstractCommand {
    public FilterNameCommand() {
        super("filter_contains_name ", "вывести элементы, значение поля name которых содержит заданную подстроку", TypeParametr.SIMPLE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
