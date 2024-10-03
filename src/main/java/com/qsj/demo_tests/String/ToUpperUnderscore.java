package com.qsj.demo_tests.String;

import com.google.common.base.CaseFormat;

/**
 * @Description
 * @Author qsj
 * @Date 2024/10/03
 */
public class ToUpperUnderscore {
    public static void main(String[] args) {
//        WE_CHAT -> weChat   WECHAT -> wechat
        String wechat = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.LOWER_CAMEL).convert("WE_CHAT");
        System.out.println(wechat);

    }
}
