package com.qsj.demo_tests.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/19
 */
@Data
@TableName("student")

public class Student {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField
    private String name;
    @TableField
    private Integer age;
    @TableField
    private String sex;
    @TableField
    private String address;
}
