package com.cl.dao;

import com.cl.entity.QiyeyonghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeyonghuView;


/**
 * 企业用户
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface QiyeyonghuDao extends BaseMapper<QiyeyonghuEntity> {
	
	List<QiyeyonghuView> selectListView(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);

	List<QiyeyonghuView> selectListView(Pagination page,@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
	
	QiyeyonghuView selectView(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
	

}
