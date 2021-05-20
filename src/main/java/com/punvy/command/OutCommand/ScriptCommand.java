package com.punvy.command.OutCommand;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ScriptCommand extends AbstractCommand {
    public ScriptCommand() {
        super("execute_script", "считать и исполнить скрипт из указанного файла." +
                " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме", TypeParametr.SIMPLE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
