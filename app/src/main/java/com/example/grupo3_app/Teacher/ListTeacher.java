package com.example.grupo3_app.Teacher;

import com.example.grupo3_app.Topics.Listelementtopic;

import java.io.Serializable;

public class ListTeacher extends Listelementtopic implements Serializable{
    public Integer id;
    public String color;
    public String name;
    public String surname;
    public String asignatura;
    public String status;
    public String Opinion;
    public String location;

    public ListTeacher() {
    }

    public ListTeacher(String color, String name, String asignatura, String status, String opinion) {
        this.color = color;
        this.name = name;
        this.asignatura = asignatura;
        this.status = status;
        this.Opinion = opinion;
    }

    public ListTeacher(Integer id, String name, String surname, String location) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = location;
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

    public String getOpinion() {
        return Opinion;
    }

    public void setOpinion(String opinion) {
        Opinion = opinion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ListTeacher{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", asignatura='" + asignatura + '\'' +
                ", status='" + status + '\'' +
                ", Opinion='" + Opinion + '\'' +
                '}';
    }
}
