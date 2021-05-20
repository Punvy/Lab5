package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class RemoveIdCommand extends AbstractCommand {
    private int id;

    public RemoveIdCommand() {
        super("remove_by_id", "удалить элемент из коллекции по его id", TypeParametr.SIMPLE);
    }

    public RemoveIdCommand(ArrayDeque<HumanBeing> collection, String arg) throws Exception{
        super("remove_by_id", "удалить элемент из коллекции по его id", TypeParametr.SIMPLE);
        setCollection(collection);
        this.id = Integer.valueOf(arg);
    }

    @Override
    public HashMap<String, Object> execute(){
        HashMap<String,Object> res = new HashMap<>();
        HumanBeing removeElement = null;
        for (HumanBeing i : getCollection()) {
            if (i.getId().equals(id)) {
                removeElement = i;
            }
        }
        if (removeElement != null) {
            getCollection().remove(removeElement);
        }
        res.put("collection",getCollection());
        res.put("message",null);
        return res;
    }
}
