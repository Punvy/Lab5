package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.HumanBeingBuilder;
import com.punvy.command.TypeParametr;

import java.util.ArrayDeque;
import java.util.HashMap;

public class AddCommand extends AbstractCommand {
    public AddCommand() {
        super("add", "добавить новый элемент в коллекцию", TypeParametr.ELEMENT);
        this.builder = new HumanBeingBuilder();
    }

    public AddCommand(ArrayDeque<HumanBeing> collection, HashMap<String, Object> valueHumanBeing) {
        this();
        setCollection(collection);
        this.valueHumanBeing = valueHumanBeing;
    }

    public AddCommand(HashMap<String,Object> valueHumanBeing, ArrayDeque collection) {
        this();
        this.builder = new HumanBeingBuilder();
        this.valueHumanBeing = valueHumanBeing;
        setCollection(collection);
    }
    
    HashMap<String,Object> valueHumanBeing;
    HumanBeingBuilder builder;

    @Override
    public HashMap<String, Object> execute() {
        HumanBeing humanBeing = builder.buildHumanBeing(valueHumanBeing);
        getCollection().add(humanBeing);
        HashMap<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("collection", (Object) getCollection());
        hashMap.put("message", null);
        return hashMap;
    }
}