package com.atguigu.guli.service.oss.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @author abliger
 */
@ApiModel("阿里云OSS配置类")
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssConfigBean {
    @ApiModelProperty("注册地址")
    private String endpoint;

    @ApiModelProperty("id")
    private String keyId;

    @ApiModelProperty("密码")
    private String keySecret;

    @ApiModelProperty("桶")
    private String bucketName;
}
