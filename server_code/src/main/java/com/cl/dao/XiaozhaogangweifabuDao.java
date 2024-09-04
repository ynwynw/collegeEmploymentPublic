package com.cl.dao;

import com.cl.entity.XiaozhaogangweifabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaozhaogangweifabuView;


/**
 * 校招岗位发布
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface XiaozhaogangweifabuDao extends BaseMapper<XiaozhaogangweifabuEntity> {
	
	List<XiaozhaogangweifabuView> selectListView(@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);

	List<XiaozhaogangweifabuView> selectListView(Pagination page,@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);
	
	XiaozhaogangweifabuView selectView(@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);



}
