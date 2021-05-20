package com.punvy.command.infoCommands;

import com.punvy.base.HumanBeing;
import com.punvy.base.StringComparator;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;

public class CountSoundtrackNameCommand extends AbstractCommand {
    private StringComparator comparator;
    private String soundtrackName;

    public CountSoundtrackNameCommand() {
        super("count_greater_than_soundtrack_name", "вывести количество элементов, значение поля " +
                "soundtrackName которых больше заданного", TypeParametr.SIMPLE);
    }
    public CountSoundtrackNameCommand(ArrayDeque<HumanBeing> collection, String arg) throws Exception{
        this();
        setCollection(collection);
        comparator = new StringComparator();
        this.soundtrackName = arg;
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        Integer count = 0;
        for (HumanBeing humanBeing :getCollection()) {
            if (comparator.compare(humanBeing.getSoundtrackName(), soundtrackName) > 0) {
                count++;
            }
        }
        res.put("collection",getCollection());
        res.put("message", "Кол-во элементов выше заданного: " + count.toString());
        return res;
    }
}
