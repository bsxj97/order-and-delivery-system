package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SongdatongzhiDao;
import com.entity.SongdatongzhiEntity;
import com.service.SongdatongzhiService;
import com.entity.vo.SongdatongzhiVO;
import com.entity.view.SongdatongzhiView;

@Service("songdatongzhiService")
public class SongdatongzhiServiceImpl extends ServiceImpl<SongdatongzhiDao, SongdatongzhiEntity> implements SongdatongzhiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SongdatongzhiEntity> page = this.selectPage(
                new Query<SongdatongzhiEntity>(params).getPage(),
                new EntityWrapper<SongdatongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SongdatongzhiEntity> wrapper) {
		  Page<SongdatongzhiView> page =new Query<SongdatongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SongdatongzhiVO> selectListVO(Wrapper<SongdatongzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SongdatongzhiVO selectVO(Wrapper<SongdatongzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SongdatongzhiView> selectListView(Wrapper<SongdatongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SongdatongzhiView selectView(Wrapper<SongdatongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
