package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaozhaogangweifabuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaozhaogangweifabuView;


/**
 * 校招岗位发布
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface XiaozhaogangweifabuService extends IService<XiaozhaogangweifabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaozhaogangweifabuView> selectListView(Wrapper<XiaozhaogangweifabuEntity> wrapper);
   	
   	XiaozhaogangweifabuView selectView(@Param("ew") Wrapper<XiaozhaogangweifabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaozhaogangweifabuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XiaozhaogangweifabuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XiaozhaogangweifabuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XiaozhaogangweifabuEntity> wrapper);



}

