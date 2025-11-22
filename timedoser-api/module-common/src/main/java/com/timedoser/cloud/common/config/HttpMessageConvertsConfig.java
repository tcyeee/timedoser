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

    /**
     * 名称  含义  备注
     * QuoteFieldNames 输出key时是否使用双引号,默认为true
     * UseSingleQuotes 使用单引号而不是双引号,默认为false
     * WriteMapNullValue   是否输出值为null的字段,默认为false
     * WriteEnumUsingToString  Enum输出name()或者original,默认为false
     * UseISO8601DateFormat    Date使用ISO8601格式输出，默认为false
     * WriteNullListAsEmpty    List字段如果为null,输出为[],而非null
     * WriteNullStringAsEmpty  字符类型字段如果为null,输出为”“,而非null
     * WriteNullNumberAsZero   数值字段如果为null,输出为0,而非null
     * WriteNullBooleanAsFalse Boolean字段如果为null,输出为false,而非null
     * SkipTransientField  如果是true，类中的Get方法对应的Field是transient，序列化时将会被忽略。默认为true
     * SortField   按字段名称排序后输出。默认为false
     * WriteTabAsSpecial   把\t做转义输出，默认为false   不推荐
     * PrettyFormat    结果是否格式化,默认为false
     * WriteClassName  序列化时写入类型信息，默认为false。反序列化是需用到
     * DisableCircularReferenceDetect  消除对同一对象循环引用的问题，默认为false
     * WriteSlashAsSpecial 对斜杠’/’进行转义
     * WriteDateUseDateFormat  全局修改日期格式,默认为false。JSON.DEFFAULT_DATE_FORMAT = “yyyy-MM-dd”;JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
     * DisableCheckSpecialChar 一个对象的字符串属性中如果有特殊字符如双引号，将会在转成json时带有反斜
     */
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
                SerializerFeature.PrettyFormat,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.IgnoreNonFieldGetter);
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(CollUtil.list(true, MediaType.APPLICATION_JSON_UTF8));
        converter.setFastJsonConfig(jsonConfig);
        return new HttpMessageConverters(converter);
    }
}
