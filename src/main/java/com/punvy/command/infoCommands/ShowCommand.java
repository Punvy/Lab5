package com.punvy.command.infoCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", TypeParametr.NONE);
    }

    public ShowCommand(ArrayDeque<HumanBeing> collection){
        this();
        setCollection(collection);
    }


    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (HumanBeing i : getCollection()) {
            stringBuilder.append(String.format(i.toString() + "%n"));
        }
        res.put("collection",getCollection());
        res.put("message", stringBuilder.toString());
        return res;
    }
}
