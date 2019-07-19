package demo.tcyeee.dao;

import demo.tcyeee.entity.po.BaseUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tcyeee
 * @date 2019-05-07 19:39
 */
@Repository
public interface BaseUserDao extends CrudRepository<BaseUser, Long> {

    /**
     * 登录方法
     *
     * @param mobilephone mobilephone
     * @param password    password
     * @return login info
     */
    BaseUser findByMobilephoneAndPassword(Integer mobilephone, String password);

    /**
     * 通过手机号查询用户
     *
     * @param mobilephone mobilephone
     * @return data
     */
    BaseUser findByMobilephone(Integer mobilephone);

    /**
     * 通过openID查找用户基本信息
     *
     * @param openid openid
     * @return data
     */
    BaseUser findByOpenid(String openid);

    /**
     * 通过id查询用户
     *
     * @param userId 用户信息
     * @return data
     */
    @Deprecated
    @Query(value = "select * from base_user where id =?1", nativeQuery = true)
    BaseUser findByUserId(String userId);
}
