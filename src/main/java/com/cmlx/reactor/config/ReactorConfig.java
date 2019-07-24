package com.cmlx.reactor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;

/**
 *
 * 注入Reactor环境
 *
 * @Author cmlx
 * @Date 2019-7-24 0024 15:47
 * @Version 1.0
 */
@Component
public class ReactorConfig {

    @Bean
    Environment env(){
        return new Environment();
    }


    @Bean
    @Primary
    Reactor pool(){
        return Reactors.reactor()
                .env(env())
                .dispatcher(Environment.THREAD_POOL)
                .get();
    }


    @Bean
    Reactor loop(){
        return Reactors.reactor()
                .env(env())
                .dispatcher(Environment.EVENT_LOOP)
                .get();
    }


}
