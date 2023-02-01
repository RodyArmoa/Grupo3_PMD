package com.example.grupo3_app.Topics;

public class Topics {

    private int id;
    private int id_teacher;
    private String name;

    public Topics() {
    }

    public Topics(int id, int id_teacher, String name) {
        this.id = id;
        this.id_teacher = id_teacher;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "id=" + id +
                ", id_teacher=" + id_teacher +
                ", name='" + name + '\'' +
                '}';
    }
}
