package com.punvy.base;

public class HumanBeing {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Float impactSpeed; //Поле может быть null
    private String soundtrackName; //Поле не может быть null
    private Integer minutesOfWaiting; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null
    private Coordinates coordinates; //Поле не может быть null

    public HumanBeing() {
    	
    }
}