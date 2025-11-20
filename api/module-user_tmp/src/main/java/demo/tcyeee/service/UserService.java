package demo.tcyeee.service;

import demo.tcyeee.entity.po.BaseUser;
import org.springframework.stereotype.Service;

/**
 * @author tcyeee
 * @since 2019-08-11 09:57
 */
@Service
public interface UserService {


    BaseUser updataUserInfo(String userinfo);
}
