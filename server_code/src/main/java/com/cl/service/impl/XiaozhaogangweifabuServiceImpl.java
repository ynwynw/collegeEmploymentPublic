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


import com.cl.dao.XiaozhaogangweifabuDao;
import com.cl.entity.XiaozhaogangweifabuEntity;
import com.cl.service.XiaozhaogangweifabuService;
import com.cl.entity.view.XiaozhaogangweifabuView;

@Service("xiaozhaogangweifabuService")
public class XiaozhaogangweifabuServiceImpl extends ServiceImpl<XiaozhaogangweifabuDao, XiaozhaogangweifabuEntity> implements XiaozhaogangweifabuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaozhaogangweifabuEntity> page = this.selectPage(
                new Query<XiaozhaogangweifabuEntity>(params).getPage(),
                new EntityWrapper<XiaozhaogangweifabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaozhaogangweifabuEntity> wrapper) {
		  Page<XiaozhaogangweifabuView> page =new Query<XiaozhaogangweifabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaozhaogangweifabuView> selectListView(Wrapper<XiaozhaogangweifabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaozhaogangweifabuView selectView(Wrapper<XiaozhaogangweifabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XiaozhaogangweifabuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XiaozhaogangweifabuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XiaozhaogangweifabuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
