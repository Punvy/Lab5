package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.util.ArrayDeque;
import java.util.HashMap;

public class RemoveFirstCommand extends AbstractCommand {
    public RemoveFirstCommand() {
        super("remove_first", "удалить первый элемент из коллекции", TypeParametr.NONE);
    }

    public RemoveFirstCommand(ArrayDeque<HumanBeing> collection) {
        super("remove_first", "удалить первый элемент из коллекции", TypeParametr.NONE);
        setCollection(collection);
    }

    @Override
    public HashMap<String, Object> execute() {
        HashMap<String,Object> res = new HashMap<>();
        getCollection().removeFirst();
        res.put("collection",getCollection());
        res.put("message",null);
        return res;
    }
}
