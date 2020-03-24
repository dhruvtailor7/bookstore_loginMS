//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service.impl;

import com.coviam.t3login.dto.AccessTokenDTO;
import com.coviam.t3login.entity.Login;
import com.coviam.t3login.repository.LoginRepository;
import com.coviam.t3login.service.GoogleService;
import com.coviam.t3login.service.LoginService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier.Builder;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleServiceImpl implements GoogleService {
    @Autowired
    LoginService loginService;
    private static final String GOOGLE_APP_CLIENT_ID = "96163843308-4t0o0dcm4ej28uqg2gmk9br3dbsoeuol.apps.googleusercontent.com";
    @Value("96163843308-4t0o0dcm4ej28uqg2gmk9br3dbsoeuol.apps.googleusercontent.com")
    private List<String> googleAppClientIdList;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private HttpTransport httpTransport;
    @Autowired
    LoginRepository loginRepository;

    public GoogleServiceImpl() {
    }

    @PostConstruct
    public void init() throws GeneralSecurityException, IOException {
        this.httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    }

    public GoogleIdTokenVerifier getGoogleIdTokenVerifier() {
        return (new Builder(this.httpTransport, JSON_FACTORY)).setAudience((Collection)null).build();
    }

    public Login getGmailDetails(AccessTokenDTO accessTokenDTO) {
        System.out.println("Inside Gmail Details");
        Login user = new Login();

        try {
            GoogleIdToken verifyGoogleIdToken = this.getGoogleIdTokenVerifier().verify(accessTokenDTO.getAccessToken());
            System.out.println(verifyGoogleIdToken);
            if (verifyGoogleIdToken != null) {
                System.out.println("Inside verifyGoogleIDToken");
                String email = verifyGoogleIdToken.getPayload().getEmail();
                String name = verifyGoogleIdToken.getPayload().toString().split(",")[8].split(":")[1];
                List<Login> list = (ArrayList)this.loginRepository.findAll();
                System.out.println("++++++>" + name.substring(1, name.length() - 1));
                name = name.substring(1, name.length() - 1);
                list = (List)list.stream().filter((login1) -> {
                    return login1.getEmail().equals(email);
                }).collect(Collectors.toList());
                System.out.println(list);
                if (list.size() == 0) {
                    user.setEmail(email);
                    System.out.println(verifyGoogleIdToken.getPayload().getEmail());
                    user.setLoginType(accessTokenDTO.getLoginType());
                    this.loginService.save(user, name);
                } else {
                    user = (Login)list.get(0);
                }
            } else {
                System.out.println("Not valid Token");
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println(user);
        return user;
    }
}
