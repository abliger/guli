package com.atguigu.guli.service.edu.entity.admin.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author abliger
 */
@ApiModel("登录类")
@Data
@ToString
public class Account {
    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("登录账号")
    private String account;
}
