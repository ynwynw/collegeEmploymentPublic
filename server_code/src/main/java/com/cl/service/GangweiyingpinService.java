package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GangweiyingpinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GangweiyingpinView;


/**
 * 岗位应聘
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
public interface GangweiyingpinService extends IService<GangweiyingpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweiyingpinView> selectListView(Wrapper<GangweiyingpinEntity> wrapper);
   	
   	GangweiyingpinView selectView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweiyingpinEntity> wrapper);
   	

}

