# linkey-mybatis-plus-generator
基于官方mybatis-plus-generator3.3.0 增强-生成枚举类


## 增强说明
根据表字段**tinyint**数据类型以及特定注释格式生成枚举类
注释格式必须要符合      **设备故障状态：{0：异常 ， 1：正常}**          这种格式下才能正常解析生成     
**注：注释中的冒号与逗号均为中文符号**
现仅支持mysql与vm模板，其他可根据源码自行扩展


### 例子

| 名      |    类型 | 注释  |
| :-------- | --------:| :--: |
| id  | bigint |  主键   |
| **sex**     |   **tinyint** | **年龄：{0：男 ， 1：女}** |
| **is_good**     |   **tinyint** | **是否优秀学生：{0：否 ， 1：是}** |
| birth      |    datetime | 生日  |

程序会自动筛选sex和is_good为枚举类

生成enum格式类如下
public class TableEnum {

     // 性别枚举
      public enum SexEnum {
        SEX_0(0, "男"),
        SEX_1(1, "女"),
              ;

        private Integer key;
        private String value;

        SexEnum(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        static public SexEnum get(Integer key) {
            for (SexEnum e : SexEnum.values()) {
                if (e.getKey().equals(key)) {
                    return e;
                }
            }
            return SEX_0;
        }
    }

    // 是否优秀学生枚举
    public enum IsGoodEnum {
        IS_GOOD_0(0, "否"),
        IS_GOOD_1(1, "是"),
              ;

        private Integer key;
        private String value;

        IsGoodEnum(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        static public IsGoodEnum get(Integer key) {
            for (IsGoodEnum e : IsGoodEnum.values()) {
                if (e.getKey().equals(key)) {
                    return e;
                }
            }
            return IS_GOOD_0;
        }
    }
}



## 启动类配置
         String templatePathEnumJava = "/templates/enum.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePathEnumJava) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath
                        + "/src/main/java" + RELATIVE_PATH + "/"  + moduleName  + "/enums/"
                        + tableInfo.getEnumName() + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        
        
        ........
        
        
        templateConfig.setEnumName(null);  
        
        
        
       
 ## 本项目启动类为 MybatisGenerator.java




## 后续优化
1.生成枚举类中的默认枚举应该取表中字段的默认值


## 反馈与建议
- 作者：zjh
- 邮箱：<zhujinghuic@163.com>
- QQ  : 375506762
