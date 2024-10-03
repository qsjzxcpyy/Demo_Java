package com.qsj.demo_tests.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qsj.demo_tests.entity.Student;
import com.qsj.demo_tests.mappers.StudentMapper;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/19
 */
@Service
public class StudentServiceImp extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
