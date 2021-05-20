package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.HumanBeingBuilder;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class RemoveLowerCommand extends AbstractCommand {
    private HumanBeingBuilder builder;
    private HashMap<String,Object> valueForHumanBeing;

    public RemoveLowerCommand () {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный", TypeParametr.ELEMENT);
    }
    public RemoveLowerCommand(ArrayDeque<HumanBeing> collection, HashMap<String,Object> valueForHumanBeing) throws Exception{
        this();
        setCollection(collection);
        this.valueForHumanBeing = valueForHumanBeing;
        this.builder = new HumanBeingBuilder();
    }

    @Override
    public HashMap<String, Object> execute() {
        HashMap<String,Object> res = new HashMap<>();
        HumanBeing humanBeing = builder.buildHumanBeing(valueForHumanBeing);
        ArrayList<HumanBeing> removeElements = new ArrayList<HumanBeing>();
        for (HumanBeing i : getCollection()) {
            if (i.compareTo(humanBeing) < 0) {
                removeElements.add(i);
            }
        }
        for (HumanBeing i : removeElements) {
            getCollection().remove(i);
        }
        res.put("collection",getCollection());
        res.put("message",null);
        return res;
    }
}
