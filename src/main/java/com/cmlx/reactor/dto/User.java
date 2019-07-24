package com.cmlx.reactor.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author cmlx
 * @Date 2019-7-24 0024 14:40
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class User {

    private Long userId;
    private String userName;
    private String address;
    private String hobby;

}
