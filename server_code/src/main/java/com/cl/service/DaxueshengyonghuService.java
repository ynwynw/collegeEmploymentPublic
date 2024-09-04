package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaxueshengyonghuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaxueshengyonghuView;


/**
 * 大学生用户
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface DaxueshengyonghuService extends IService<DaxueshengyonghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaxueshengyonghuView> selectListView(Wrapper<DaxueshengyonghuEntity> wrapper);
   	
   	DaxueshengyonghuView selectView(@Param("ew") Wrapper<DaxueshengyonghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaxueshengyonghuEntity> wrapper);
   	

}

