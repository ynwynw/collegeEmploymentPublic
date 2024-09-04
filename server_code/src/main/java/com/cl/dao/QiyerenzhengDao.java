package com.cl.dao;

import com.cl.entity.QiyerenzhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyerenzhengView;


/**
 * 企业认证
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface QiyerenzhengDao extends BaseMapper<QiyerenzhengEntity> {
	
	List<QiyerenzhengView> selectListView(@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);

	List<QiyerenzhengView> selectListView(Pagination page,@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);
	
	QiyerenzhengView selectView(@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);



}