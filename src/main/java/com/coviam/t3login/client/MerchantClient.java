//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.client;

import com.coviam.t3login.dto.MerchantDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("http://bookstore-merchant.herokuapp.com/")
public interface MerchantClient {
    @PostMapping({"/addMerchant"})
    String addMerchant(@RequestBody MerchantDTO var1);

    @GetMapping({"/getMerchantById/{id}"})
    MerchantDTO getMerchantById(@PathVariable("id") String var1);

    @GetMapping({"/getMerchantByProductId/{id}"})
    List<MerchantDTO> getMerchantByProductId(@PathVariable("id") String var1);
}
