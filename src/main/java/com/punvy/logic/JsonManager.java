package com.punvy.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.punvy.base.HumanBeing;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;

public class JsonManager {

    private Gson json = new GsonBuilder().setPrettyPrinting().create();
    private JsonReader jsonReader;
    private Type listType;
    private BufferedWriter bufferedWriter;

    public JsonManager(String filePath) throws FileNotFoundException {
        this.jsonReader = new JsonReader(new FileReader(filePath));
        this.listType = new TypeToken<ArrayDeque<HumanBeing>>(){}.getType();
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
    }

    public ArrayDeque<HumanBeing> inputJson(){
        ArrayDeque<HumanBeing> arrayDeque = (ArrayDeque<HumanBeing>) json.fromJson(jsonReader, listType);
        if(arrayDeque == null){
            return new ArrayDeque<HumanBeing>();
        }
        return arrayDeque;
    }

    public void outputJson(ArrayDeque<HumanBeing> arrayDeque){
        String jsonString = json.toJson(arrayDeque);

        try {
			bufferedWriter.append(jsonString);
            bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
