package com.timedoser.cloud.common.config;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

/**
 * 更改字符集/返回格式
 *
 * @author tcyeee
 * @date 2020-06-03
 */
@Configuration
public class HttpMessageConvertsConfig {

    @Bean
    public HttpMessageConverters httpMessageConverter() {
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setCharset(StandardCharsets.UTF_8);
        jsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonConfig.setFeatures(
                Feature.AllowArbitraryCommas,
                Feature.DisableCircularReferenceDetect);
        jsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.IgnoreNonFieldGetter);

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(CollUtil.list(true, MediaType.APPLICATION_JSON_UTF8));
        converter.setFastJsonConfig(jsonConfig);
        return new HttpMessageConverters(converter);
    }
}
