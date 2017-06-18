package com.example.rishi.firebaseapplication;

/**
 * Created by rishi on 6/17/2017.
 */

public class Contact {
    private String Name;
    private Long Phone;

    public Contact(){

    }

    public Contact(String name, Long phone) {
        this.Name = name;
        this.Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return getName() +" "+getPhone();
    }
}
