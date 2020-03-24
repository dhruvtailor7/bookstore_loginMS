//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class LoginDTO {
    private String email;
    private String password;
    private String loginType;
    private String deviceId;

    public LoginDTO() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String toString() {
        return "LoginDTO(email=" + this.getEmail() + ", password=" + this.getPassword() + ", loginType=" + this.getLoginType() + ", deviceId=" + this.getDeviceId() + ")";
    }
}
