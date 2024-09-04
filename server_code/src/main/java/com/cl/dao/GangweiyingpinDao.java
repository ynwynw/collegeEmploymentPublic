package com.cl.dao;

import com.cl.entity.GangweiyingpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GangweiyingpinView;


/**
 * 岗位应聘
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
public interface GangweiyingpinDao extends BaseMapper<GangweiyingpinEntity> {
	
	List<GangweiyingpinView> selectListView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);

	List<GangweiyingpinView> selectListView(Pagination page,@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	
	GangweiyingpinView selectView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	

}
