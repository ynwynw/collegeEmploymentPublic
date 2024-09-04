package com.cl.dao;

import com.cl.entity.DaxueshengyonghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaxueshengyonghuView;


/**
 * 大学生用户
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface DaxueshengyonghuDao extends BaseMapper<DaxueshengyonghuEntity> {
	
	List<DaxueshengyonghuView> selectListView(@Param("ew") Wrapper<DaxueshengyonghuEntity> wrapper);

	List<DaxueshengyonghuView> selectListView(Pagination page,@Param("ew") Wrapper<DaxueshengyonghuEntity> wrapper);
	
	DaxueshengyonghuView selectView(@Param("ew") Wrapper<DaxueshengyonghuEntity> wrapper);
	

}
