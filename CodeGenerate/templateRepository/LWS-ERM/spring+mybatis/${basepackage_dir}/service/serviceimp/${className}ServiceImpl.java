<#include "/java_copyright.include">
<#assign tableName = table.sqlName>
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first> 
package ${basepackage}.service.serviceimp;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgtech.base.mybatis.RowBounds;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Service("${classNameFirstLower}")
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Mapper ${classNameFirstLower}Mapper;
    
    @Transactional(readOnly=false)
    public int saveOrUpdateAll(${className} record) {
        if(record.get${table.idColumn.columnName}() == null) 
            return this.${classNameFirstLower}Mapper.save(record);
        else 
            return this.${classNameFirstLower}Mapper.update(record);
    }
   
    <#list table.columns as column>
    <#if column.pk>
    public ${className} getById(${column.javaType} id) {
        return this.${classNameFirstLower}Mapper.getById(id);
    }
    
    @Transactional(readOnly=true)
    public int deleteById(${column.javaType} id) {
        return this.${classNameFirstLower}Mapper.deleteById(id);
    }
    
    </#if>
    </#list>
    
    public List<${className}> findAll(${className} record) {
    	return this.findAll(record,RowBounds.DEFAULT);
    }
    
    public List<${className}> findAll(${className} record,RowBounds rowBound) {
        return this.${classNameFirstLower}Mapper.findPage(record, rowBound);
    }
    
    public Map<String, ?> findPage(${className} record, Integer start, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        
        Long total = this.${classNameFirstLower}Mapper.getCount(record);
        map.put("total", total);
        
        List<${className}> list = this.${classNameFirstLower}Mapper.findPage(record, new RowBounds(start, limit));
        map.put("data", list);

        return map;
    }
    
    <#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} getBy${column.columnName[3..]}(${column.javaType} ${column.columnNameLower[3..]?lower_case}) {
        return this.${classNameFirstLower}Mapper.getBy${column.columnName[3..]}(${column.columnNameLower[3..]?lower_case});
    }
    </#if>
    </#list>
    
}
