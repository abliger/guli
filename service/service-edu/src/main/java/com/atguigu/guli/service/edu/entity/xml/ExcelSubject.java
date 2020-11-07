package com.atguigu.guli.service.edu.entity.xml;

import com.alibaba.excel.annotation.ExcelProperty;
import com.atguigu.guli.service.base.model.BaseEntity;
import lombok.Data;

@Data
public class ExcelSubject extends BaseEntity {

    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;
}