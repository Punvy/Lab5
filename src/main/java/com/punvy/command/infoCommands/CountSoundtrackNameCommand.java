package com.punvy.command.infoCommands;

import com.punvy.command.AbstractCommand;
import com.punvy.command.TypeParametr;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class CountSoundtrackNameCommand extends AbstractCommand {
    public CountSoundtrackNameCommand() {
        super("count_greater_than_soundtrack_name", "вывести количество элементов, значение поля " +
                "soundtrackName которых больше заданного", TypeParametr.SIMPLE);
    }

    @Override
    public HashMap<String, Object> execute() throws FileNotFoundException {
        return null;
    }
}
