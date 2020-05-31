package com.timedoser.cloud.main.server.feign.fallback;

import com.timedoser.cloud.common.entity.po.User;
import com.timedoser.cloud.main.server.feign.UserFeignClient;
import org.springframework.stereotype.Service;

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 *
 * @author tcyeee
 * @since 2020/5/31 9:28 下午
 */
@Service
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findUserByPhone(String phoneNubmer) {
        return null;
    }
}
