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

import com.cl.entity.ZaixianzixunEntity;
import com.cl.entity.view.ZaixianzixunView;

import com.cl.service.ZaixianzixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线咨询
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 17:13:35
 */
@RestController
@RequestMapping("/zaixianzixun")
public class ZaixianzixunController {
    @Autowired
    private ZaixianzixunService zaixianzixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianzixunEntity zaixianzixun,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
			zaixianzixun.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daxueshengyonghu")) {
			zaixianzixun.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianzixunEntity> ew = new EntityWrapper<ZaixianzixunEntity>();

		PageUtils page = zaixianzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianzixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianzixunEntity zaixianzixun, 
		HttpServletRequest request){
        EntityWrapper<ZaixianzixunEntity> ew = new EntityWrapper<ZaixianzixunEntity>();

		PageUtils page = zaixianzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianzixunEntity zaixianzixun){
       	EntityWrapper<ZaixianzixunEntity> ew = new EntityWrapper<ZaixianzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianzixun, "zaixianzixun")); 
        return R.ok().put("data", zaixianzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianzixunEntity zaixianzixun){
        EntityWrapper< ZaixianzixunEntity> ew = new EntityWrapper< ZaixianzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianzixun, "zaixianzixun")); 
		ZaixianzixunView zaixianzixunView =  zaixianzixunService.selectView(ew);
		return R.ok("查询在线咨询成功").put("data", zaixianzixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianzixunEntity zaixianzixun = zaixianzixunService.selectById(id);
		zaixianzixun = zaixianzixunService.selectView(new EntityWrapper<ZaixianzixunEntity>().eq("id", id));
        return R.ok().put("data", zaixianzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianzixunEntity zaixianzixun = zaixianzixunService.selectById(id);
		zaixianzixun = zaixianzixunService.selectView(new EntityWrapper<ZaixianzixunEntity>().eq("id", id));
        return R.ok().put("data", zaixianzixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianzixunEntity zaixianzixun, HttpServletRequest request){
    	zaixianzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianzixun);
        zaixianzixunService.insert(zaixianzixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianzixunEntity zaixianzixun, HttpServletRequest request){
    	zaixianzixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianzixun);
        zaixianzixunService.insert(zaixianzixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaixianzixunEntity zaixianzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianzixun);
        zaixianzixunService.updateById(zaixianzixun);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZaixianzixunEntity> list = new ArrayList<ZaixianzixunEntity>();
        for(Long id : ids) {
            ZaixianzixunEntity zaixianzixun = zaixianzixunService.selectById(id);
            zaixianzixun.setSfsh(sfsh);
            zaixianzixun.setShhf(shhf);
            list.add(zaixianzixun);
        }
        zaixianzixunService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
