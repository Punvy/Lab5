package com.punvy.command;

public abstract class AbstractCommand implements Command{


    @Override
    public String toString() {
        return nameCommand;
    }

    public void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    private String nameCommand;

}
