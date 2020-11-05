package com.atguigu.guli.service.edu.controller.login;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.admin.login.Account;
import com.google.common.annotations.GwtCompatible;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.bind.annotation.*;

/**
 * @author abliger
 */
@Api(tags = "前端临时登录接口")
@RestController
@RequestMapping("/edu/admin/login")
@Slf4j
public class LoginController {

    @ApiModelProperty("验证登录")
    @PostMapping("/login")
    public R getAuth(@RequestBody Account account){
        log.debug(account.toString());
        return R.ok().data("token","admin");
    }

    @ApiOperation("获得用户登录信息")
    @GetMapping("info")
    public R info(String token) {
        log.debug(token);
        return R.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
    }

    @ApiModelProperty("登出")
    @PostMapping("/logout")
    public R logout(){
        return R.ok();
    }

}
