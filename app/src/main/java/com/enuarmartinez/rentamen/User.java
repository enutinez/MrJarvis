package com.enuarmartinez.rentamen;

public class User {
    private String Name, Lastname, age, Gender, Cellphone;

    public User(String name, String lastname, String age, String gender, String cellphone) {
        Name = name;
        Lastname = lastname;
        this.age = age;
        Gender = gender;
        Cellphone = cellphone;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public void setCellphone(String cellphone) {
        Cellphone = cellphone;
    }

}
