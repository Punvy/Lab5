package com.punvy.command.infoCommands;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", TypeParametr.NONE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
