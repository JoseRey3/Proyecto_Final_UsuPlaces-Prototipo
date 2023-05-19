package com.example.usuplace;

public class User {
    private String name;
    private String email;
    private String phone;
    private String municipality;
    private String department;
    private String password;

    public User(String name, String email, String phone, String municipality, String department, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.municipality = municipality;
        this.department = department;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }
}
