//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service.impl;

import com.coviam.t3login.client.CartClient;
import com.coviam.t3login.client.CustomerClient;
import com.coviam.t3login.client.MerchantClient;
import com.coviam.t3login.dto.*;
import com.coviam.t3login.dto.LoginDTO;
import com.coviam.t3login.entity.Login;
import com.coviam.t3login.entity.LoginHistory;
import com.coviam.t3login.repository.LoginHistoryRepository;
import com.coviam.t3login.repository.LoginRepository;
import com.coviam.t3login.service.LoginHistoryService;
import com.coviam.t3login.service.LoginService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    CustomerClient customerClient;
    @Autowired
    MerchantClient merchantClient;
    @Autowired
    LoginHistoryRepository loginHistoryRepository;
    @Autowired
    CartClient cartClient;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private LoginHistoryService loginHistoryService;

    public LoginServiceImpl() {
    }

    private static String pass(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public String signup(@RequestBody SignupDto1 signupDto1) {
        Login login = new Login();
        List<Login> list = (ArrayList)this.loginRepository.findAll();
        System.out.println(signupDto1);
        list = (List)list.stream().filter((login1) -> {
            return login1.getEmail().equals(signupDto1.getEmail());
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            return "{\"response\":\"already Exists\"}";
        } else {
            signupDto1.setPassword(pass(signupDto1.getPassword()));
            BeanUtils.copyProperties(signupDto1, login);
            login.setLoginType(signupDto1.getLoginType());
            System.out.println("-------------------" + signupDto1.getLoginType());
            Login userCreated = (Login)this.loginRepository.save(login);
            String response = userCreated.getUId();
            if (response != null && "customer".equals(signupDto1.getLoginType())) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setAddress(signupDto1.getAddress());
                customerDTO.setCustomerId(response);
                customerDTO.setName(signupDto1.getName());
                customerDTO.setEmail(signupDto1.getEmail());
                customerDTO.setPhoneNumber(signupDto1.getPhoneNumber());
                customerDTO.setPincode(signupDto1.getPincode());
                System.out.println("connecting to clinet");
                System.out.println("-->" + customerDTO.getCustomerId());
                return "{\"response\":\"" + this.customerClient.add(customerDTO) + "\"}";
            } else if (response != null && "merchant".equals(signupDto1.getLoginType())) {
                MerchantDTO merchantDTO = new MerchantDTO();
                merchantDTO.setMerchantAddress(signupDto1.getAddress());
                merchantDTO.setMerchantId(response);
                merchantDTO.setMerchantName(signupDto1.getName());
                merchantDTO.setMerchantEmail(signupDto1.getEmail());
                merchantDTO.setMerchantPhone(signupDto1.getPhoneNumber());
                merchantDTO.setPincode(signupDto1.getPincode());
                System.out.println("connecting to clinet");
                System.out.println("-->" + merchantDTO.getMerchantId());
                return "{\"response\":\"" + this.merchantClient.addMerchant(merchantDTO) + "\"}";
            } else {
                return "{\"response\":\"" + response + "\"}";
            }
        }
    }

    @CacheEvict(
            value = {"user"},
            key = "#email"
    )
    public void evictCacheForKey(@RequestParam("email") String email) {
    }

    public String login(@RequestBody LoginDTO loginDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String email = loginDTO.getEmail();
        String newPass = loginDTO.getPassword();
        System.out.println(loginDTO);
        List<Login> list = (ArrayList)this.loginRepository.findAll();
        System.out.println("Printing list" + list);
        list = (List)list.stream().filter((login1) -> {
            return login1.getEmail().equals(loginDTO.getEmail()) && login1.getLoginType().equals(loginDTO.getLoginType());
        }).collect(Collectors.toList());
        if (list.size() != 0) {
            Login loginServicePass = this.loginRepository.findPasswordByEmail(email);
            if (passwordEncoder.matches(newPass, loginServicePass.getPassword())) {
                LoginHistory loginHistory = new LoginHistory();
                loginHistory.setUid(loginServicePass.getUId());
                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Date dateobj = new Date();
                loginHistory.setTimeStamp(df.format(dateobj));
                this.loginHistoryService.save(loginHistory);
                String status = ((Login)list.get(0)).getUId();
                if (loginDTO.getDeviceId() != null) {
                    CartUpdateDTO cartUpdateDTO = new CartUpdateDTO();
                    cartUpdateDTO.setCartId(loginDTO.getDeviceId());
                    cartUpdateDTO.setCustomerId(status);
                    System.out.println("Upadating cart----->" + cartUpdateDTO);
                    this.cartClient.updateGuestCart(cartUpdateDTO);
                }

                return "{\"response\":\"" + status + "\"}";
            } else {
                return "{\"response\":\"Wrong Password\"}";
            }
        } else {
            return "{\"response\":\"Not registered\"}";
        }
    }

    public Login save(Login login, String name) {
        String loginType = login.getLoginType();
        Login new_login = (Login)this.loginRepository.save(login);
        if ("customer".equals(loginType)) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(new_login.getUId());
            customerDTO.setEmail(new_login.getEmail());
            customerDTO.setName(name);
            System.out.println(new_login);
            this.customerClient.add(customerDTO);
        } else {
            MerchantDTO merchantDTO = new MerchantDTO();
            merchantDTO.setMerchantEmail(new_login.getEmail());
            merchantDTO.setMerchantId(new_login.getUId());
            merchantDTO.setMerchantName(name);
            this.merchantClient.addMerchant(merchantDTO);
        }

        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUid(new_login.getUId());
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        loginHistory.setTimeStamp(df.format(dateobj));
        this.loginHistoryService.save(loginHistory);
        return new_login;
    }

    public Login saveFacebook(UserInfoDTO user) {
        Login login = new Login();
        login.setLoginType(user.getLoginType());
        login.setEmail(user.getEmail());
        List<Login> userList = (ArrayList)this.loginRepository.findAll();
        userList = (List)userList.stream().filter((login1) -> {
            return user.getEmail().equals(login1.getEmail());
        }).collect(Collectors.toList());
        Login new_login;
        if (userList.size() == 0) {
            new_login = (Login)this.loginRepository.save(login);
        } else {
            new_login = (Login)userList.get(0);
        }

        if ("customer".equals(login.getLoginType())) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(new_login.getUId());
            customerDTO.setEmail(new_login.getEmail());
            customerDTO.setName(user.getName());
            System.out.println(new_login);
            this.customerClient.add(customerDTO);
        } else {
            MerchantDTO merchantDTO = new MerchantDTO();
            merchantDTO.setMerchantEmail(new_login.getEmail());
            merchantDTO.setMerchantId(new_login.getUId());
            merchantDTO.setMerchantName(user.getName());
            this.merchantClient.addMerchant(merchantDTO);
        }

        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUid(new_login.getUId());
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        loginHistory.setTimeStamp(df.format(dateobj));
        this.loginHistoryService.save(loginHistory);
        return new_login;
    }

    public ArrayList<Login> getAll() {
        return (ArrayList)this.loginRepository.findAll();
    }

    public Login findPass(String email) {
        System.out.println("----------" + email);
        ArrayList<Login> loginArrayList = (ArrayList)this.loginRepository.findAll();
        return (Login)((List)loginArrayList.stream().filter((login) -> {
            return email.equals(login.getEmail());
        }).collect(Collectors.toList())).get(0);
    }
}
