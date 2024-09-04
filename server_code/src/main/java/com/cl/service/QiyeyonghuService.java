package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QiyeyonghuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QiyeyonghuView;


/**
 * 企业用户
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface QiyeyonghuService extends IService<QiyeyonghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyeyonghuView> selectListView(Wrapper<QiyeyonghuEntity> wrapper);
   	
   	QiyeyonghuView selectView(@Param("ew") Wrapper<QiyeyonghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiyeyonghuEntity> wrapper);
   	

}

