package com.hongtian.general;//package com.zjjcnt.pz.general;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author weed
 * @date 2020/9/25 0025 17:02
 * @description
 */
public class CodeGenerator {

    // 需要生成的表的名称
    private static String[] tables = {
            "PZT_JMXQ_RLZPJL_DAHUA",
            "PZT_JCSS_JB",
            "PZT_RY_JB"
    };
    //开启swagger
    private static boolean openSwagger = false;
    //生成controller
    private static boolean createController = false;
    //生成service
    private static boolean createService = true;
    //生成mapper
    private static boolean createMapper = true;
    // 生成xml
    private static boolean createXml = true;
    // 生成实体
    private static boolean createEntity = true;

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        com.baomidou.mybatisplus.generator.config.GlobalConfig gc = new com.baomidou.mybatisplus.generator.config.GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
        gc.setFileOverride(true);
        //不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        gc.setSwagger2(openSwagger);
        gc.setBaseResultMap(true); // xml映射
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("weed");
        gc.setOpen(false);

        //自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
//        gc.setMapperName("%sBaseMapper");
//        gc.setXmlName("%sBaseMapper");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@112.17.180.66:41521:orcl");
        // dsc.setSchemaName("public");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("pz2010");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //此处可以修改您的表前缀
        strategy.setTablePrefix(new String[]{});
        //表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //需要生成的表
//        strategy.setSuperControllerClass(ResponseResultCrudController.class);
        strategy.setInclude(tables);
//        strategy.setSuperServiceClass(BaseService.class);
//        strategy.setSuperServiceImplClass(AuthBaseServiceImpl.class);
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);

        strategy.setEntityLombokModel(true);
        strategy.setEntitySerialVersionUID(true);
        strategy.setEntityTableFieldAnnotationEnable(true);

        mpg.setStrategy(strategy);
        // 配置模板
        com.baomidou.mybatisplus.generator.config.TemplateConfig templateConfig = new com.baomidou.mybatisplus.generator.config.TemplateConfig();
        if(!createController) {
            templateConfig.setController(null);
        }
        if(!createService) {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }
        if(!createMapper) {
            templateConfig.setMapper(null);
        }
        if(!createEntity) {
            templateConfig.setEntity(null);
        }
        if(!createXml) {
            templateConfig.setXml(null);
        }
        mpg.setTemplate(templateConfig);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.hongtian");
        pc.setController("web.controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
//        pc.setMapper("baseMapper");
//        pc.setXml("baseMapper.xml");
        pc.setMapper("mapper");
        pc.setXml("mapper.xml");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //执行生成
        mpg.execute();
    }

}
