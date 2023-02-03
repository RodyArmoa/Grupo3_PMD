package com.example.grupo3_app.User;

public class User {
    private static final long serialVersionUID = -578858462965845200L;

    private Integer id;
    private String name;
    private String surname;
    private String location;
    private String email;
    private String phone;
    private String shift;
    private String description;
    private String favorites;

//    public User(Long id, String name, String surname, String location, String email, String phone, String shift, String description, String favorites) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.location = location;
//        this.email = email;
//        this.phone = phone;
//        this.shift = shift;
//        this.description = description;
//        this.favorites = favorites;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
}
