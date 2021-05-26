package com.peerlender.securityapp.user.model;

import java.util.Objects;

public class NewUser {

    private String username;
    private String password;

    public NewUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(username, newUser.username) && Objects.equals(password, newUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
