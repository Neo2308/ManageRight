package com.xerox.dbms.manageright.entity;

// import javax.persistence.*;

import java.util.List;
// import java.util.Set;

public class User {
    private int UserID;

    private String Username;

    private String Password;

    // @Transient
    private String PasswordConfirm;

    // @ManyToMany
    private List<Role> Roles;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPasswordConfirm() {
        return PasswordConfirm;
    }

    public void setPasswordConfirm(String PasswordConfirm) {
        this.PasswordConfirm = PasswordConfirm;
    }

    public List<Role> getRoles() {
        return Roles;
    }

    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }
}