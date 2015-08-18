<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
package ${basepackage}.model;

<#list table.columns as column>
<#if column.isDateTimeColumn>

import org.codehaus.jackson.annotate.JsonIgnore;


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
	private ${column.javaType} ${column.columnNameLower}Begin;
	
	private ${column.javaType} ${column.columnNameLower}End;
	
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
	
	<#if column.isDateTimeColumn>
	public void set${column.columnName}(java.lang.Object value) {
		if (value == null)
			this.${column.columnNameLower} = null;
		else if (value instanceof java.util.Date)
			this.${column.columnNameLower} = (java.util.Date)value;
		else {
			this.${column.columnNameLower} = new java.util.Date();
			this.${column.columnNameLower}.setTime(Long.valueOf(value.toString()));
		}
	}
	
	<#else>
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}

	</#if>
	</#list>
</#macro>
}