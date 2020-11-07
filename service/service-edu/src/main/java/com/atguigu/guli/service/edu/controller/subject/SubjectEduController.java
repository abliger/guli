package com.atguigu.guli.service.edu.controller.subject;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.Subject;
import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
import com.atguigu.guli.service.edu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author abliger
 */
@Slf4j
@RestController
@Api(tags = "课程结构管理")
@RequestMapping("edu/admin/subject")
public class SubjectEduController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation("导入课程结构")
    @PostMapping("import")
    public R importSubject(@ApiParam("上传excel文件") @RequestBody MultipartFile file){
        log.debug(file.getOriginalFilename());
        subjectService.saveExcel(file);
        return R.ok();
    }

    @ApiOperation("获得课程直接结构")
    @GetMapping("subjectList")
    public R getSubjectList(){
        final List<Subject> list = subjectService.list();
        return R.ok().data("items",list);
    }

    @ApiOperation("获得课程查询结构")
    @GetMapping("subjectListQuery")
    public R subjectListQuery(){
        final List<SubjectList> list =subjectService.subjectListQuery();
        return R.ok().data("items",list);
    }

}
