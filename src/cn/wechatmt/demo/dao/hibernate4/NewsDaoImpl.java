package cn.wechatmt.demo.dao.hibernate4;

import org.springframework.stereotype.Repository;

import cn.wechatmt.common.dao.hibernate4.BaseHibernateDao;
import cn.wechatmt.demo.dao.INewsDao;
import cn.wechatmt.demo.model.MobileNews;

@Repository("newsDao")
public class NewsDaoImpl extends BaseHibernateDao<MobileNews, Integer> implements INewsDao{

}
