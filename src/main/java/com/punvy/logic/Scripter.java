package com.punvy.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Scripter {
    Path path;

    public void setPath(Path path) {
        this.path = path;
    }

    public List<String> getListCommand() throws IOException {
        return Files.readAllLines(path);
    }
}
