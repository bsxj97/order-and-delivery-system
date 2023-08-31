package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QuxiaopeisongEntity;
import com.entity.view.QuxiaopeisongView;

import com.service.QuxiaopeisongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 取消配送
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
@RestController
@RequestMapping("/quxiaopeisong")
public class QuxiaopeisongController {
    @Autowired
    private QuxiaopeisongService quxiaopeisongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuxiaopeisongEntity quxiaopeisong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("peisongyuan")) {
			quxiaopeisong.setPeisongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			quxiaopeisong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QuxiaopeisongEntity> ew = new EntityWrapper<QuxiaopeisongEntity>();
    	PageUtils page = quxiaopeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaopeisong), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuxiaopeisongEntity quxiaopeisong, 
		HttpServletRequest request){
        EntityWrapper<QuxiaopeisongEntity> ew = new EntityWrapper<QuxiaopeisongEntity>();
    	PageUtils page = quxiaopeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quxiaopeisong), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuxiaopeisongEntity quxiaopeisong){
       	EntityWrapper<QuxiaopeisongEntity> ew = new EntityWrapper<QuxiaopeisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quxiaopeisong, "quxiaopeisong")); 
        return R.ok().put("data", quxiaopeisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuxiaopeisongEntity quxiaopeisong){
        EntityWrapper< QuxiaopeisongEntity> ew = new EntityWrapper< QuxiaopeisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quxiaopeisong, "quxiaopeisong")); 
		QuxiaopeisongView quxiaopeisongView =  quxiaopeisongService.selectView(ew);
		return R.ok("查询取消配送成功").put("data", quxiaopeisongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuxiaopeisongEntity quxiaopeisong = quxiaopeisongService.selectById(id);
        return R.ok().put("data", quxiaopeisong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuxiaopeisongEntity quxiaopeisong = quxiaopeisongService.selectById(id);
        return R.ok().put("data", quxiaopeisong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuxiaopeisongEntity quxiaopeisong, HttpServletRequest request){
    	quxiaopeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaopeisong);

        quxiaopeisongService.insert(quxiaopeisong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuxiaopeisongEntity quxiaopeisong, HttpServletRequest request){
    	quxiaopeisong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quxiaopeisong);

        quxiaopeisongService.insert(quxiaopeisong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QuxiaopeisongEntity quxiaopeisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quxiaopeisong);
        quxiaopeisongService.updateById(quxiaopeisong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quxiaopeisongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<QuxiaopeisongEntity> wrapper = new EntityWrapper<QuxiaopeisongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("peisongyuan")) {
			wrapper.eq("peisongzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = quxiaopeisongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
