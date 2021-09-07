package com.punvy.command.infoCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class InfoCommand extends AbstractCommand {
    public InfoCommand() {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", TypeParametr.NONE);
    }

    public InfoCommand(ArrayDeque<HumanBeing> collection) {
        this();
        setCollection(collection);
    }
    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        String message = String.format("%s %s %n%s %s%n",
                "Размер:",getCollection().size(),"Тип:", getCollection().getClass().toString());
        res.put("collection",getCollection());
        res.put("message", message);
        return res;
    }
}
