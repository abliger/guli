package com.atguigu.guli.service.edu.test;

import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author abliger
 */
@RestController
@Api(tags = "测试异常处理Controller")
@RequestMapping("edu/test/")
public class ExceptTestController {

    @Value("${server.port}")
    String port;

    @ApiOperation("测试-port")
    @GetMapping("port")
    public R portTest(){
        return R.ok().data("port",port);
    }

    @Value("${spring.cloud.sentinel.transport.dashboard}")
    String str;

    @ApiOperation("测试-sentinel.dashboard")
    @GetMapping("dashboard")
    public R dashboardTest(){
        return R.ok().data("str",str);
    }

    @Value("${spring.datasource.driver-class-name}")
    private String dataSource;

    @ApiOperation("测试-dataSource")
    @GetMapping("dataSource")
    public R dataSourceTest(){
        return R.ok().data("str",dataSource);
    }


    @ApiOperation("测试异常处理-全局异常Exception")
    @GetMapping("Except")
    public R ExceptTest(){
        int i=1/0;
        return R.ok();
    }

    @ApiOperation("测试异常处理-全局异常GuliException")
    @GetMapping("GuliException")
    public R GuliException(){
        throw new GuliException(ResultCodeEnum.TEST_Exception);
    }

    @ApiOperation("测试访问")
    @GetMapping("get")
    public R get(){
        return R.ok().message("访问正常");
    }
}
