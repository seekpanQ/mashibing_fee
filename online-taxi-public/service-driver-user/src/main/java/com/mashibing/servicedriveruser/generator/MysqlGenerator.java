package com.mashibing.servicedriveruser.generator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {

    public static String url = "jdbc:mysql://192.168.91.128:3306/service-driver-user?characterEncoding=utf-8&serverTimezone=GMT%2B8";
    public static String userName = "root";
    public static String password = "123456";
    public static String author = "Lison";
    public static String tableName = "driver_user_work_status";
    public static String globalDir = "E:\\study\\mashibing_fee\\code\\learning\\online-taxi-public\\service-driver-user\\src\\main\\java";
    public static String mapperPath = "E:\\study\\mashibing_fee\\code\\learning\\online-taxi-public\\service-driver-user\\src\\main\\java\\com\\mashibing\\servicedriveruser\\mapper";
    public static String parentDir = "com.mashibing.servicedriveruser";

    public static void main(String[] args) {

        FastAutoGenerator.create(url, userName, password).globalConfig(builder -> {
            builder.author(author).fileOverride().outputDir(globalDir);
        }).packageConfig(builder -> {
            builder.parent(parentDir).
                    pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperPath));
        }).strategyConfig(builder -> {
            builder.addInclude(tableName);
        }).templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}
