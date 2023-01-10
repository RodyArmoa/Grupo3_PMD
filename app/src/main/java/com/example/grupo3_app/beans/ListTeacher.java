package com.example.grupo3_app.beans;

import java.io.Serializable;

public class ListTeacher implements Serializable {

    public String color;
    public String name;
    public String asignatura;
    public String status;

    public ListTeacher() {
    }

    public ListTeacher(String color, String name, String asignatura, String status) {
        this.color = color;
        this.name = name;
        this.asignatura = asignatura;
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

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
