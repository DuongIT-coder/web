package com.example.web.enity;

public class Client {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phonenumber;
    private String address;

    public Client() {
    }

    public Client(int id, String name, String email, String password, String phonenumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
