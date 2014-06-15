package cn.wechatmt.demo.service;

import cn.wechatmt.common.service.IBaseService;
import cn.wechatmt.demo.model.MobileUsers;

public interface IMobileUserService extends IBaseService<MobileUsers, Integer> {

	public MobileUsers getMobileUserByName(String account);
	
	public boolean checkUserLogin(String account, String password);
}
