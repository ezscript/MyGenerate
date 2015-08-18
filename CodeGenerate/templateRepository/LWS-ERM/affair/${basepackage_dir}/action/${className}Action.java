<#include "/java_copyright.include">
<#assign tableName = table.sqlName>
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLower = className?lower_case>
package ${basepackage}.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
<#if tableName = "P_USER">
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
</#if>
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Controller
@RequestMapping("affair/${classNameLower}")
public class ${className}Action {

	//注入${className}Service
	@Autowired
    private ${className}Service ${classNameFirstLower}Service;
    
    /**
     * 添加 ${className}
     */
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@ResponseBody
    public int saveOrUpdate(@RequestBody ${className} record) {
		return this.${classNameFirstLower}Service.saveOrUpdateAll(record);
    }
	
    
	/**
	 * 修改${className}
	 */
    @RequestMapping(value="/saveUpdateChanges", method=RequestMethod.POST)
    @ResponseBody
    public int saveUpdateChanges(@RequestBody ${className} record) {
    	return this.${classNameFirstLower}Service.saveOrUpdateAll(record);
    }

	<#list table.columns as column>
	<#if column.pk>
	/**
	 * 获得一条${className} 记录
	 */
    @RequestMapping(value="/get", method=RequestMethod.GET)
    @ResponseBody
    public ${className} getById(${column.javaType} id) {
        return this.${classNameFirstLower}Service.getById(id);
    }
    
    /**
     * 删除一条 ${className}
     */
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    @ResponseBody
    public int deleteById(@RequestBody ${className} record) {
    	return this.${classNameFirstLower}Service.deleteById(record.get${table.pkColumns[0].columnName}());
    }
    
	</#if>
	</#list>
    
	/**
	 * 查询所有数据记录
	 */
    @RequestMapping(value="/findAll", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
	public List<${className}> findAll(${className} record) {
		return this.${classNameFirstLower}Service.findAll(record);
	}

	/**
	 * 分页方式查询数据记录
	 * 数据返回map中包含:
	 * 1.总记录数 total;
	 * 2.数据记录 root;
	 */
	//查找分页记录
	@RequestMapping(value="/findPage", method=RequestMethod.POST)
	@ResponseBody
	public String findPage(${className} record, Integer start, Integer limit,String sort) {
		JSONArray sortArray = null;
		if(sort != null && !"".equals(sort)){
			sortArray = JSONArray.fromObject(sort);
		}
		return this.${classNameFirstLower}Service.findPageToJSON(record, start, limit,sortArray).toString();
	}
	
}


