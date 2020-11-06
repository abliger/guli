package com.atguigu.guli.service.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.guli.service.oss.entity.OssConfigBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author abliger
 */
@Slf4j
@Configuration
public class OssConfig {
    @Autowired
    private OssConfigBean ossConfigBean;

    @Bean
    public OSS getOssClient(){
        log.debug(ossConfigBean.toString());
        String endpoint = "https://"+ossConfigBean.getEndpoint();
        String keyId = ossConfigBean.getKeyId();
        String keySecret = ossConfigBean.getKeySecret();
        return new OSSClientBuilder().build(endpoint, keyId, keySecret);
    }
}
