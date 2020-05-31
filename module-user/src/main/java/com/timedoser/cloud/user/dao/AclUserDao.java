package com.timedoser.cloud.user.dao;

import com.timedoser.cloud.common.entity.po.AclUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author tcyeee
 * @date 2019-05-07 19:39
 */
@Repository
public interface AclUserDao extends JpaRepository<AclUser, String> {

    /**
     * 登录方法
     *
     * @param mobilephone mobilephone
     * @param password    password
     * @return login info
     */
    AclUser findByMobilephoneAndPassword(String mobilephone, String password);

    /**
     * 通过手机号查询用户
     *
     * @param mobilephone mobilephone
     * @return data
     */
    AclUser findByMobilephone(String mobilephone);

    /**
     * 通过openID查找用户基本信息
     *
     * @param openid openid
     * @param enable status
     * @return data
     */
    AclUser findByOpenidAndEnable(String openid, Enum enable);

    /**
     * 通过id查询用户
     *
     * @param userId 用户信息
     * @return data
     */
    @Query(value = "select * from time_doser.base_user where id =?1", nativeQuery = true)
    AclUser findByUserId(String userId);
}
