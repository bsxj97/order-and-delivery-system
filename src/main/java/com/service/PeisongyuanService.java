package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeisongyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeisongyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeisongyuanView;


/**
 * 配送员
 *
 * @author 
 * @email 
 * @date 2022-03-26 17:40:36
 */
public interface PeisongyuanService extends IService<PeisongyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeisongyuanVO> selectListVO(Wrapper<PeisongyuanEntity> wrapper);
   	
   	PeisongyuanVO selectVO(@Param("ew") Wrapper<PeisongyuanEntity> wrapper);
   	
   	List<PeisongyuanView> selectListView(Wrapper<PeisongyuanEntity> wrapper);
   	
   	PeisongyuanView selectView(@Param("ew") Wrapper<PeisongyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeisongyuanEntity> wrapper);
   	

}

