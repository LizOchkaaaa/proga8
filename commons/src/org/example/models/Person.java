package org.example.models;

import org.example.annotation.Complex;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class Person implements Serializable {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Date birthday; //Поле не может быть null
    private Integer weight; //Поле может быть null, Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    @Complex
    private Color hairColor; //Поле не может быть null

    private String character;

    public Person(){}
    public Person(String name , Date birthday , Integer weight , String passportID , Color hairColor) {
        this.name = name;
        this.weight = weight;
        this.birthday = birthday;
        this.passportID = passportID;
        this.hairColor = hairColor;
    }
    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPassportID() {
        return passportID;
    }

    public int compareTo(Person o) {
        if (o.getName().compareTo(o.getName()) != 0 ) return o.getName().compareTo(this.getName());
        if (o.getWeight() - this.weight != 0) return this.getWeight() - this.weight;
        if (o.getPassportID().compareTo(this.getPassportID()) != 0 ) return o.getPassportID().compareTo(this.getPassportID());
        return 0;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", birthday=" + birthday + ", weight="
                + weight + ", passportID=" + passportID + ", hairColor=" + hairColor
                + "]";
    }

    public String getCharacter() {
        return character;
    }
}
