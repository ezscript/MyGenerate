<#include "/java_copyright.include">
<#assign className = table.className>
package ${basepackage}.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.dgtech.base.mybatis.RowBounds;
import ${basepackage}.model.${className};

public interface ${className}Mapper {
	
	public int save(${className} record);
	
	public int update(${className} record);
	
	<#list table.columns as column>
	<#if column.pk>
	public ${className} getById(${column.javaType} id);
	
	public int deleteById(${column.javaType} id);
	</#if>
	</#list>
	
	public List<${className}> findAll(@Param("record")${className} record, @Param("rowBounds")RowBounds rowBounds,@Param("orderBy")String orderBy);
	
	public Long getCount(@Param("record")${className} record);

	public List<${className}> findPage(@Param("record")${className} record, @Param("rowBounds")RowBounds rowBounds,@Param("orderBy")String orderBy);

	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName[3..]}(${column.javaType} ${column.columnNameLower[3..]?lower_case});
	</#if>
	</#list>
	
}
