package com.punvy.command;

public abstract class AbstractCommand implements Command{


    @Override
    public String toString() {
        return getNameCommand() + getHelpCommand();
    }

    public String getHelpCommand() { return helpCommand; }

    protected void setHelpCommand(String helpCommand) { this.helpCommand = helpCommand; }

    protected String getNameCommand() { return nameCommand; }

    protected void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    private String nameCommand;
    private String helpCommand;
}
