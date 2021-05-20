package com.punvy.command.infoCommands;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class InfoCommand extends AbstractCommand {
    public InfoCommand(){
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", TypeParametr.NONE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
