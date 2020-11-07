package com.atguigu.guli.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.atguigu.guli.service.edu.entity.Subject;
import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
import com.atguigu.guli.service.edu.entity.xml.ExcelSubject;
import com.atguigu.guli.service.edu.mapper.SubjectMapper;
import com.atguigu.guli.service.edu.service.SubjectService;
import com.atguigu.guli.service.edu.util.DataParseExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author abliger
 * @since 2020-11-03
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void saveExcel(MultipartFile file) {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        try {
            ExcelReaderBuilder read = EasyExcel.read(file.getInputStream(), ExcelSubject.class, new DataParseExcel(this));
            read.sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveExcel(List<ExcelSubject> list) {
        for (ExcelSubject excelSubject : list) {
            final String levelOneTitle = excelSubject.getLevelOneTitle();
            final String levelTwoTitle = excelSubject.getLevelTwoTitle();
            QueryWrapper<Subject> querywrapper=new QueryWrapper<>();
            querywrapper.eq("title",levelOneTitle);
            Subject subject = subjectMapper.selectOne(querywrapper);
            //查詢父标题，如果存在不插入，如果不存在插入父标题，parent_id=0 sort 0
            Subject entity=new Subject();
            entity.setSort(0);
            entity.setParentId("0");
            entity.setTitle(levelOneTitle);
            String parent_id=entity.getId();
            if (subject==null){
                subjectMapper.insert(entity);
                parent_id=entity.getId();
            }else{//如果查询到父id
                parent_id=subject.getId();
                querywrapper.clear();
                querywrapper.eq("parent_id",entity.getId())
                .eq("title",levelTwoTitle);
                subject = subjectMapper.selectOne(querywrapper);
            }
            if (subject==null) {
                entity=new Subject();
                entity.setParentId(parent_id);
                entity.setTitle(levelTwoTitle);
                subjectMapper.insert(entity);
            }
        }
    }

    @Override
    public List<SubjectList> subjectListQuery() {
        List<SubjectList> list = subjectMapper.subjectListQuery();
        return list;
    }
}
