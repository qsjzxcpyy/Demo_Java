package com.qsj.demo_tests.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/18
 */
@Data
@TableName("test")
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField
    private String name;
    @TableField
    private String content;
}
