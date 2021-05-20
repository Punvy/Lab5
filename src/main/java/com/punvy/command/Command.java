package com.punvy.command;

import java.io.FileNotFoundException;
import java.util.HashMap;

public interface Command {
    HashMap<String, Object> execute() throws FileNotFoundException;
}
