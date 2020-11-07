package com.atguigu.guli.service.edu.mapper;

import com.atguigu.guli.service.edu.entity.Subject;
import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
import com.atguigu.guli.service.edu.entity.xml.ExcelSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author abliger
 * @since 2020-11-03
 */
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

    // void saveExcel(List<ExcelSubject> list);

    List<SubjectList> subjectListQuery();
}
