package com.punvy.command.CollectionCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class RemoveImpactSpeedCommand extends AbstractCommand {
    private Float impactSpeed;

    public RemoveImpactSpeedCommand() {
        super("remove_any_by_impact_speed", "удалить из коллекции один элемент, значение поля impactSpeed которого эквивалентно заданному", TypeParametr.SIMPLE);
    }
    public RemoveImpactSpeedCommand(ArrayDeque<HumanBeing> collection, String arg) throws Exception{
        this();
        setCollection(collection);
        this.impactSpeed = Float.valueOf(arg);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        HumanBeing removeElement = null;
        for (HumanBeing i : getCollection()) {
            if (i.getImpactSpeed() != null && i.getImpactSpeed().equals(impactSpeed)) {
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
