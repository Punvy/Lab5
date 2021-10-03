package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.HumanBeingBuilder;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class UpdateCommand extends AbstractCommand {
    private HumanBeingBuilder builder;
    private HashMap<String,Object> valueForHumanBeing;
    private int id;

    public UpdateCommand() {
        super("update", "обновить значение элемента коллекции, id которого равен заданному", TypeParametr.SIMPLENELEMENT);
    }

    public UpdateCommand(ArrayDeque<HumanBeing> collection, HashMap<String,Object> valueForHumanBeing, String arg) {
        this();
        setCollection(collection);
        this.builder = new HumanBeingBuilder();
        this.valueForHumanBeing = valueForHumanBeing;
        this.id = Integer.parseInt(arg);
    }
    @Override
    public HashMap<String, Object> execute() {
        HashMap<String,Object> res = new HashMap<>();
        HumanBeing humanBeing = builder.buildHumanBeing(valueForHumanBeing);
        HumanBeing updateElement = null;
        for (HumanBeing i : getCollection()) {
            if (i.getId().equals(id)) {
                i.setName(humanBeing.getName());
                i.setSoundtrackName(humanBeing.getSoundtrackName());
                i.setHasToothpick(humanBeing.isHasToothpick());
                i.setRealHero(humanBeing.getRealHero());
                i.setMinutesOfWaiting(humanBeing.getMinutesOfWaiting());
                i.setCoordinates(humanBeing.getCoordinates());
                i.setImpactSpeed(updateElement.getImpactSpeed());
                i.setMood(updateElement.getMood());
                i.setCar(humanBeing.getCar());
            }
        }

        res.put("collection",getCollection());
        res.put("message",null);
        return res;
    }
}
