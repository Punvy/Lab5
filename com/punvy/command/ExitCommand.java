package com.punvy.command;

public class ExitCommand extends AbstractCommand{
    ExitCommand() {
        setNameCommand("exit");
    }
    @Override
    public String execute() {
        System.exit(1);
        return null;
    }
}
