//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class SignupDto1 {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private String pincode;
    private String loginType;

    public SignupDto1() {
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String toString() {
        return "SignupDto1(name=" + this.getName() + ", email=" + this.getEmail() + ", address=" + this.getAddress() + ", phoneNumber=" + this.getPhoneNumber() + ", password=" + this.getPassword() + ", pincode=" + this.getPincode() + ", loginType=" + this.getLoginType() + ")";
    }
}
