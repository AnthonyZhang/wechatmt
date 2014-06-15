package cn.wechatmt.demo.dao;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.demo.model.MobileUsers;

public interface IMobileUserDao extends IBaseDao<MobileUsers, Integer> {
	
	public MobileUsers getMobileUserByName(String account);
}
