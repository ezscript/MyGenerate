/*
 * Powered By [douniwan]
 * Generate Date:  2015-08-18
 */

package taiji.snappy.plugin.userattrmanage.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dgtech.base.mybatis.RowBounds;
import com.dgtech.base.mybatis.Sort;

import taiji.snappy.plugin.userattrmanage.model.WaAuthorityPolice;

public interface WaAuthorityPoliceService {
	
	public JSONObject save(WaAuthorityPolice record);
	
	public JSONObject update(WaAuthorityPolice record);
	
	public int saveOrUpdateAll(WaAuthorityPolice record);

	public WaAuthorityPolice getById(java.lang.String id);
	
	public int deleteById(java.lang.String id);
	
	public List<WaAuthorityPolice> findAll(WaAuthorityPolice record);
	
	public List<WaAuthorityPolice> findAll(WaAuthorityPolice record,RowBounds rowBound);
	
	
	public JSONObject findPageToJSON(WaAuthorityPolice record, Integer start, Integer limit,JSONArray sortArray);
}
