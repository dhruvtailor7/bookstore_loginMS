//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class GoogleDTO {
    private String name;
    private String Uid;
    private String email;

    public GoogleDTO() {
    }

    public String toString() {
        return "GoogleDTO(name=" + this.getName() + ", Uid=" + this.getUid() + ", email=" + this.getEmail() + ")";
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        return this.Uid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
