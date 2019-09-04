package ${package};

import java.io.Serializable;

<#assign dateTime = .now>
<#assign newLine ="\n">
/**
* ${tableClass.shortClassName}${suffix!"Vo"}
*
* @author ${author!"core-generator"} ${dateTime?string["yyyy-MM-dd"]}
*/
@lombok.Data
@lombok.NoArgsConstructor
public class ${tableClass.shortClassName}${suffix!"Vo"} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list (tableClass.allFields) as field>
    // ${field.remarks}
    private ${field.fullTypeName?replace("java.lang.","")} ${field.fieldName};
</#list>

}
