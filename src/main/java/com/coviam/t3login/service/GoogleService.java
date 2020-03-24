//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service;

import com.coviam.t3login.dto.AccessTokenDTO;
import com.coviam.t3login.entity.Login;

public interface GoogleService {
    Login getGmailDetails(AccessTokenDTO var1);
}
