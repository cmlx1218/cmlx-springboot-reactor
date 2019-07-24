package com.cmlx.reactor.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import reactor.core.Reactor;
import reactor.event.Event;
import reactor.event.selector.Selector;
import reactor.function.Consumer;


import static reactor.event.selector.Selectors.$;

/**
 * 事务处理器
 * 我们日常用的最多的就是pool，假如遇到不同的情况需要用到loop的就需要在继承类里面重写 register 和 send 方法
 *
 * @Author cmlx
 * @Date 2019-7-24 0024 16:03
 * @Version 1.0
 */
public abstract class BaseHandler<T> implements InitializingBean,Consumer<Event<T>> {

    /**
     * 事件处理池（异步处理）
     */
    @Autowired
    protected Reactor pool;


    /**
     * 事件处理队列（one by one）
     */
    @Autowired
    @Qualifier("loop")
    protected Reactor loop;


    /**
     * 获取选择器
     * @return
     */
    protected final Selector selector(){
        return $(this.getClass().getSimpleName());
    }

    /**
     * 获取唤醒线程的选择器
     * @return
     */
    protected final String selectorKey(){
        return this.getClass().getSimpleName();
    }

    /**
     * 实现了InitializingBean，Spring在初始化容器是就会执行此方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.register();
    }

    @Override
    public void accept(Event<T> tEvent) {
        this.handler(tEvent.getData(),tEvent);
    }

    protected abstract void handler(T o, Event<T> tEvent);

    public void send(T o){
        pool.notify(selectorKey(),Event.wrap(o));
    }

    public final void send(Event o){
        pool.notify(selectorKey(),o);
    }

    protected void register() throws Exception{
        pool.on(selector(),this);
    }
}
