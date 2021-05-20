package com.punvy.command.infoCommands;

import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HistoryCommand extends AbstractCommand {
    private PriorityQueue<AbstractCommand> history;
    public HistoryCommand() {
        super("history", "вывести последние 6 команд (без их аргументов)", TypeParametr.NONE);
    }

    public HistoryCommand(ArrayDeque<HumanBeing> collection, PriorityQueue<AbstractCommand> historyCommand) {
        this();
        setCollection(collection);
        history = historyCommand;
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        HashMap<String,Object> res = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (AbstractCommand command : history) {
            stringBuilder.append(String.format(command.getNameCommand() + "%n"));
        }
        res.put("collection",getCollection());
        res.put("message", stringBuilder.toString());
        return res;
    }
}
