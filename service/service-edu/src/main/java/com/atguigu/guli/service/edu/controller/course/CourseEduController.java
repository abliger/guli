package com.atguigu.guli.service.edu.controller.course;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.admin.vo.CourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abliger
 */
@Slf4j
@Api(tags = "课程发布")
@RestController
@RequestMapping("edu/admin/course")
public class CourseEduController {
    @ApiOperation("课程详情存储")
    @PostMapping("saveCourseInfo")
    public R saveCourseInfo(@ApiParam("课程信息") @RequestBody CourseVo courseVo){
        log.debug(courseVo.toString());
        return R.ok();
    }

}
