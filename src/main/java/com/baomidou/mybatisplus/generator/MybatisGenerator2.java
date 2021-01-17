package com.baomidou.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zjh
 * @date {2020年6月28日16:55:30}
 */
public class MybatisGenerator2 {

    private static final String PROJNAME = "linkey";
    private static final String PARENT_PACKAGE = "com";
    private static final String RELATIVE_PATH = "/com";
    private static final String AUTHOR = "zhujh";
    private static final String CONNECTURL = "jdbc:mysql://localhost:3306/linkey?useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String moduleName = scanner("请输入模块名");
        String[] tableNames = scanner("请输入表名（多个表用英文逗号分隔）").split(",");

        /**
         * 创建代码生成器
         */
        AutoGenerator mpg = new AutoGenerator();
        //指定模板引擎  默认velocity

        /**
         * 全局配置
         */
        GlobalConfig gc = new GlobalConfig();
        gc.setOpen(false);
        String projectPath = System.getProperty("user.dir") + "/" + PROJNAME;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setAuthor(AUTHOR);
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);
        /**
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl(CONNECTURL);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);
        /**
         * 策略配置
         */
        StrategyConfig sc = new StrategyConfig();
        /**
         * 表名前缀
         */
        sc.setTablePrefix("");
        /**
         * 表名生成策略
         */
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setEntityBuilderModel(true);
        sc.setEntityLombokModel(true);
        sc.setInclude(tableNames);
        mpg.setStrategy(sc);
        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT_PACKAGE);
        pc.setModuleName(moduleName);
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        /**
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        /**
         *  自定义输出配置
         */
        List<FileOutConfig> focList = new ArrayList<>();
        /**
         * 如果模板引擎是 vm
         */
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath
                    + "/src/main/resources" + "/mapper/" + moduleName  + "/"
                    + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        String templatePathMapperJava = "/templates/mapper.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePathMapperJava) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath
                    + "/src/main/java" + RELATIVE_PATH + "/"  + moduleName  + "/mapper/"
                    + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        String templatePathControllerJava = "/templates/controller.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePathControllerJava) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath
                    + "/src/main/java" + RELATIVE_PATH + "/"  + moduleName  + "/controller/"
                    + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });
        String templatePathEntityJava = "/templates/entity.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePathEntityJava) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath
                    + "/src/main/java" + RELATIVE_PATH + "/"  + moduleName  + "/entity/"
                    + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        String templatePathEnumJava = "/templates/enum.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePathEnumJava) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath
                        + "/src/main/java" + RELATIVE_PATH + "/"  + moduleName  + "/enums/"
                        + tableInfo.getEnumName() + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /**
         * 配置模板
         */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setMapper(null);
        templateConfig.setController(null);
        templateConfig.setEntity(null);
        templateConfig.setEnumName(null);
        mpg.setTemplate(templateConfig);

        mpg.execute();
    }
}
