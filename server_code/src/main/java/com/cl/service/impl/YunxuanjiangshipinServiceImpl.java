package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YunxuanjiangshipinDao;
import com.cl.entity.YunxuanjiangshipinEntity;
import com.cl.service.YunxuanjiangshipinService;
import com.cl.entity.view.YunxuanjiangshipinView;

@Service("yunxuanjiangshipinService")
public class YunxuanjiangshipinServiceImpl extends ServiceImpl<YunxuanjiangshipinDao, YunxuanjiangshipinEntity> implements YunxuanjiangshipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunxuanjiangshipinEntity> page = this.selectPage(
                new Query<YunxuanjiangshipinEntity>(params).getPage(),
                new EntityWrapper<YunxuanjiangshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunxuanjiangshipinEntity> wrapper) {
		  Page<YunxuanjiangshipinView> page =new Query<YunxuanjiangshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YunxuanjiangshipinView> selectListView(Wrapper<YunxuanjiangshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunxuanjiangshipinView selectView(Wrapper<YunxuanjiangshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
