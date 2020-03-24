//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class MerchantDTO {
    private String merchantId;
    private String merchantName;
    private String merchantEmail;
    private String merchantPhone;
    private String pincode;
    private String merchantAddress;

    public MerchantDTO() {
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMerchantEmail() {
        return this.merchantEmail;
    }

    public String getMerchantPhone() {
        return this.merchantPhone;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getMerchantAddress() {
        return this.merchantAddress;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String toString() {
        return "MerchantDTO(merchantId=" + this.getMerchantId() + ", merchantName=" + this.getMerchantName() + ", merchantEmail=" + this.getMerchantEmail() + ", merchantPhone=" + this.getMerchantPhone() + ", pincode=" + this.getPincode() + ", merchantAddress=" + this.getMerchantAddress() + ")";
    }
}
