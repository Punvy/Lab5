package com.punvy.command.infoCommands;

import com.punvy.base.HumanBeing;
import com.punvy.base.StringComparator;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterNameCommand extends AbstractCommand {
    private String nameSub;

    public FilterNameCommand() {
        super("filter_contains_name", "вывести элементы, значение поля name которых содержит заданную подстроку", TypeParametr.SIMPLE);
    }
    public FilterNameCommand(ArrayDeque<HumanBeing> collection, String arg) throws Exception{
        this();
        setCollection(collection);
        this.nameSub = arg;
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        ArrayList<HumanBeing> containsSubName = new ArrayList<>();
        for (HumanBeing i : getCollection()) {
            if (i.getName().contains(nameSub)) {
                containsSubName.add(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (HumanBeing i : containsSubName) {
            stringBuilder.append(String.format(i.toString() + "%n"));
        }
        res.put("collection",getCollection());
        res.put("message", stringBuilder.toString());
        return res;
    }
}
