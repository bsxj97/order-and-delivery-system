package com.dao;

import com.entity.DingdanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanxinxiVO;
import com.entity.view.DingdanxinxiView;


/**
 * 订单信息
 * 
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
public interface DingdanxinxiDao extends BaseMapper<DingdanxinxiEntity> {
	
	List<DingdanxinxiVO> selectListVO(@Param("ew") Wrapper<DingdanxinxiEntity> wrapper);
	
	DingdanxinxiVO selectVO(@Param("ew") Wrapper<DingdanxinxiEntity> wrapper);
	
	List<DingdanxinxiView> selectListView(@Param("ew") Wrapper<DingdanxinxiEntity> wrapper);

	List<DingdanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanxinxiEntity> wrapper);
	
	DingdanxinxiView selectView(@Param("ew") Wrapper<DingdanxinxiEntity> wrapper);
	

}
