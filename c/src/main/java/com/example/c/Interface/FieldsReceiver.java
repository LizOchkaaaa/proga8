package com.example.c.Interface;


import org.example.models.Coordinates;
import org.example.models.FormOfEducation;
import org.example.models.Person;
import org.example.models.Semester;

public interface FieldsReceiver {

    /**
     * Method get group's name
     */
    String getName();

    /**
     * Method get group coordinates
     */
    Coordinates getCoordinates();

    /**
     * Method get students count in group
     */
    Integer getStudentsCount();

    /**
     * Method get form of group's education
     */
    FormOfEducation getFormOfEducation();

    /**
     * Method get group's semester
     */
    Semester getSemester();

    /**
     * Method get group admin
     */
    Person getGroupAdmin();
}
