package org.example.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

public class StudyGroup implements Comparable<StudyGroup>, Serializable {
    private Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null

    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Integer studentsCount; //Значение поля должно быть больше 0


    private FormOfEducation formOfEducation; //Поле не может быть null

    private Semester semesterEnum; //Поле может быть null

    private Person groupAdmin; //Поле не может быть null
    private String author;

    public StudyGroup() {
    }


    public StudyGroup(Integer id, String name, Coordinates coordinates, Date creationDate, Integer studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin, String author) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.groupAdmin = groupAdmin;
        this.semesterEnum = semesterEnum;
        this.author = author;
    }

    public StudyGroup(Integer id, String name, Coordinates coordinates, Semester semester,
                      Integer studentsCount, FormOfEducation formOfEducation, Person groupAdmin) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.semesterEnum = semester;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.groupAdmin = groupAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public Person getPerson() {
        return groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup o) {
        if (o.getName().compareTo(this.name) != 0) return o.getName().compareTo(this.name);
        if (o.getPerson().compareTo(this.groupAdmin) != 0) return o.getPerson().compareTo(this.groupAdmin);
        if (o.getFormOfEducation().compareTo(this.formOfEducation) != 0)
            return o.getFormOfEducation().compareTo(this.formOfEducation);
        if (o.getCoordinates().compareTo(this.coordinates) != 0) return o.getCoordinates().compareTo(this.coordinates);
        if (o.getStudentsCount() - this.studentsCount != 0) return o.getStudentsCount() - this.studentsCount;
        return 0;
    }

    @Override
    public String toString() {
        return "StudyGroup [id=" + id + ", name=" + name + ", coordinates=" + coordinates + ", creationDate="
                + creationDate + ", studentsCount=" + studentsCount + ", formOfEducation=" + formOfEducation
                + ", semesterEnum=" + semesterEnum + ", groupAdmin=" + groupAdmin + "author=" + author + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, studentsCount, formOfEducation, semesterEnum, groupAdmin);
    }


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!(otherObject instanceof StudyGroup)) return false;

        StudyGroup other = (StudyGroup) otherObject;

        if (((this.getFormOfEducation() == null) && (other.getFormOfEducation() != null))
                || ((this.getFormOfEducation() != null) && (other.getFormOfEducation() == null))) {
            return false;
        }

        return (this.getName().equals(other.getName())
                && this.getCoordinates().equals(other.getCoordinates())
                && this.getStudentsCount().equals(other.getStudentsCount())
                && ((this.getFormOfEducation() == null && other.getFormOfEducation() == null) ||
                this.getFormOfEducation().equals(other.getFormOfEducation()))
                && this.getSemesterEnum().equals(other.getSemesterEnum())
                && this.getGroupAdmin().getName().equals(other.getGroupAdmin().getName())
                && this.getGroupAdmin().getWeight().equals(other.getGroupAdmin().getWeight())
                && this.getGroupAdmin().getHairColor().equals(other.getGroupAdmin().getHairColor()));
    }

    public StudyGroup setId(int parseInt) {
        this.id = parseInt;
        return this;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

}