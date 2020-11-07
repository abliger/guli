package com.atguigu.guli.service.edu.entity.admin.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
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
public class CourseVo {
    @ExcelProperty(value = "课程题目")
    private String title;

    @ExcelProperty(value = "讲师名称")
    private String TeacherName;

    @ExcelProperty(value = "课程分类集合")
    private List<SubjectList> subjectLists;

    @ExcelProperty(value = "总课时")
    private String lesson_num;

    @ExcelProperty(value = "课程简介")
    private String description;

    @ExcelProperty(value = "课程封面")
    private String cover;

    @ExcelProperty(value = "课程价格")
    private String price;
}
