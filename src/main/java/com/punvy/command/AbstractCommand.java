package com.punvy.command;

import com.punvy.base.HumanBeing;

import java.util.ArrayDeque;

public abstract class AbstractCommand implements Command, Comparable<AbstractCommand>{

    private TypeParametr typeParametr;

    @Override
    public int compareTo(AbstractCommand o) {
        return this.getNameCommand().length() - o.getNameCommand().length();
    }

    @Override
    public String toString() {
        return getNameCommand() + getHelpCommand();
    }

    public String getHelpCommand() { return helpCommand; }

    protected void setHelpCommand(String helpCommand) { this.helpCommand = helpCommand; }

    protected void setTypeParametrs(TypeParametr typeParametr) {
        this.typeParametr = typeParametr;
    }

    public TypeParametr getTypeParametr() {
        return this.typeParametr;
    }

    public String getNameCommand() { return nameCommand; }

    protected void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    public ArrayDeque<HumanBeing>  getCollection() {
        return collection;
    }

    public void setCollection(ArrayDeque<HumanBeing>  collection) {
        this.collection = collection;
    }
    
    private String nameCommand;
    private String helpCommand;
    private ArrayDeque<HumanBeing> collection;

    public AbstractCommand(String nameCommand, String helpCommand, TypeParametr typeParametr){
        setNameCommand(nameCommand);
        setHelpCommand(helpCommand);
        setTypeParametrs(typeParametr);
    }

    public AbstractCommand(String nameCommand, String helpCommand, TypeParametr typeParametr, ArrayDeque<HumanBeing> collection) {
        this(nameCommand,helpCommand,typeParametr);
        this.collection = collection;
    }
}
