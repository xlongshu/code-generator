<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${tableClass.shortClassName}${mapperSuffix}">

    <resultMap id="BaseResultMap" type="${tableClass.fullClassName}">
        <!--
          WARNING - @mbg.generated
        -->
        <#list (tableClass.allFields) as field>
        <#if field.identity>
        <id column="${field.columnName}" jdbcType="${field.jdbcType}" property="${field.fieldName}"/>
        <#else>
        <result column="${field.columnName}" jdbcType="${field.jdbcType}" property="${field.fieldName}"/>
        </#if>
        </#list>
    </resultMap>

    <#assign newLine ="\n">
    <sql id="QueryColumnFromTable">
        <![CDATA[
        SELECT
        <#list (tableClass.allFields) as field>
            t.${field.columnName} /*${field.remarks}*/<#if field_has_next>,${newLine}</#if></#list>
        FROM ${tableClass.tableName} AS t
        ]]>
    </sql>

    <!--自定义开始-->


</mapper>
