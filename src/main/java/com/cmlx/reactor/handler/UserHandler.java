package com.cmlx.reactor.handler;

import com.cmlx.reactor.dto.User;
import org.springframework.stereotype.Component;
import reactor.event.Event;

/**
 * @Author cmlx
 * @Date 2019-7-24 0024 17:15
 * @Version 1.0
 */
@Component
public class UserHandler extends BaseHandler<User> {
    @Override
    protected void handler(User o, Event<User> userEvent) {
        System.out.println(o);
    }
}
