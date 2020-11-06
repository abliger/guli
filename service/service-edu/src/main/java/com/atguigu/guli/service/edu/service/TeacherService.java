package com.atguigu.guli.service.edu.service;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.admin.Query.QueryTeacherList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author abliger
 * @since 2020-11-03
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> getTeacherListByPage(String page, String limit, QueryTeacherList queryTeacherList);
}
