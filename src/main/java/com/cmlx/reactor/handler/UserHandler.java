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


    /**
     * 要用消息队列服务做点赞等业务时就需要重写这两份个方法
     */

/*    @Override
    public void send(User o) {
        loop.notify(selectorKey(), Event.wrap(o));
    }

    @Override
    protected void register() throws Exception {
        loop.on(selector(), this);
    }*/
}
