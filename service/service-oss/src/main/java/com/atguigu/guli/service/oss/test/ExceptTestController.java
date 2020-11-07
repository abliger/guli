package com.atguigu.guli.service.oss.test;

import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abliger
 */
@RestController
@RefreshScope
@Api(tags = "测试异常处理Controller")
@RequestMapping("oss/test/")
public class ExceptTestController {
    @Value("${server.port}")
    String port;

    @ApiOperation("测试-port")
    @GetMapping("port")
    public R portTest(){
        return R.ok().data("port",port);
    }

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @ApiOperation("测试-oss.endpoint")
    @GetMapping("endpoint")
    public R dashboardTest(){
        return R.ok().data("endpoint",endpoint);
    }

    @ApiOperation("测试访问")
    @GetMapping("get")
    public R get(){
        return R.ok().message("访问正常");
    }
}
