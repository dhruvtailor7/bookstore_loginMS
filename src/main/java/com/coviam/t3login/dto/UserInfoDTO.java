//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class UserInfoDTO {
    private String email;
    private String name;
    private String loginType;

    public UserInfoDTO() {
    }

    public String toString() {
        return "UserInfoDTO(email=" + this.getEmail() + ", name=" + this.getName() + ", loginType=" + this.getLoginType() + ")";
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
