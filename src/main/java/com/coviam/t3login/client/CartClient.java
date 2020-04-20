//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.client;

import com.coviam.t3login.dto.CartUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("http://bookstore-cart.herokuapp.com/")
public interface CartClient {
    @PostMapping({"/updateGuestCart"})
    void updateGuestCart(@RequestBody CartUpdateDTO var1);
}
