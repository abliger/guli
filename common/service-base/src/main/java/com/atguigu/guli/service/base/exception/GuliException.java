package com.atguigu.guli.service.base.exception;

import com.atguigu.guli.service.base.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author abliger
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class GuliException extends RuntimeException{
    private Integer code;
    private final Boolean success=false;

    public GuliException(Integer code,String message) {
        super(message);
        this.code=code;
    }

    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }

}
