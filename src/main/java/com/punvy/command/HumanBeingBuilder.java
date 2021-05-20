package com.punvy.command;

import com.punvy.base.Car;
import com.punvy.base.Coordinates;
import com.punvy.base.HumanBeing;
import com.punvy.base.Mood;

import java.util.HashMap;

public class HumanBeingBuilder {

    public HumanBeing buildHumanBeing(HashMap<String,Object> value){
        HumanBeing humanBeing = new HumanBeing((String) value.get("name"), (String) value.get("soundtrackName"), (boolean) value.get("hasToothpick"),
                (Boolean) value.get("realHero"), (Integer) value.get("minutesOfWaiting"), (Coordinates) value.get("coordinates"));

        if(value.containsKey("impactSpeed")) {
            humanBeing.setImpactSpeed((Float) value.get("impactSpeed"));
        }
        if(value.containsKey("mood")) {
            humanBeing.setMood((Mood)value.get("mood"));
        }
        if(value.containsKey("car")) {
            humanBeing.setCar((Car)value.get("car"));
        }
        return humanBeing;
    }
}
