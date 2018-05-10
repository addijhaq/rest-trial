package com.addisonulhaq.user;

import com.addisonulhaq.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String userName;
    private String firstName;
    private String lastName;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String[] roles;

    protected User() {
        super(); // calls BaseEntity to generate ID
    }

    public User(String userName, String firstName, String lastName, String password, String[] roles) {
        this(); //calls empty constructor
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }
}
