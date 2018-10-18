package ${package};

import ${baseService};
import ${tableClass.fullClassName};
import ${managerPackage}.${tableClass.shortClassName}Manager;

<#assign dateTime = .now>
/**
 * ${tableClass.shortClassName}Service
 *
 * @author ${author!"code-generator"} ${dateTime?string["yyyy-MM-dd"]}
 */
@javax.inject.Named
public class ${tableClass.shortClassName}Service extends BaseService<${tableClass.shortClassName}Manager, ${tableClass.shortClassName}> {
    /*
     * 自定义扩展
     */

}
