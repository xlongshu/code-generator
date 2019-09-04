package mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * LombokPlugin
 * https://github.com/softwareloop/mybatis-generator-lombok-plugin
 *
 * @author LongShu 2018/02/01
 */
public class LombokPlugin extends PluginAdapter {

    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    protected Date now = new Date();
    protected FullyQualifiedJavaType serializable;

    protected String author;
    protected boolean addSerializable;


    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        author = properties.getProperty("author", "code-generator");
        addSerializable = Boolean.valueOf(properties.getProperty("addSerializable"));
        serializable = new FullyQualifiedJavaType("java.io.Serializable");
    }

    void addLombokAnnotation(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @since " + dateFormat.format(now));
        topLevelClass.addJavaDocLine(" */");

//        topLevelClass.addImportedType("lombok.experimental.Accessors");

        topLevelClass.addAnnotation("@lombok.Getter");
        topLevelClass.addAnnotation("@lombok.Setter");
        topLevelClass.addAnnotation("@lombok.ToString");
//        topLevelClass.addAnnotation("@Accessors(chain = true)");
        topLevelClass.addAnnotation("@lombok.NoArgsConstructor");
    }

    protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (addSerializable) {
            topLevelClass.addImportedType(serializable);
            topLevelClass.addSuperInterface(serializable);
        }

        Field field = new Field();
        field.setFinal(true);
        field.setInitializationString("1L");
        field.setName("serialVersionUID");
        field.setStatic(true);
        field.setType(new FullyQualifiedJavaType("long"));
        field.setVisibility(JavaVisibility.PRIVATE);
        context.getCommentGenerator().addFieldComment(field, introspectedTable);

        topLevelClass.addField(field);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addAnnotation("@javax.inject.Named");
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addLombokAnnotation(topLevelClass, introspectedTable);
        makeSerializable(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

}
