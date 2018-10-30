package ${package};

import ${baseDao};
import ${tableClass.fullClassName};

<#assign dateTime = .now>
/**
 * ${tableClass.shortClassName}${mapperSuffix!"Dao"} -> ${tableClass.tableName}
 *
 * @author ${author!"core-generator"} ${dateTime?string["yyyy-MM-dd"]}
 */
@javax.inject.Named
public interface ${tableClass.shortClassName}${mapperSuffix} extends Base${mapperSuffix!"Dao"}<${tableClass.shortClassName}> {
    /*
     * 自定义扩展
     */

}
