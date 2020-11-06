package com.atguigu.guli.service.base.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    TEST_Exception(false,20010,"测试错误"),
    FILE_NOT_EXIST(false,20100,"文件不存在"),
    IMG_URL_NOT_EXIST(false,20200 ,"图片地址不存在" ),
    FEIGN_REMOTE_FAIL(false,20250,"远程调用失败");



    private final Boolean success;
    private final Integer code;
    private final String message;
    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}