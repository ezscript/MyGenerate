<#include "/java_copyright.include">
<#assign tableName = table.sqlName>
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLower = className?lower_case>
package ${basepackage}.action;

import java.util.List;
import java.util.Map;
import com.dgtech.base.mybatis.Sort;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
<#if tableName = "P_USER">
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
</#if>
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhc.common.utils.CommonUtil;
import com.dhc.common.utils.WebUtil;

import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

@Controller
@RequestMapping("${simplepackage}/${classNameLower}")
public class ${className}Action {

	//注入${className}Service
	@Autowired
    private ${className}Service ${classNameFirstLower}Service;
    
    /**
     * 添加 ${className}
     */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
    public String save(${className} record) {
		return this.${classNameFirstLower}Service.save(record).toString();
    }
	
    
	/**
	 * 修改${className}
	 */
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public String update(${className} record) {
		return this.${classNameFirstLower}Service.update(record).toString();
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
    public String deleteById(@RequestBody ${className} record) {
      	JSONObject out = new JSONObject();
	//	out.put("success", "false");
	//	out.put("msg", WebUtil.getLangMessage("save_failure_commit_already"));
    	this.${classNameFirstLower}Service.deleteById(record.get${table.pkColumns[0].columnName}());
		out.put("success", "true");
		out.put("msg", WebUtil.getLangMessage("lb_save_success"));
		out.put("data", JSONObject.fromObject(record));
		return out.toString();
    	
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


