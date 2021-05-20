package com.punvy.logic;


import com.punvy.base.HumanBeing;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;

public class Editor {
    private ArrayDeque<HumanBeing> collection;
    private JsonManager jsonManager;


    public Editor (String filePath) throws FileNotFoundException {
        this.jsonManager = new JsonManager(filePath);
        collection = jsonManager.inputJson();
    }

    public Boolean checkCommand(String command) {
        return false;
    }


}
