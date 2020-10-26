package com.kpz;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class Student implements Cloneable, Serializable {

    public Student(String name, int age, Date dateOfBirth) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    @Override
    public int hashCode() {
        return name.hashCode() * age * dateOfBirth.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null)
            return false;

        if (getClass() != object.getClass())
            return false;

        Student student = (Student) object;

        return Objects.equals(age, student.age)
                && Objects.equals(name, student.name)
                && student.dateOfBirth.equals(dateOfBirth);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return String.format("Name: %s; Age: %d; Date of birth: %s",
                name, age, dateFormat.format(dateOfBirth));
    }

    private final String name;
    private final int age;
    private final Date dateOfBirth;
}