package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YunxuanjiangshipinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YunxuanjiangshipinView;


/**
 * 云宣讲视频
 *
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface YunxuanjiangshipinService extends IService<YunxuanjiangshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunxuanjiangshipinView> selectListView(Wrapper<YunxuanjiangshipinEntity> wrapper);
   	
   	YunxuanjiangshipinView selectView(@Param("ew") Wrapper<YunxuanjiangshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunxuanjiangshipinEntity> wrapper);
   	

}

