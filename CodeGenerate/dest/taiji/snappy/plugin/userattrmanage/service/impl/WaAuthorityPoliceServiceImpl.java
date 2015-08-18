/*
 * Powered By [douniwan]
 * Generate Date:  2015-08-18
 */

package taiji.snappy.plugin.userattrmanage.service.serviceimp;

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

import taiji.snappy.plugin.userattrmanage.mapper.WaAuthorityPoliceMapper;
import taiji.snappy.plugin.userattrmanage.model.WaAuthorityPolice;
import taiji.snappy.plugin.userattrmanage.service.WaAuthorityPoliceService;

@Service("waAuthorityPolice")
public class WaAuthorityPoliceServiceImpl implements WaAuthorityPoliceService {

    @Autowired
    private WaAuthorityPoliceMapper waAuthorityPoliceMapper;
    
    
    public JSONObject save(WaAuthorityPolice record){
    	saveOrUpdateAll(record);
    	return DHJSONUtil.getResultJSON(true, "lb_save_success");
    }
	
	public JSONObject update(WaAuthorityPolice record){
		saveOrUpdateAll(record);
		return DHJSONUtil.getResultJSON(true, "lb_save_success");
	}
	
    
    @Transactional(readOnly=false)
    public int saveOrUpdateAll(WaAuthorityPolice record) {
        if(record.getCertificateCodeMd5() == null) 
            return this.waAuthorityPoliceMapper.save(record);
        else 
            return this.waAuthorityPoliceMapper.update(record);
    }
   
    public WaAuthorityPolice getById(java.lang.String id) {
        return this.waAuthorityPoliceMapper.getById(id);
    }
    
    @Transactional(readOnly=true)
    public int deleteById(java.lang.String id) {
        return this.waAuthorityPoliceMapper.deleteById(id);
    }
    
    
    public List<WaAuthorityPolice> findAll(WaAuthorityPolice record) {
    	return this.findAll(record,RowBounds.DEFAULT);
    }
    
    public List<WaAuthorityPolice> findAll(WaAuthorityPolice record,RowBounds rowBound) {
        return this.waAuthorityPoliceMapper.findAll(record, rowBound,null);
    }
    
    
    
    
    public JSONObject findPageToJSON(WaAuthorityPolice record, Integer start, Integer limit,JSONArray sortArray){
  	  JSONObject map = new JSONObject();
        
        Long total = this.waAuthorityPoliceMapper.getCount(record);
        map.put(Constants.lab_total, total);
        JsonConfig jc = new JsonConfig();
	      jc.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
	      String orderBy = null;
	      if(sortArray != null){
	    	JSONObject jo = sortArray.getJSONObject(0);
	    	orderBy = new StringBuffer(" order by ").append(TableMap.getColName("WaAuthorityPolice", jo.getString("property")))
	    			.append(" ").append(jo.get("direction")).toString();
	      }
        List<WaAuthorityPolice> list = this.waAuthorityPoliceMapper.findPage(record, new RowBounds(start, limit),orderBy);
        
        map.put(Constants.lab_data, JSONArray.fromObject(list,jc));
        
        return map;
        
  }
    
}
