package com.cl.dao;

import com.cl.entity.MianshiyaoqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MianshiyaoqingView;


/**
 * 面试邀请
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
public interface MianshiyaoqingDao extends BaseMapper<MianshiyaoqingEntity> {
	
	List<MianshiyaoqingView> selectListView(@Param("ew") Wrapper<MianshiyaoqingEntity> wrapper);

	List<MianshiyaoqingView> selectListView(Pagination page,@Param("ew") Wrapper<MianshiyaoqingEntity> wrapper);
	
	MianshiyaoqingView selectView(@Param("ew") Wrapper<MianshiyaoqingEntity> wrapper);
	

}
