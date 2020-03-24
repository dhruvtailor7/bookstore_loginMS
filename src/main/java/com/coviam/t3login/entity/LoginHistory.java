//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
        name = "LOGINHISTORY"
)
public class LoginHistory {
    @Id
    @GeneratedValue(
            generator = "uid"
    )
    @GenericGenerator(
            name = "uid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "_id"
    )
    private String _id;
    private String Uid;
    private String timeStamp;

    public LoginHistory() {
    }

    public String get_id() {
        return this._id;
    }

    public String getUid() {
        return this.Uid;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUid(String Uid) {
        this.Uid = Uid;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
