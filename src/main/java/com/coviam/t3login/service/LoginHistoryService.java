//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service;

import com.coviam.t3login.entity.LoginHistory;
import java.util.List;

public interface LoginHistoryService {
    void save(LoginHistory var1);

    List<String> getLoginHistoryById(String var1);
}
