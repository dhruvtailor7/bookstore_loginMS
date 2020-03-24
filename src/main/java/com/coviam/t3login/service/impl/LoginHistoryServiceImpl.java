//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.service.impl;

import com.coviam.t3login.entity.LoginHistory;
import com.coviam.t3login.repository.LoginHistoryRepository;
import com.coviam.t3login.service.LoginHistoryService;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    public LoginHistoryServiceImpl() {
    }

    public List<String> getLoginHistoryById(String id) {
        List<LoginHistory> historyList = (List)this.loginHistoryRepository.findAll();
        System.out.println(historyList);
        return (List)historyList.stream().filter((loginHistory) -> {
            return loginHistory.getUid().equals(id);
        }).map((loginHistory) -> {
            return loginHistory.getTimeStamp();
        }).collect(Collectors.toList());
    }

    public void save(LoginHistory loginHistory) {
        this.loginHistoryRepository.save(loginHistory);
    }
}
