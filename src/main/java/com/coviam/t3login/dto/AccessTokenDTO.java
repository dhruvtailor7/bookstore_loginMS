//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class AccessTokenDTO {
    private String accessToken;
    private String loginType;

    public AccessTokenDTO() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String toString() {
        return "AccessTokenDTO(accessToken=" + this.getAccessToken() + ", loginType=" + this.getLoginType() + ")";
    }
}
