package com.qsj.demo_tests.ES.doc;

import com.qsj.demo_tests.mappers.TestMapper;
import com.qsj.demo_tests.service.StudentService;
import com.qsj.demo_tests.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/18
 */
@SpringBootTest
public class docTest {
    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;
    @Resource
    private StudentService studentService;

    @Test
    public void test() {
        testService.getBaseMapper().selectList(null).forEach(System.out::println);
    }
    @Test
    public void test2() {
        List<com.qsj.demo_tests.entity.Test> tests = testMapper.selectList(null);
        tests.forEach(System.out::println);
    }

    @Test
    public void test3() {
        studentService.list().forEach(System.out::println);
    }



}
