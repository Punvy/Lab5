package com.punvy.command.OutCommand;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.util.HashMap;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)", TypeParametr.NONE);
    }
    @Override
    public HashMap<String, Object> execute() {
        System.exit(1);
        return null;
    }
}
