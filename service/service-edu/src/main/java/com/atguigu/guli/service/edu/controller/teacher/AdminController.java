package com.atguigu.guli.service.edu.controller.teacher;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.admin.Query.QueryTeacherList;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author abliger
 */
@Slf4j
@RestController
@Api(tags = "讲师管理")
@RequestMapping("edu/admin/teacher")
public class AdminController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("获得讲师列表")
    @GetMapping("getTeacherList")
    public R getTeacherList(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("list",list);
    }

    @ApiOperation("获得讲师分页列表")
    @GetMapping("list/{page}/{limit}")
    public R getTeacherListByPage(@ApiParam("页码") @PathVariable String page
            ,@ApiParam("每页显示几条数据") @PathVariable String limit
            ,@ApiParam(value = "查询条件",required = false) QueryTeacherList queryTeacherList){
        log.debug("讲师分页列表:\n页码:"+page+"\n显示数据:"+limit+"\n"+queryTeacherList.toString());
        Page<Teacher> teacherPage= teacherService.getTeacherListByPage(page,limit,queryTeacherList);
        return R.ok().data("items",teacherPage);
    }

    @ApiOperation("添加讲师")
    @PostMapping("save")
    public R saveTeacher(@ApiParam("讲师信息") @RequestBody Teacher teacher){
        log.debug("添加讲师"+teacher.toString());
        boolean save = teacherService.save(teacher);
        if (save){
            return R.ok().message("添加成功");
        }
        return R.error().message("添加失败");
    }

    @ApiOperation("讲师信息更新")
    @PutMapping("update")
    public R updateTeacher(@ApiParam("讲师信息") @RequestBody Teacher teacher){
        log.debug("讲师信息更新"+teacher.toString());
        boolean update = teacherService.updateById(teacher);
        if (update){
            return R.ok().message("更新成功");
        }
        return R.error().message("讲师信息更新失败");
    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("{id}")
    public R getTeacherInfo(@ApiParam("讲师id") @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }

    @ApiOperation("根据id删除讲师")
    @DeleteMapping("delete/{id}")
    public R deleteTeacherById(@ApiParam("讲师id") @PathVariable String id){
        boolean delete = teacherService.removeById(id);
        if (delete){
            return R.ok().message("删除成功");
        }
        return R.error().message("讲师信息删除失败");
    }

    @ApiOperation("批量删除讲师")
    @DeleteMapping("delete/list/{ids}")
    public R deleteTeachersByIds(@ApiParam("讲师id") @PathVariable List<Integer> ids){
        log.debug(ids.toString());
        System.out.println(ids);
        boolean delete = teacherService.removeByIds(ids);
        if (delete){
            return R.ok().message("删除成功");
        }
        return R.error().message("讲师信息删除失败");
    }
}
