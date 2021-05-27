package com.peerlender.securityapp.user.dto;

import java.util.Objects;

public class UserDTO {


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;


    public UserDTO() {}

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return age == userDTO.age && Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password) && Objects.equals(firstName, userDTO.firstName) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(occupation, userDTO.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, age, occupation);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}

