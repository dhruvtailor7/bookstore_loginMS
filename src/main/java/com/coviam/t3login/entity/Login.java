//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
        name = "LOGIN"
)
public class Login implements Serializable {
    @GeneratedValue(
            generator = "uid"
    )
    @GenericGenerator(
            name = "uid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    @Column(
            name = "uid"
    )
    private String uId;
    private String email;
    private String loginType;
    private String password;

    public Login() {
    }

    public String getUId() {
        return this.uId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Login(uId=" + this.getUId() + ", email=" + this.getEmail() + ", loginType=" + this.getLoginType() + ", password=" + this.getPassword() + ")";
    }
}
