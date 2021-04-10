package com.punvy.command.OutCommand;

import com.punvy.command.AbstractCommand;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        setNameCommand("exit");
    }
    @Override
    public String execute() {
        System.exit(1);
        return null;
    }
}
