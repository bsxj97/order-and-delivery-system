package com.dao;

import com.entity.QuxiaopeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuxiaopeisongVO;
import com.entity.view.QuxiaopeisongView;


/**
 * 取消配送
 * 
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
public interface QuxiaopeisongDao extends BaseMapper<QuxiaopeisongEntity> {
	
	List<QuxiaopeisongVO> selectListVO(@Param("ew") Wrapper<QuxiaopeisongEntity> wrapper);
	
	QuxiaopeisongVO selectVO(@Param("ew") Wrapper<QuxiaopeisongEntity> wrapper);
	
	List<QuxiaopeisongView> selectListView(@Param("ew") Wrapper<QuxiaopeisongEntity> wrapper);

	List<QuxiaopeisongView> selectListView(Pagination page,@Param("ew") Wrapper<QuxiaopeisongEntity> wrapper);
	
	QuxiaopeisongView selectView(@Param("ew") Wrapper<QuxiaopeisongEntity> wrapper);
	

}
