package ${package};

import ${tableClass.fullClassName};
import ${servicePackage}.${tableClass.shortClassName}Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<#assign dateTime = .now>
/**
 * ${tableClass.shortClassName}Controller
 *
 * @author ${author!"LongShu"} ${dateTime?string["yyyy-MM-dd"]}
 */
@Controller
@RequestMapping("/${tableClass.variableName}")
public class ${tableClass.shortClassName}Controller extends BaseController<${tableClass.shortClassName}Service> {

}
