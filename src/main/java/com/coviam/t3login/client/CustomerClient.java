//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.client;

import com.coviam.t3login.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("customer")
public interface CustomerClient {
    @PostMapping({"/add"})
    String add(@RequestBody CustomerDTO var1);

    @GetMapping({"/getCustomerById/{id}"})
    CustomerDTO getCustomerById(@PathVariable("id") String var1);

    @GetMapping({"/getEmailById/{id}"})
    String getEmailById(@PathVariable("id") String var1);
}
