package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class ClearCommand extends AbstractCommand {
    public ClearCommand() {
        super("clear", "очистить коллекцию", TypeParametr.NONE);
    }

    public ClearCommand(ArrayDeque<HumanBeing> collection) {
        this();
        setCollection(collection);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        getCollection().clear();
        res.put("collection",getCollection());
        res.put("message",null);
        return res;
    }
}
