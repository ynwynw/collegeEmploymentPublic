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

import com.cl.entity.QiyeyonghuEntity;
import com.cl.service.QiyeyonghuService;
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

import com.cl.entity.YunxuanjiangshipinEntity;
import com.cl.entity.view.YunxuanjiangshipinView;

import com.cl.service.YunxuanjiangshipinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 云宣讲视频
 * 后端接口
 * @author
 * @email
 * @date 2024-03-03 17:13:34
 */
@RestController
@RequestMapping("/yunxuanjiangshipin")
public class YunxuanjiangshipinController {
    @Autowired
    private YunxuanjiangshipinService yunxuanjiangshipinService;
    @Autowired
    private QiyeyonghuService qiyeyonghuService;






    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YunxuanjiangshipinEntity yunxuanjiangshipin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiyeyonghu")) {
			yunxuanjiangshipin.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YunxuanjiangshipinEntity> ew = new EntityWrapper<YunxuanjiangshipinEntity>();

		PageUtils page = yunxuanjiangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunxuanjiangshipin), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YunxuanjiangshipinEntity yunxuanjiangshipin,
		HttpServletRequest request){
        EntityWrapper<YunxuanjiangshipinEntity> ew = new EntityWrapper<YunxuanjiangshipinEntity>();

		PageUtils page = yunxuanjiangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunxuanjiangshipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YunxuanjiangshipinEntity yunxuanjiangshipin){
       	EntityWrapper<YunxuanjiangshipinEntity> ew = new EntityWrapper<YunxuanjiangshipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yunxuanjiangshipin, "yunxuanjiangshipin"));
        return R.ok().put("data", yunxuanjiangshipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YunxuanjiangshipinEntity yunxuanjiangshipin){
        EntityWrapper< YunxuanjiangshipinEntity> ew = new EntityWrapper< YunxuanjiangshipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yunxuanjiangshipin, "yunxuanjiangshipin"));
		YunxuanjiangshipinView yunxuanjiangshipinView =  yunxuanjiangshipinService.selectView(ew);
		return R.ok("查询云宣讲视频成功").put("data", yunxuanjiangshipinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YunxuanjiangshipinEntity yunxuanjiangshipin = yunxuanjiangshipinService.selectById(id);
		yunxuanjiangshipin = yunxuanjiangshipinService.selectView(new EntityWrapper<YunxuanjiangshipinEntity>().eq("id", id));
        return R.ok().put("data", yunxuanjiangshipin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YunxuanjiangshipinEntity yunxuanjiangshipin = yunxuanjiangshipinService.selectById(id);
		yunxuanjiangshipin = yunxuanjiangshipinService.selectView(new EntityWrapper<YunxuanjiangshipinEntity>().eq("id", id));
        return R.ok().put("data", yunxuanjiangshipin);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YunxuanjiangshipinEntity yunxuanjiangshipin, HttpServletRequest request){
    	yunxuanjiangshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yunxuanjiangshipin);
        yunxuanjiangshipinService.insert(yunxuanjiangshipin);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YunxuanjiangshipinEntity yunxuanjiangshipin, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiyeyonghu")) {
            yunxuanjiangshipin.setXingming((String)request.getSession().getAttribute("username"));
            QiyeyonghuEntity userId = qiyeyonghuService.selectById((Long) request.getSession().getAttribute("userId"));
            yunxuanjiangshipin.setZhanghao((String)request.getSession().getAttribute("username"));
            yunxuanjiangshipin.setXingming(userId.getQiyemingcheng());
        }
    	yunxuanjiangshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yunxuanjiangshipin);
        yunxuanjiangshipinService.insert(yunxuanjiangshipin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YunxuanjiangshipinEntity yunxuanjiangshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunxuanjiangshipin);
        yunxuanjiangshipinService.updateById(yunxuanjiangshipin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YunxuanjiangshipinEntity> list = new ArrayList<YunxuanjiangshipinEntity>();
        for(Long id : ids) {
            YunxuanjiangshipinEntity yunxuanjiangshipin = yunxuanjiangshipinService.selectById(id);
            yunxuanjiangshipin.setSfsh(sfsh);
            yunxuanjiangshipin.setShhf(shhf);
            list.add(yunxuanjiangshipin);
        }
        yunxuanjiangshipinService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yunxuanjiangshipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
