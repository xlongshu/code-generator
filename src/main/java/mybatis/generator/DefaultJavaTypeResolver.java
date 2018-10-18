package mybatis.generator;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * DefaultJavaTypeResolver
 *
 * @author LongShu 2018/02/01
 */
public class DefaultJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public DefaultJavaTypeResolver() {
        super();

        typeMap.put(Types.TIME, new JdbcTypeInformation("TIME",
                new FullyQualifiedJavaType(java.sql.Time.class.getName())));

        typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));

        typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT",
                new FullyQualifiedJavaType(Integer.class.getName())));

    }

}