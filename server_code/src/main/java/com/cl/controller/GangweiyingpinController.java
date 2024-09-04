package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.GangweiyingpinEntity;
import com.cl.entity.view.GangweiyingpinView;

import com.cl.service.GangweiyingpinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 岗位应聘
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
@RestController
@RequestMapping("/gangweiyingpin")
public class GangweiyingpinController {
    @Autowired
    private GangweiyingpinService gangweiyingpinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweiyingpinEntity gangweiyingpin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
			gangweiyingpin.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daxueshengyonghu")) {
			gangweiyingpin.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();

		PageUtils page = gangweiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweiyingpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweiyingpinEntity gangweiyingpin, 
		HttpServletRequest request){
        EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();

		PageUtils page = gangweiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweiyingpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweiyingpinEntity gangweiyingpin){
       	EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweiyingpin, "gangweiyingpin")); 
        return R.ok().put("data", gangweiyingpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweiyingpinEntity gangweiyingpin){
        EntityWrapper< GangweiyingpinEntity> ew = new EntityWrapper< GangweiyingpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweiyingpin, "gangweiyingpin")); 
		GangweiyingpinView gangweiyingpinView =  gangweiyingpinService.selectView(ew);
		return R.ok("查询岗位应聘成功").put("data", gangweiyingpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweiyingpinEntity gangweiyingpin = gangweiyingpinService.selectById(id);
		gangweiyingpin = gangweiyingpinService.selectView(new EntityWrapper<GangweiyingpinEntity>().eq("id", id));
        return R.ok().put("data", gangweiyingpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweiyingpinEntity gangweiyingpin = gangweiyingpinService.selectById(id);
		gangweiyingpin = gangweiyingpinService.selectView(new EntityWrapper<GangweiyingpinEntity>().eq("id", id));
        return R.ok().put("data", gangweiyingpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
    	gangweiyingpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.insert(gangweiyingpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
    	gangweiyingpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.insert(gangweiyingpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.updateById(gangweiyingpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweiyingpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
