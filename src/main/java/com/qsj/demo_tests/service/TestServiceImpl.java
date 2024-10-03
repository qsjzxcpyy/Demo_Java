// TestServiceImpl.java
package com.qsj.demo_tests.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qsj.demo_tests.entity.Test;
import com.qsj.demo_tests.mappers.TestMapper;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
}