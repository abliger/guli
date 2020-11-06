package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.admin.Query.QueryTeacherList;
import com.atguigu.guli.service.edu.mapper.TeacherMapper;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author abliger
 * @since 2020-11-03
 */
@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page<Teacher> getTeacherListByPage(String page, String limit, QueryTeacherList queryTeacherList) {
        Page<Teacher> pageInfo = new Page(Long.parseLong(page), Long.parseLong(limit));
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (queryTeacherList.getName() != null && !queryTeacherList.getName().equals("")) {
            queryWrapper.likeRight("name", queryTeacherList.getName());
        }
        if (queryTeacherList.getLevel() != null) {
            queryWrapper.eq("level", queryTeacherList.getLevel());
        }
        if (queryTeacherList.getJoinDateBegin() != null) {
            queryWrapper.gt("join_date", queryTeacherList.getJoinDateBegin());
        }
        if (queryTeacherList.getJoinDateEnd() != null) {
            queryWrapper.lt("join_date", queryTeacherList.getJoinDateEnd());
        }
        Page<Teacher> teacherPage = teacherMapper.selectPage(pageInfo, queryWrapper);
        return teacherPage;
    }
}
