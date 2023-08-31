package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SongdatongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SongdatongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SongdatongzhiView;


/**
 * 送达通知
 *
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
public interface SongdatongzhiService extends IService<SongdatongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SongdatongzhiVO> selectListVO(Wrapper<SongdatongzhiEntity> wrapper);
   	
   	SongdatongzhiVO selectVO(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
   	
   	List<SongdatongzhiView> selectListView(Wrapper<SongdatongzhiEntity> wrapper);
   	
   	SongdatongzhiView selectView(@Param("ew") Wrapper<SongdatongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SongdatongzhiEntity> wrapper);
   	

}

