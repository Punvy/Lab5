package com.punvy.logic;


import com.punvy.base.HumanBeing;
import com.punvy.checkers.CheckerValue;
import com.punvy.checkers.CommandChecker;
import com.punvy.command.AbstractCommand;
import com.punvy.command.Command;
import com.punvy.command.CommandFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Editor {
    private ArrayDeque<HumanBeing> collection;
    private JsonManager jsonManager;
    private CommandChecker commandChecker;
    private CommandFactory commandFactory;
    private PriorityQueue<AbstractCommand> commandHistory;

    public Editor (String filePath) throws IOException {
        this.jsonManager = new JsonManager(filePath);
        this.commandChecker = new CommandChecker();
        this.commandFactory = new CommandFactory();
        this.commandHistory = new PriorityQueue<>();
        collection = jsonManager.inputJson();
    }

    public Boolean checkCommand(String command) {
        return commandChecker.checkCommand(command);
    }

    public String executeCommand(String command, HashMap<String,Object> valueForHumanBeing) throws Exception {
        String nameCommand = null;
        String argCommand = null;
        if (command.split(" ").length == 2) {
            nameCommand = command.split(" ")[0];
            argCommand = command.split(" ")[1];
        }
        else { nameCommand = command; }
        AbstractCommand abstractCommand = null;
        if (command.equals("save")) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, jsonManager);
        }
        else if (command.equals("history")) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, commandHistory);
        }
        else if (valueForHumanBeing == null && argCommand == null) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection);
        }
        else if (valueForHumanBeing == null && argCommand != null) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, argCommand);
        }
        else if (valueForHumanBeing != null && argCommand == null) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, valueForHumanBeing);
        }
        else if (valueForHumanBeing != null && argCommand != null) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, argCommand, valueForHumanBeing);
        }
        else if (command.equals("save")) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, jsonManager);
        }
        else if (command.equals("history")) {
            abstractCommand = commandFactory.getCommand(nameCommand, collection, commandHistory);
        }
        HashMap<String,Object> res = abstractCommand.execute();
        collection = (ArrayDeque<HumanBeing>) res.get("collection");
        addHistory(abstractCommand);
        return (String) res.get("message");
    }

    public void addHistory(AbstractCommand command){
        if (commandHistory.size() >= 6) {
            commandHistory.poll();
        }
        commandHistory.add(command);
    }
}
