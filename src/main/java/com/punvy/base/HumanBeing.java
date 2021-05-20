package com.punvy.base;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.Objects;

public class HumanBeing implements Comparable<HumanBeing>{

    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", name='" + name + '\'' +
                ", soundtrackName='" + soundtrackName + '\'' +
                ", hasToothpick=" + hasToothpick +
                ", realHero=" + realHero +
                ", minutesOfWaiting=" + minutesOfWaiting +
                ", coordinates=" + coordinates +
                ", impactSpeed=" + impactSpeed +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }

    public HumanBeing(String name, String soundtrackName, boolean hasToothpick, Boolean realHero,
                      Integer minutesOfWaiting, Coordinates coordinates) {
        this.creationDate = new Date(System.currentTimeMillis());
        this.id = (int) creationDate.getTime() + name.length();
        if(soundtrackName != null) {
            this.id += soundtrackName.length();
        }
        if (id < 0) {
            this.id = -this.id;
        }
        this.name = name;
        this.soundtrackName = soundtrackName;
        this.hasToothpick = hasToothpick;
        this.realHero = realHero;
        this.minutesOfWaiting = minutesOfWaiting;
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return hasToothpick == that.hasToothpick && Objects.equals(id, that.id) && Objects.equals(creationDate, that.creationDate) && Objects.equals(name, that.name) && Objects.equals(soundtrackName, that.soundtrackName) && Objects.equals(realHero, that.realHero) && Objects.equals(minutesOfWaiting, that.minutesOfWaiting) && Objects.equals(coordinates, that.coordinates) && Objects.equals(impactSpeed, that.impactSpeed) && mood == that.mood && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, name, soundtrackName, hasToothpick, realHero, minutesOfWaiting, coordinates, impactSpeed, mood, car);
    }

    @Override
    public int compareTo(HumanBeing o) {
        return this.id - o.getId();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface AbleBeNull{  }
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface WithoutEmptyLine{ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @WithoutEmptyLine
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public Integer getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(Integer minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Float getImpactSpeed() {
        return impactSpeed;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

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