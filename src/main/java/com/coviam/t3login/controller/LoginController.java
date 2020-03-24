//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.controller;

import com.coviam.t3login.dto.AccessTokenDTO;
import com.coviam.t3login.dto.FacebookDTO;
import com.coviam.t3login.dto.LoginDTO;
import com.coviam.t3login.dto.SignupDto1;
import com.coviam.t3login.dto.UserInfoDTO;
import com.coviam.t3login.entity.Login;
import com.coviam.t3login.service.GoogleService;
import com.coviam.t3login.service.LoginHistoryService;
import com.coviam.t3login.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    GoogleService googleService;
    @Autowired
    private LoginHistoryService loginHistoryService;

    public LoginController() {
    }

    @PostMapping({"/signup"})
    public String signup(@RequestBody SignupDto1 signupDto1) {
        return this.loginService.signup(signupDto1);
    }

    @PostMapping({"/signout"})
    public void evictAllCacheValues(@RequestParam("email") String email) {
        this.loginService.evictCacheForKey(email);
    }

    @GetMapping({"/getLoginHistoryById/{id}"})
    public List<String> getLoginHistoryById(@PathVariable("id") String id) {
        return this.loginHistoryService.getLoginHistoryById(id);
    }

    @PostMapping({"/login"})
    public String login(@RequestBody LoginDTO loginDTO) {
        return this.loginService.login(loginDTO);
    }

    @PostMapping({"/googlelogin"})
    public String gmailLogin(@RequestBody AccessTokenDTO accessTokenDTO) {
        System.out.println("Inside gmail login");
        Login user = this.googleService.getGmailDetails(accessTokenDTO);
        return user != null ? "{\"response\":\"" + user.getUId() + "\"}" : "{\"response\":\"Not Found\"}";
    }

    @PostMapping({"/facebooklogin"})
    public String facebookLogin(@RequestBody AccessTokenDTO accessTokenDTO) throws Exception {
        FacebookDTO userDTO = (FacebookDTO)(new RestTemplate()).getForObject("https://graph.facebook.com/v2.9/me?fields=email,name,id,first_name,last_name&access_token=" + accessTokenDTO.getAccessToken(), FacebookDTO.class, new Object[0]);
        System.out.println(userDTO);
        if (userDTO != null) {
            UserInfoDTO user = new UserInfoDTO();
            user.setEmail(userDTO.getEmail());
            user.setLoginType(accessTokenDTO.getLoginType());
            user.setName(userDTO.getName());
            Login login = this.loginService.saveFacebook(user);
            return "{\"response\":\"" + login.getUId() + "\"}";
        } else {
            return "{\"response\":\"Not Found\"}";
        }
    }
}
