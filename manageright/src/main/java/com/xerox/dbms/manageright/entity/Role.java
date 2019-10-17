package com.xerox.dbms.manageright.entity;

// import javax.persistence.*;

import java.util.List;
// import java.util.Set;

public class Role {
    private int RoleID;
    private int UserID;
    private String Name;

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}