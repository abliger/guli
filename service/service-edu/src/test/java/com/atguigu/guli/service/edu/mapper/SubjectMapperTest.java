package com.atguigu.guli.service.edu.mapper;

import com.atguigu.guli.service.edu.entity.admin.Query.SubjectList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author abliger
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectMapperTest {
    @Autowired
    private SubjectMapper subjectMapper;
    @Test
    public void subjectMapperTest(){
        final List<SubjectList> list = subjectMapper.subjectListQuery();
        System.out.println(list);
    }
}
