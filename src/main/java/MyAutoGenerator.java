import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.List;

public class MyAutoGenerator extends AutoGenerator {

    @Override
    protected List<TableInfo> getAllTableInfoList(ConfigBuilder config) {
        List<TableInfo> tableInfos =  super.getAllTableInfoList(config);
        tableInfos.forEach(t->{
            t.getFields().forEach(f->{
                if(org.apache.commons.lang3.StringUtils.isNotBlank(f.getComment())) {
                    String comment = f.getComment();
                    comment = comment.replaceAll("\r\n" , "");
                    f.setComment(comment);
                }
            });
        });
        return tableInfos;
    }


}
