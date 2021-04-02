package com.punvy.base;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

public class HumanBeing {

    public HumanBeing(String name, String soundtrackName, boolean hasToothpick,Boolean realHero,
                      Integer minutesOfWaiting, Coordinates coordinates) {
        this.id = id;
        this.creationDate = new Date(System.currentTimeMillis());
        this.name = name;
        this.soundtrackName = soundtrackName;
        this.hasToothpick = hasToothpick;
        this.realHero = realHero;
        this.minutesOfWaiting = minutesOfWaiting;
        this.coordinates = coordinates;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface AbleBeNull{

    }

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой
    private String soundtrackName; //Поле не может быть null

    private boolean hasToothpick;
    private Boolean realHero; //Поле не может быть null
    private Integer minutesOfWaiting; //Поле не может быть null
    private Coordinates coordinates; //Поле не может быть null

    @AbleBeNull
    private Float impactSpeed; //Поле может быть null
    @AbleBeNull
    private Mood mood; //Поле может быть null
    @AbleBeNull
    private Car car; //Поле может быть null

    public void setImpactSpeed(Float impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}