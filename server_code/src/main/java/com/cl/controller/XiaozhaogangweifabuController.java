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

import com.cl.entity.XiaozhaogangweifabuEntity;
import com.cl.entity.view.XiaozhaogangweifabuView;

import com.cl.service.XiaozhaogangweifabuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 校招岗位发布
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 17:13:34
 */
@RestController
@RequestMapping("/xiaozhaogangweifabu")
public class XiaozhaogangweifabuController {
    @Autowired
    private XiaozhaogangweifabuService xiaozhaogangweifabuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaozhaogangweifabuEntity xiaozhaogangweifabu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
			xiaozhaogangweifabu.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();

		PageUtils page = xiaozhaogangweifabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaozhaogangweifabu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaozhaogangweifabuEntity xiaozhaogangweifabu, 
		HttpServletRequest request){
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();

		PageUtils page = xiaozhaogangweifabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaozhaogangweifabu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaozhaogangweifabuEntity xiaozhaogangweifabu){
       	EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaozhaogangweifabu, "xiaozhaogangweifabu")); 
        return R.ok().put("data", xiaozhaogangweifabuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaozhaogangweifabuEntity xiaozhaogangweifabu){
        EntityWrapper< XiaozhaogangweifabuEntity> ew = new EntityWrapper< XiaozhaogangweifabuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaozhaogangweifabu, "xiaozhaogangweifabu")); 
		XiaozhaogangweifabuView xiaozhaogangweifabuView =  xiaozhaogangweifabuService.selectView(ew);
		return R.ok("查询校招岗位发布成功").put("data", xiaozhaogangweifabuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaozhaogangweifabuEntity xiaozhaogangweifabu = xiaozhaogangweifabuService.selectById(id);
		xiaozhaogangweifabu = xiaozhaogangweifabuService.selectView(new EntityWrapper<XiaozhaogangweifabuEntity>().eq("id", id));
        return R.ok().put("data", xiaozhaogangweifabu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaozhaogangweifabuEntity xiaozhaogangweifabu = xiaozhaogangweifabuService.selectById(id);
		xiaozhaogangweifabu = xiaozhaogangweifabuService.selectView(new EntityWrapper<XiaozhaogangweifabuEntity>().eq("id", id));
        return R.ok().put("data", xiaozhaogangweifabu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaozhaogangweifabuEntity xiaozhaogangweifabu, HttpServletRequest request){
    	xiaozhaogangweifabu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaozhaogangweifabu);
        xiaozhaogangweifabuService.insert(xiaozhaogangweifabu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaozhaogangweifabuEntity xiaozhaogangweifabu, HttpServletRequest request){
    	xiaozhaogangweifabu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaozhaogangweifabu);
        xiaozhaogangweifabuService.insert(xiaozhaogangweifabu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaozhaogangweifabuEntity xiaozhaogangweifabu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaozhaogangweifabu);
        xiaozhaogangweifabuService.updateById(xiaozhaogangweifabu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XiaozhaogangweifabuEntity> list = new ArrayList<XiaozhaogangweifabuEntity>();
        for(Long id : ids) {
            XiaozhaogangweifabuEntity xiaozhaogangweifabu = xiaozhaogangweifabuService.selectById(id);
            xiaozhaogangweifabu.setSfsh(sfsh);
            xiaozhaogangweifabu.setShhf(shhf);
            list.add(xiaozhaogangweifabu);
        }
        xiaozhaogangweifabuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaozhaogangweifabuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = xiaozhaogangweifabuService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyeyonghu")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = xiaozhaogangweifabuService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyeyonghu")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = xiaozhaogangweifabuService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyeyonghu")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = xiaozhaogangweifabuService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<XiaozhaogangweifabuEntity> ew = new EntityWrapper<XiaozhaogangweifabuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyeyonghu")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = xiaozhaogangweifabuService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }






}
