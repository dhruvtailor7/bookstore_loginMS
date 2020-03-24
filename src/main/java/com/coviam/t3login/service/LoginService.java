//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service;

import com.coviam.t3login.dto.LoginDTO;
import com.coviam.t3login.dto.SignupDto1;
import com.coviam.t3login.dto.UserInfoDTO;
import com.coviam.t3login.entity.Login;
import java.util.ArrayList;

public interface LoginService {
    Login save(Login var1, String var2);

    Login findPass(String var1);

    ArrayList<Login> getAll();

    void evictCacheForKey(String var1);

    String login(LoginDTO var1);

    String signup(SignupDto1 var1);

    Login saveFacebook(UserInfoDTO var1);
}
