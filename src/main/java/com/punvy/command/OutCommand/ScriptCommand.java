package com.punvy.command.OutCommand;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ScriptCommand extends AbstractCommand {
    private String file;
    public ScriptCommand() {
        super("execute_script", "считать и исполнить скрипт из указанного файла." +
                " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме", TypeParametr.SIMPLE);
    }

    public ScriptCommand(String file) throws FileNotFoundException {
        this();
        this.file = file;
    }

    @Override
    public HashMap<String, Object> execute() throws IOException {
        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String command;
        HashMap<String, Object> res = new HashMap<>();
        ArrayList arrayCommands = new ArrayList();
        while ((command = br.readLine()) != null) {
            arrayCommands.add(command);
        }
        res.put("commands", arrayCommands);
        return res;
    }
}
