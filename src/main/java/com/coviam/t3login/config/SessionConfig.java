package com.coviam.t3login.config;

import com.coviam.t3login.dto.SignupDto1;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
@EnableAutoConfiguration
public class SessionConfig {

    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<SignupDto1, String> redisTemplate() {
        RedisTemplate<SignupDto1, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        return template;
    }


//    @Bean
//    public RedisTemplate<LoginDTO, String> redisTemplate1() {
//        RedisTemplate<LoginDTO, String> template1 = new RedisTemplate<>();
//        template1.setConnectionFactory(connectionFactory());
//        return template1;
//    }
}
