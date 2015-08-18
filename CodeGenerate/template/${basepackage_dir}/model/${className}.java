<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
package ${basepackage}.model;

import java.util.HashMap;
import java.util.Map;

import taiji.snappy.db.DataObject;

<#list table.columns as column>
<#if column.isDateTimeColumn>

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;


import com.dhc.web.utils.DateUtil;


<#break>
</#if>
</#list>
public class ${className} {
	
	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	
	<#break>
	</#if>
	</#list>
	<#list table.columns as column>
    /**
     * ${column.columnAlias}
     * ${column.sqlName}
     */	
	<#if column.isDateTimeColumn && !column.contains("begin,end")>
	@DateTimeFormat( pattern = DateUtil.PATTERN_DATE)
	private ${column.javaType} ${column.columnNameLower}Begin;
	@DateTimeFormat( pattern = DateUtil.PATTERN_DATE)
	private ${column.javaType} ${column.columnNameLower}End;
	
	</#if>
	
	<#if column.isDateTimeColumn >
	@DateTimeFormat( pattern = DateUtil.PATTERN_DATE)
	</#if>
	private ${column.javaType} ${column.columnNameLower};
	
	</#list>
	
<@generateConstructor className/>
<@generateJavaColumns/>

<#macro generateJavaColumns>
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	
	@JsonIgnore
	public ${column.javaType} get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}

	public void set${column.columnName}Begin(${column.javaType} value) {
		this.${column.columnNameLower}Begin = value;
	}	
	
	@JsonIgnore
	public ${column.javaType} get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}

	public void set${column.columnName}End(${column.javaType} value) {
		this.${column.columnNameLower}End = DateUtil.next(value);
	}

	</#if>	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}

	
	</#list>
</#macro>

	public static ${className} create(DataObject dataObject){
		${className} a = new ${className}();
	<#list table.columns as column>
		a.${column.columnNameLower}  = dataObject.get${column.simpleJavaType}("${column.columnNameLower}");
	</#list>
		return a;
	}

	

}