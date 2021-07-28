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

    private Gson builder = new GsonBuilder().setPrettyPrinting().create();
    private JsonReader reader;
    private Type listType;
    String filePath;
    private FileWriter writer;

    public JsonManager(String filePath) throws IOException {
        this.reader = new JsonReader(new FileReader(filePath));
        this.listType = new TypeToken<ArrayDeque<HumanBeing>>(){}.getType();
        this.filePath = filePath;
    }

    public ArrayDeque<HumanBeing> inputJson(){
        ArrayDeque<HumanBeing> arrayDeque = (ArrayDeque<HumanBeing>) builder.fromJson(reader, listType);
        if(arrayDeque == null){
            return new ArrayDeque<HumanBeing>();
        }
        return arrayDeque;
    }

    public void outputJson(ArrayDeque<HumanBeing> arrayDeque) throws IOException {
        this.writer = new FileWriter(filePath);
        String jsonString = builder.toJson(arrayDeque);
        try {
			writer.write(jsonString);
            writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
