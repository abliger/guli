package com.atguigu.guli.service.edu.entity.admin.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author abliger
 */
@Data
@ToString
@ApiModel("讲师列表查询标准类")
public class QueryTeacherList {
    @ApiModelProperty("讲师姓名")
    private String name;

    @ApiModelProperty("讲师头衔")
    private String level;

    @ApiModelProperty("讲师入职开始时间")
    private String joinDateBegin;

    @ApiModelProperty("讲师入职结束时间")
    private String joinDateEnd;
}
