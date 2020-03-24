//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class FacebookDTO {
    String name;
    String id;
    String email;
    String first_name;
    String last_name;
    String loginType;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String toString() {
        return "FacebookDTO(name=" + this.getName() + ", id=" + this.getId() + ", email=" + this.getEmail() + ", first_name=" + this.getFirst_name() + ", last_name=" + this.getLast_name() + ", loginType=" + this.getLoginType() + ")";
    }

    public FacebookDTO() {
    }

    public FacebookDTO(String name, String id, String email, String first_name, String last_name, String loginType) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.loginType = loginType;
    }
}
