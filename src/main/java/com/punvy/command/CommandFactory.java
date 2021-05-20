package com.punvy.command;

import com.punvy.base.HumanBeing;
import com.punvy.checkers.CommandChecker;
import com.punvy.checkers.InfoForCommand;
import com.punvy.command.CollectionCommands.*;
import com.punvy.command.OutCommand.ExitCommand;
import com.punvy.command.OutCommand.SaveCommand;
import com.punvy.command.OutCommand.ScriptCommand;
import com.punvy.command.infoCommands.*;
import com.punvy.logic.JsonManager;

import javax.swing.text.Style;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CommandFactory {

    public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection) {
        switch (nameCommand){
            case "help":
                return new HelpCommand(collection);
            case "info":
                return new InfoCommand(collection);
            case "show":
                return new ShowCommand(collection);
            case "clear":
                return new ClearCommand(collection);
            case "exit":
                return new ExitCommand();
            case "remove_first":
                return new RemoveFirstCommand(collection);
        }
        return null;
    }

    public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection, String arg) throws Exception {
        switch (nameCommand){
            case "remove_by_id":
                return new RemoveIdCommand(collection, arg);
            case "remove_any_by_impact_speed":
                return new RemoveImpactSpeedCommand(collection, arg);
            case "count_greater_than_soundtrack_name":
                return new CountSoundtrackNameCommand(collection, arg);
            case "filter_contains_name":
                return new FilterNameCommand(collection, arg);
        }
        return null;
    }

        public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection, HashMap<String,Object> valueForHumanBeing) throws Exception {
        switch (nameCommand){
            case "add":
                return new AddCommand(collection, valueForHumanBeing);
            case "remove_lower":
                return new RemoveLowerCommand(collection, valueForHumanBeing);
        }
        return null;
    }

    public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection, String arg, HashMap<String,Object> valueForHumanBeing) throws Exception {
        switch (nameCommand){
            case "update":
                return new UpdateCommand(collection, valueForHumanBeing, arg);
        }
        return null;
    }

    public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection, JsonManager jsonManager) throws Exception {
        switch (nameCommand){
            case "save":
                return new SaveCommand(collection, jsonManager);
        }
        return null;
    }
    public AbstractCommand getCommand(String nameCommand, ArrayDeque<HumanBeing> collection, PriorityQueue<AbstractCommand> history) throws Exception {
        switch (nameCommand){
            case "history":
                return new HistoryCommand(collection, history);
        }
        return null;
    }

    public AbstractCommand getCommand(String nameCommand, String file) throws Exception {
        switch (nameCommand){
            case "execute_script":
                return new ScriptCommand(file);
        }
        return null;
    }

}
