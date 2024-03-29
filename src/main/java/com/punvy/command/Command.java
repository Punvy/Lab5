package com.punvy.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
@FunctionalInterface
public interface Command {
    HashMap<String, Object> execute() throws IOException;
}
