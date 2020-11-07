package com.atguigu.guli.service.edu.entity.admin.Query;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author abliger
 */
@Data
@ToString
@ApiModel("课程结构查询")
public class SubjectList {
    @ExcelProperty(value = "一级分类Id")
    private String levelOneId;

    @ExcelProperty(value = "一级分类Title")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类集合")
    private List<SubjectList> children;
}
