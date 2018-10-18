package ${package};

import ${tableClass.fullClassName};
import ${mapperPackage}.${tableClass.shortClassName}${mapperSuffix!"Dao"};

<#assign dateTime = .now>
/**
 * ${tableClass.shortClassName}Service
 *
 * @author ${author!"code-generator"} ${dateTime?string["yyyy-MM-dd"]}
 */
@javax.inject.Named
public class ${tableClass.shortClassName}Service extends BaseService<${tableClass.shortClassName}${mapperSuffix!"Dao"}, ${tableClass.shortClassName}> {
    /*
     * 自定义扩展
     */

}
