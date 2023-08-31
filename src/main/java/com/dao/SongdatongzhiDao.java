package com.dao;

import com.entity.SongdatongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SongdatongzhiVO;
import com.entity.view.SongdatongzhiView;


/**
 * 送达通知
 * 
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
public interface SongdatongzhiDao extends BaseMapper<SongdatongzhiEntity> {
	
	List<SongdatongzhiVO> selectListVO(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
	
	SongdatongzhiVO selectVO(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
	
	List<SongdatongzhiView> selectListView(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);

	List<SongdatongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
	
	SongdatongzhiView selectView(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
	

}
