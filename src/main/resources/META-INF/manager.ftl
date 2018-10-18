package ${package};

import ${baseManager};
import ${tableClass.fullClassName};

<#assign dateTime = .now>
/**
 * ${tableClass.shortClassName}Manager
 *
 * @author ${author!"code-generator"} ${dateTime?string["yyyy-MM-dd"]}
 */
@javax.inject.Named
public class ${tableClass.shortClassName}Manager extends BaseManager<${tableClass.shortClassName}> {
    /*
     * 自定义扩展
     */

}
