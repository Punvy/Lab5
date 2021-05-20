package com.punvy.command.OutCommand;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.punvy.base.HumanBeing;
import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;
import com.punvy.logic.JsonManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;

public class SaveCommand extends AbstractCommand {

   
   
    public SaveCommand(){
        super("save", " сохранить коллекцию в файл ", TypeParametr.NONE);
    }
    public SaveCommand(ArrayDeque<HumanBeing> collection, JsonManager jsonManager) {
        this();
        setCollection(collection);
        this.jsonManager = jsonManager;
    }

    JsonManager jsonManager;


    @Override
    public HashMap<String, Object> execute() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        file.setWritable(true);
        try {
            writer.writeValue(new FileOutputStream(file), collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }






}
