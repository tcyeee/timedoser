package demo.tcyeee.utils;

import com.alibaba.fastjson.JSONObject;
import demo.tcyeee.entity.base.WXCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @since 2019-05-04 10:18
 */
@Service
@PropertySource("classpath:base.properties")
public class RestTemplateUtils {

    /* 小程序验证相关信息勿修改 */
    @Value("${appid}")
    private String appid;

    /* 小程序验证相关信息勿修改 */
    @Value("${secret}")
    private String secret;

    /* 小程序验证相关信息勿修改 */
    @Value("${grant_type}")
    private String grant_type;

    /* 小程序验证相关信息勿修改 */
    @Value("${checkUrl}")
    private String checkUrl;


    @Resource
    private RestTemplate restTemplate;

    /**
     * 获取方法
     *
     * @param appCode js_code
     * @return openid
     */
    public WXCheck getOpenId(String appCode) {
        String url = checkUrl + "?appid=" + appid + "&secret=" + secret + "&js_code=" + appCode + "&grant_type=" + grant_type;
        String result = restTemplate.getForObject(url, String.class);
        return JSONObject.parseObject(result, WXCheck.class);
    }
}
