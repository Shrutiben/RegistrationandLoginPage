package com.registrationapp.registrationapp.Model;

import javax.persistence.*;
import lombok.Data;

//@Data
@Entity
@Table(name="ud_table")
public class UserDtls {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    public UserDtls() {
        super();
    }

    //create constructor for the UserDetails or UserDtls
    public UserDtls(int id,String fullName, String email, String password,String role) {
        super();
        this.id=id;
        this.email=email;
        this.fullName=fullName;
        this.password=password;
        this.role=role;
    }

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
