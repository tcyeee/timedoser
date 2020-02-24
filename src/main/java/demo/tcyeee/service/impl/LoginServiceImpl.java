package demo.tcyeee.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import demo.tcyeee.dao.BaseUserDao;
import demo.tcyeee.dao.PlanTaskDao;
import demo.tcyeee.dao.ProjectDao;
import demo.tcyeee.entity.base.FixedInfo;
import demo.tcyeee.entity.base.WXCheck;
import demo.tcyeee.entity.po.BaseUser;
import demo.tcyeee.entity.po.PlanTask;
import demo.tcyeee.entity.po.Project;
import demo.tcyeee.entity.vo.LoginInfoVo;
import demo.tcyeee.entity.vo.WebUserInfoVo;
import demo.tcyeee.mapper.AclUserRoleMapper;
import demo.tcyeee.service.LoginService;
import demo.tcyeee.utils.ResponseUtils;
import demo.tcyeee.utils.TokenUtils;
import demo.tcyeee.utils.WeiXinUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @since 2019-05-05 16:27
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private WeiXinUtils weiXinUtils;

    @Resource
    private BaseUserDao baseUserDao;

    @Resource
    private TokenUtils tokenUtils;

    @Resource
    private AclUserRoleMapper aclUserRoleMapper;

    @Value("${token.header}")
    private String tokenHeader;

    @Resource
    private PlanTaskDao planTaskDao;

    @Resource
    private ProjectDao projectDao;

    /**
     * 登录接口
     *
     * @param loginUser 账号密码
     * @return status
     */
    @Override
    public String login(BaseUser loginUser) {
        String basePassword = Base64.decodeStr(loginUser.getPassword());
        String password = DigestUtils.md5DigestAsHex(basePassword.getBytes()).toUpperCase();
        BaseUser baseUser = baseUserDao.findByMobilephoneAndPassword(loginUser.getMobilephone(), password);

        if (baseUser != null && baseUser.getEnable() == BaseUser.enableTypeEnum.defult) {
            WebUserInfoVo result = new WebUserInfoVo();
            BeanUtil.copyProperties(baseUser, result);

            result.setToken(tokenUtils.generateToken(baseUser));
            result.setRoles(aclUserRoleMapper.findAllByBaseUser(baseUser.getId()));
            return ResponseUtils.creatJsonResponse(result);
        } else {
            return ResponseUtils.creatStatusResponse(false, FixedInfo.LOGIN_FAIL);
        }
    }


    /**
     * 查看用户信息详情
     * 1.每次页面刷新都会调用这个方法
     * 2.如果有就返回,没有就新加一条数据
     *
     * @param appCode 微信临时用户id
     * @return data
     */
    @Override
    public LoginInfoVo getBaseInfo(String appCode) {
        LoginInfoVo result = new LoginInfoVo();

        // 获取openid
        WXCheck openId = weiXinUtils.getOpenId(appCode);
        if (openId.getErrcode() != 0) {
            return null;
        }

        // 对比数据库有没有openid,如果有的话获取基础信息和token , 没有就添加一条
        BaseUser baseUser = baseUserDao.findByOpenidAndEnable(openId.getOpenid(), BaseUser.enableTypeEnum.defult);
        if (baseUser == null) {
            BaseUser user = BaseUser.creatBaseUserForOpenId(openId.getOpenid());
            baseUser = baseUserDao.save(user);

            /* 新建用户对应的操作
             * 1.创建实例任务
             * 2.创建实例项目
             */
            this.creatDemoTask(baseUser);
        }

        BeanUtils.copyProperties(baseUser, result);
        result.setToken(tokenUtils.generateToken(baseUser));
        return result;
    }


    /**
     * 新用户创建时候进行的操作
     *
     * @param baseUser 用户信息
     */
    private void creatDemoTask(BaseUser baseUser) {

        // 1.创建一个示例任务(即将废弃)
        PlanTask task = PlanTask.builder()
                .baseUser(baseUser)
                .name("实例项目").build();
        planTaskDao.save(task);

        // 2.创建2个默认项目
        Project project = Project.builder()
                .name("备战雅思")
                .remark("考试加油!!")
                .baseUser(baseUser)
                .createType(Project.createTypeEnum.auto)
                .build();
        projectDao.save(project);
    }
}
