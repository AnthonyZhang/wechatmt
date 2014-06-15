package cn.wechatmt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.common.service.impl.BaseService;
import cn.wechatmt.demo.dao.INewsDao;
import cn.wechatmt.demo.model.MobileNews;
import cn.wechatmt.demo.service.INewsService;

@Service("newsService")
public class NewsServiceImpl extends BaseService<MobileNews, Integer> implements INewsService{

	 private INewsDao newsDao;

	    @Autowired
	    @Qualifier("newsDao")
	    @Override
	    public void setBaseDao(IBaseDao<MobileNews, Integer> newsDao) {
	        this.baseDao = newsDao;
	        this.newsDao = (INewsDao) newsDao;
	    }


}
