package com.atguigu.guli.service.oss.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.Data;

/**
 * @author abliger
 */
@Data
public class Uri {
    @ApiModelProperty(value="图片在OSS的地址",
            example=  "{'url':'[avater/2020/11/06/xxx.jpg, avater/2020/11/06/xxx.jpg, avater/2020/11/06/xxx.jpg]'}")
    private String[] url;
}
