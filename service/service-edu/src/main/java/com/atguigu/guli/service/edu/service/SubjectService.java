package com.atguigu.guli.service.edu.service;

import com.atguigu.guli.service.edu.entity.Subject;
import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
import com.atguigu.guli.service.edu.entity.xml.ExcelSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author abliger
 * @since 2020-11-03
 */
public interface SubjectService extends IService<Subject> {

    void saveExcel(MultipartFile file);

    void saveExcel(List<ExcelSubject> list);

    List<SubjectList> subjectListQuery();

}
