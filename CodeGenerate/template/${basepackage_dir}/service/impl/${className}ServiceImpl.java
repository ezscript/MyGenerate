<#include "/java_copyright.include">
<#assign tableName = table.sqlName>
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first> 
package ${basepackage}.service.serviceimp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgtech.base.mybatis.RowBounds;
import com.dgtech.base.mybatis.Sort;
import com.dgtech.base.mybatis.TableMap;
import com.dhc.common.constants.Constants;
import com.dhc.common.utils.DHJSONUtil;
import com.dhc.web.utils.DateJsonValueProcessor;

import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Service("${classNameFirstLower}")
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Mapper ${classNameFirstLower}Mapper;
    
    
    public JSONObject save(${className} record){
    	saveOrUpdateAll(record);
    	return DHJSONUtil.getResultJSON(true, "lb_save_success");
    }
	
	public JSONObject update(${className} record){
		saveOrUpdateAll(record);
		return DHJSONUtil.getResultJSON(true, "lb_save_success");
	}
	
    
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
        return this.${classNameFirstLower}Mapper.findAll(record, rowBound,null);
    }
    
    
    
    <#list table.columns as column>
    <#if column.unique && !column.pk>
    public ${className} getBy${column.columnName[3..]}(${column.javaType} ${column.columnNameLower[3..]?lower_case}) {
        return this.${classNameFirstLower}Mapper.getBy${column.columnName[3..]}(${column.columnNameLower[3..]?lower_case});
    }
    </#if>
    </#list>
    
    public JSONObject findPageToJSON(${className} record, Integer start, Integer limit,JSONArray sortArray){
  	  JSONObject map = new JSONObject();
        
        Long total = this.${classNameFirstLower}Mapper.getCount(record);
        map.put(Constants.lab_total, total);
        JsonConfig jc = new JsonConfig();
	      jc.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
	      String orderBy = null;
	      if(sortArray != null){
	    	JSONObject jo = sortArray.getJSONObject(0);
	    	orderBy = new StringBuffer(" order by ").append(TableMap.getColName("${className}", jo.getString("property")))
	    			.append(" ").append(jo.get("direction")).toString();
	      }
        List<${className}> list = this.${classNameFirstLower}Mapper.findPage(record, new RowBounds(start, limit),orderBy);
        
        map.put(Constants.lab_data, JSONArray.fromObject(list,jc));
        
        return map;
        
  }
    
}
