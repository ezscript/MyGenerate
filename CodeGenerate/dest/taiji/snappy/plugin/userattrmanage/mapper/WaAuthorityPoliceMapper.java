/*
 * Powered By [douniwan]
 * Generate Date:  2015-08-18
 */

package taiji.snappy.plugin.userattrmanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.dgtech.base.mybatis.RowBounds;
import taiji.snappy.plugin.userattrmanage.model.WaAuthorityPolice;

public interface WaAuthorityPoliceMapper {
	
	public int save(WaAuthorityPolice record);
	
	public int update(WaAuthorityPolice record);
	
	public WaAuthorityPolice getById(java.lang.String id);
	
	public int deleteById(java.lang.String id);
	
	public List<WaAuthorityPolice> findAll(@Param("record")WaAuthorityPolice record, @Param("rowBounds")RowBounds rowBounds,@Param("orderBy")String orderBy);
	
	public Long getCount(@Param("record")WaAuthorityPolice record);

	public List<WaAuthorityPolice> findPage(@Param("record")WaAuthorityPolice record, @Param("rowBounds")RowBounds rowBounds,@Param("orderBy")String orderBy);

	
}
