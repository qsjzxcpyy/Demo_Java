package com.qsj.demo_tests.String;

import java.util.regex.Pattern;

/**
 * @Description
 * @Author qsj
 * @Date 2024/08/07
 */
public class StringReplace {

        public static void main(String[] args) {
            // 示例路径
            String oldPath = "/home/user/folder1/documents/project/folder1/file.txt";
            // 旧文件夹名称
            String oldFolderName = "folder1";
            // 新文件夹名称
            String newFolderName = "newFolder1";

            // 调用方法进行替换
            String updatedPath = replaceLastOccurrence(oldPath, oldFolderName, newFolderName);

            // 输出更新后的路径
            System.out.println("Updated Path: " + updatedPath);
        }

        public static String replaceLastOccurrence(String input, String oldFolderName, String newFolderName) {
            // 构建正则表达式，匹配最后一个旧文件夹名称
            String regex = "(.*)" + Pattern.quote(oldFolderName) + "(?!.*" + Pattern.quote(oldFolderName) + ")";

            // 使用replaceFirst替换最后一个匹配项
            return input.replaceFirst(regex, "$1" + newFolderName);
        }



}
