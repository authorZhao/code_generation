
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class RunApp {

    // 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        String names = """
                act_affirm_t,
                act_affirm_user_t,
                activity_display_t,
                admin_assets_t,
                ai_teach_stat_t,
                ban_log_t,
                ban_t,
                cd_key_order_t,
                cd_key_t,
                certificate_support_t,
                certificate_t,
                chat_log_t,
                chat_t,
                clock_log_t,
                clock_mark_t,
                clock_record_t,
                clock_stat_agg_t,
                clock_stat_best_t,
                clock_stat_t,
                comp_1v1_record_t,
                comp_multi_record_t,
                cube_clone_record_t,
                discuss_praise_t,
                discuss_t,
                equipment_affirm_t,
                equipment_brake_through_t,
                equipment_gm_t,
                equipment_t,
                exchange_order_t,
                friend_presented_t,
                global_data_kv,
                gm_disaffirm_log_t,
                helper_t,
                index_t,
                invitation_code_t,
                issue_t,
                league_t,
                log_activity_affirm,
                log_activity_rank_city,
                log_comp_1v1,
                log_comp_multi,
                log_cube_clone,
                log_double_11_badge_collect,
                log_double_11_h5_click,
                log_double_11_invitation_code,
                log_equipment_disaffirm,
                log_helper_words_search,
                log_lotto_turn,
                log_play_time,
                log_start_device,
                log_user_equipment_conn,
                log_user_item,
                log_user_login_logout,
                log_user_money,
                log_user_online,
                log_user_register,
                log_user_task,
                major_appeal_t,
                major_competitor_name_t,
                major_competitor_t,
                major_rank_t,
                major_room_record_t,
                major_room_user_record_t,
                major_t,
                mute_log_t,
                mute_t,
                off_event_kv,
                old_acc,
                play_score_t,
                play_time_t,
                questionnaire_t,
                questionnaire_text_t,
                rank_cube_clone_stat,
                rank_league_time_trial_stat,
                rank_qualifier_stat,
                rank_sp_university_time_trial_t,
                rank_sp_youth_time_trial_t,
                rank_special_list,
                rank_standard_clock_stat,
                rank_time_trial_stat,
                report_t,
                review_note_t,
                review_solution_t,
                review_t,
                shop_exchange_code_t,
                sys_inform_t,
                terminal_t,
                time_trial_record_t,
                train_defined_share_formula_t,
                train_defined_share_repo_t,
                train_formula_t,
                train_log_t,
                train_record_t,
                train_solution_share_t,
                train_solution_t,
                train_t,
                user_acc_closed_t,
                user_acc_closing_t,
                user_acc_t,
                user_activity_t,
                user_ai_teach_t,
                user_assets_t,
                user_closed_t,
                user_comp_1v1_t,
                user_comp_multi_t,
                user_comp_multi_team_t,
                user_cube_clone_t,
                user_cube_t,
                user_custom_avatar_t,
                user_goal_t,
                user_inform_t,
                user_league_t,
                user_league_time_trial_t,
                user_major_t,
                user_misc_t,
                user_qualifier_t,
                user_relation_t,
                user_t,
                user_time_t,
                user_time_trial_t,
                user_token_t
                """;
        String collect = Arrays.stream(names.split(",\n")).peek(String::trim).collect(Collectors.joining(","));
        return collect;
        /*Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");*/
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new MyAutoGenerator();
        //AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");//获得当前类的路径
        String projectPath = "E:\\java\\workspace\\space2\\app-backend\\backend-mysql";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setBaseResultMap(true);//生成映射map
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);//文件覆盖
        gc.setAuthor("authorZhao");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setServiceName("%sManage");
        //gc.setActiveRecord(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://203.195.155.15:3316/cube?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.cube.mysql");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setXml("cube");
        pc.setServiceImpl("manage.impl");
        pc.setService("manage");


        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


     /*   focList.add(new FileOutConfig("/templates/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/" + pc.getParent()+ (org.apache.commons.lang3.StringUtils.isBlank(pc.getModuleName())?"":pc.getModuleName())
                        + "/" +"mapper/"+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */



        // 自定义  service 生成
  /*      focList.add(new FileOutConfig("/templates/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/java/" + pc.getModuleName()
                        + "/" +"service/"+ tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");

        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setNameConvert(new INameConvert() {
            @Override
            public String entityNameConvert(TableInfo tableInfo) {
                String name = tableInfo.getName();
                char c = name.charAt(0);
                if(name.endsWith("_t")){
                    return String.valueOf(c).toUpperCase()+CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name.substring(1,name.length()-2));
                }
                return String.valueOf(c).toUpperCase()+CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name.substring(1));
            }

            @Override
            public String propertyNameConvert(TableField field) {
                return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,field.getName());
            }
        });
        mpg.setStrategy(strategy);

        /*VelocityTemplateEngine engine = new VelocityTemplateEngine();
        ConfigBuilder configBuilder = new ConfigBuilder(pc,dsc,strategy,templateConfig,gc);
        List<TableInfo> tableInfos = configBuilder.getTableInfoList();

        engine.setConfigBuilder(configBuilder);
        mpg.setTemplateEngine(engine);*/
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }


}
