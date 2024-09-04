package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MianshiyaoqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MianshiyaoqingView;


/**
 * 面试邀请
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
public interface MianshiyaoqingService extends IService<MianshiyaoqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshiyaoqingView> selectListView(Wrapper<MianshiyaoqingEntity> wrapper);
   	
   	MianshiyaoqingView selectView(@Param("ew") Wrapper<MianshiyaoqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshiyaoqingEntity> wrapper);
   	

}

