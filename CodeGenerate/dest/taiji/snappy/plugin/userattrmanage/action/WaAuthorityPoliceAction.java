/*
 * Powered By [douniwan]
 * Generate Date:  2015-08-18
 */

package taiji.snappy.plugin.userattrmanage.action;

import java.util.List;
import java.util.Map;
import com.dgtech.base.mybatis.Sort;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhc.common.utils.CommonUtil;
import com.dhc.common.utils.WebUtil;

import taiji.snappy.plugin.userattrmanage.model.WaAuthorityPolice;
import taiji.snappy.plugin.userattrmanage.service.WaAuthorityPoliceService;

@Controller
@RequestMapping("common/waauthoritypolice")
public class WaAuthorityPoliceAction {

	//注入WaAuthorityPoliceService
	@Autowired
    private WaAuthorityPoliceService waAuthorityPoliceService;
    
    /**
     * 添加 WaAuthorityPolice
     */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
    public String save(WaAuthorityPolice record) {
		return this.waAuthorityPoliceService.save(record).toString();
    }
	
    
	/**
	 * 修改WaAuthorityPolice
	 */
    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public String update(WaAuthorityPolice record) {
		return this.waAuthorityPoliceService.update(record).toString();
    }

	/**
	 * 获得一条WaAuthorityPolice 记录
	 */
    @RequestMapping(value="/get", method=RequestMethod.GET)
    @ResponseBody
    public WaAuthorityPolice getById(java.lang.String id) {
        return this.waAuthorityPoliceService.getById(id);
    }
    
    /**
     * 删除一条 WaAuthorityPolice
     */
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    @ResponseBody
    public String deleteById(@RequestBody WaAuthorityPolice record) {
      	JSONObject out = new JSONObject();
	//	out.put("success", "false");
	//	out.put("msg", WebUtil.getLangMessage("save_failure_commit_already"));
    	this.waAuthorityPoliceService.deleteById(record.getCertificateCodeMd5());
		out.put("success", "true");
		out.put("msg", WebUtil.getLangMessage("lb_save_success"));
		out.put("data", JSONObject.fromObject(record));
		return out.toString();
    	
    }
    
    
	/**
	 * 查询所有数据记录
	 */
    @RequestMapping(value="/findAll", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
	public List<WaAuthorityPolice> findAll(WaAuthorityPolice record) {
		return this.waAuthorityPoliceService.findAll(record);
	}

	/**
	 * 分页方式查询数据记录
	 * 数据返回map中包含:
	 * 1.总记录数 total;
	 * 2.数据记录 root;
	 */
	@RequestMapping(value="/findPage", method=RequestMethod.POST)
	@ResponseBody
	public String findPage(WaAuthorityPolice record, Integer start, Integer limit,String sort) {
		JSONArray sortArray = null;
		if(sort != null && !"".equals(sort)){
			sortArray = JSONArray.fromObject(sort);
		}
		return this.waAuthorityPoliceService.findPageToJSON(record, start, limit,sortArray).toString();
	}
	
}


