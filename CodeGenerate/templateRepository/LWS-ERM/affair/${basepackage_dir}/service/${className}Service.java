<#include "/java_copyright.include">
<#assign tableName = table.sqlName>
<#assign className = table.className>
package ${basepackage}.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.dgtech.base.mybatis.RowBounds;

import ${basepackage}.model.${className};

public interface ${className}Service {
	
	public int saveOrUpdateAll(${className} record);

	<#list table.columns as column>
	<#if column.pk>
	public ${className} getById(${column.javaType} id);
	
	public int deleteById(${column.javaType} id);
	</#if>
	</#list>
	
	public List<${className}> findAll(${className} record);
	
	public List<${className}> findAll(${className} record,RowBounds rowBound);
	
	public JSONObject findPageToJSON(${className} record, Integer start, Integer limit,JSONArray sortArray);
	
	public Map<String, ?> findPage(${className} record, Integer start, Integer limit);
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName[3..]}(${column.javaType} ${column.columnNameLower[3..]?lower_case});
	</#if>
	</#list>
}
