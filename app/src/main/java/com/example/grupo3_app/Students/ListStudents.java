package com.example.grupo3_app.Students;

import java.io.Serializable;

public class ListStudents implements Serializable {

    public int Id;
    public String Name;
    public String Email;
    public String Surname;
    public int Phone;
    public int Password;

    public ListStudents() {
    }

    public ListStudents(int id, String name, String email, String surname, int phone, int password) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.Surname = surname;
        this.Phone = phone;
        this.Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
