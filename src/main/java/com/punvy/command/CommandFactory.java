package com.punvy.command;

import com.punvy.checkers.CommandChecker;
import com.punvy.checkers.InfoForCommand;
import com.punvy.command.CollectionCommands.ClearCommand;
import com.punvy.command.CollectionCommands.RemoveFirstCommand;
import com.punvy.command.CollectionCommands.RemoveIdCommand;
import com.punvy.command.OutCommand.ExitCommand;
import com.punvy.command.OutCommand.SaveCommand;
import com.punvy.command.infoCommands.HelpCommand;
import com.punvy.command.infoCommands.HistoryCommand;
import com.punvy.command.infoCommands.InfoCommand;
import com.punvy.command.infoCommands.ShowCommand;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;

public class CommandFactory {

    private InfoForCommand infoForCommand;

    public CommandFactory(){
        this.infoForCommand = new InfoForCommand();
    }

    public AbstractCommand getCommand(String nameCommand, ArrayDeque collection) {
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
                return new ExitCommand(collection);
            case "remove_first":
                return new RemoveFirstCommand(collection);
        }
        return null;
    }

    public AbstractCommand getCommand(String nameCommand, ArrayDeque collection, String arg) throws Exception {
        switch (nameCommand){
            case "remove_by_id":
                return new RemoveIdCommand(collection, arg);
            case "remove":
        }
        return null;
    }
}
