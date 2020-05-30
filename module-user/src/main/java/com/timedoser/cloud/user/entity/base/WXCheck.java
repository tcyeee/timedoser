package com.timedoser.cloud.user.entity.base;

import lombok.Data;

/**
 * wx返回的检查类 (拼写问题不要改,需要和微信端对应)
 *
 * @author tcyeee
 * @since 2019-05-04 10:06
 */
@Data
@SuppressWarnings("all")
public class WXCheck {

    private int errcode;
    private String errmsg;
    private String session_key;
    private String openid;

}
