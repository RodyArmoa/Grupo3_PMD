package com.example.grupo3_app.Topics;

import java.io.Serializable;

public class Listelementtopic implements Serializable {

    public String color;
    public String name;
    public String teacher;
    public String status;


    public Listelementtopic() {
    }

    public Listelementtopic(String color, String name, String teacher, String status) {
        this.color = color;
        this.name = name;
        this.teacher = teacher;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Listelementtopic{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
