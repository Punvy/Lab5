package com.punvy.checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckerCommand {
    private List<String> withoutArgsCommands = Arrays.asList(new String[]{"help", "info", "show", "clear", "save", "exit", "remove_first", "history"});

    private List<String> needElementArgCommands = Arrays.asList(new String[]{"add", "update", "remove_lower"});

    private List<String> needSimpleArgCommands = Arrays.asList(new String[]{"update", "remove_by_id", "execute_script", "remove_any_by_impact_speed",
            "count_greater_than_soundtrack_name", "filter_contains_name"});

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