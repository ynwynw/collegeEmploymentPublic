package com.cl.dao;

import com.cl.entity.YunxuanjiangshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YunxuanjiangshipinView;


/**
 * 云宣讲视频
 * 
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
public interface YunxuanjiangshipinDao extends BaseMapper<YunxuanjiangshipinEntity> {
	
	List<YunxuanjiangshipinView> selectListView(@Param("ew") Wrapper<YunxuanjiangshipinEntity> wrapper);

	List<YunxuanjiangshipinView> selectListView(Pagination page,@Param("ew") Wrapper<YunxuanjiangshipinEntity> wrapper);
	
	YunxuanjiangshipinView selectView(@Param("ew") Wrapper<YunxuanjiangshipinEntity> wrapper);
	

}
