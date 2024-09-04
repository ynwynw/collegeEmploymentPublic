package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QiyerenzhengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyerenzhengView;


/**
 * 企业认证
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface QiyerenzhengService extends IService<QiyerenzhengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyerenzhengView> selectListView(Wrapper<QiyerenzhengEntity> wrapper);
   	
   	QiyerenzhengView selectView(@Param("ew") Wrapper<QiyerenzhengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiyerenzhengEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QiyerenzhengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QiyerenzhengEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QiyerenzhengEntity> wrapper);



}

