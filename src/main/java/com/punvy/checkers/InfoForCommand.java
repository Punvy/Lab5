package com.punvy.checkers;

import com.punvy.command.AbstractCommand;
import com.punvy.command.CollectionCommands.*;
import com.punvy.command.OutCommand.ExitCommand;
import com.punvy.command.OutCommand.SaveCommand;
import com.punvy.command.OutCommand.ScriptCommand;
import com.punvy.command.TypeParametr;
import com.punvy.command.infoCommands.*;

import java.util.ArrayList;
import java.util.List;

public class InfoForCommand {
    public InfoForCommand(){
        commands = addCommandsToList(commands);
        setArgsLists();
    }

    public List<AbstractCommand> getAllCommand() {
        return commands;
    }

    private List<AbstractCommand> commands = new ArrayList<>();

    private List<String> withoutArgsCommands = new ArrayList<>();

    private List<String> needElementArgCommands = new ArrayList<>();

    private List<String> needSimpleArgCommands = new ArrayList<>();

    private List<AbstractCommand> addCommandsToList(List list){
        list.add(new HelpCommand());
        list.add(new InfoCommand());
        list.add(new ShowCommand());
        list.add(new AddCommand());
        list.add(new UpdateCommand());
        list.add(new RemoveIdCommand());
        list.add(new ClearCommand());
        list.add(new SaveCommand());
        list.add(new ScriptCommand());
        list.add(new ExitCommand());
        list.add(new RemoveFirstCommand());
        list.add(new RemoveLowerCommand());
        list.add(new HistoryCommand());
        list.add(new RemoveImpactSpeedCommand());
        list.add(new CountSoundtrackNameCommand());
        list.add(new FilterNameCommand());
        return list;
    }

    private void setArgsLists(){
        for (AbstractCommand command : commands){
            if (command.getTypeParametr().equals(TypeParametr.ELEMENT) || command.getTypeParametr().equals(TypeParametr.SIMPLENELEMENT)) {
                needElementArgCommands.add(command.getNameCommand());
            }
            if (command.getTypeParametr().equals(TypeParametr.SIMPLE) || command.getTypeParametr().equals(TypeParametr.SIMPLENELEMENT)) {
                needSimpleArgCommands.add(command.getNameCommand());
            }
            if (command.getTypeParametr().equals(TypeParametr.NONE)) {
                withoutArgsCommands.add(command.getNameCommand());
            }
        }
    }

    public boolean isCommand(String rawCommand){
        return withoutArgsCommands.contains(rawCommand) || needElementArgCommands.contains(rawCommand) || needSimpleArgCommands.contains(rawCommand);
    }
    public boolean commandNeedElementArg(String rawCommand){
        return needElementArgCommands.contains(rawCommand);
    }
    public boolean commandNeedSimpleArg(String rawCommand){
        return needSimpleArgCommands.contains(rawCommand);
    }
}