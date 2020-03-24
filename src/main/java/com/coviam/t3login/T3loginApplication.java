//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableEurekaClient
public class T3loginApplication {
	public T3loginApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(T3loginApplication.class, args);
	}
}
