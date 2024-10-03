package com.qsj.demo_tests.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qsj.demo_tests.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/19
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
