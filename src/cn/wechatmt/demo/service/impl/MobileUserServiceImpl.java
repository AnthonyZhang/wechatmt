package cn.wechatmt.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.common.service.impl.BaseService;
import cn.wechatmt.demo.dao.IMobileUserDao;
import cn.wechatmt.demo.model.MobileUsers;
import cn.wechatmt.demo.service.IMobileUserService;

@Service("mobileUserService")
public class MobileUserServiceImpl extends BaseService<MobileUsers,  Integer> implements IMobileUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileUserServiceImpl.class);

    private IMobileUserDao mobileUserDao;

    @Autowired
    @Qualifier("mobileUserDao")
    @Override
    public void setBaseDao(IBaseDao<MobileUsers, Integer> mobileUserDao) {
        this.baseDao = mobileUserDao;
        this.mobileUserDao = (IMobileUserDao) mobileUserDao;
    }

	@Override
	public MobileUsers getMobileUserByName(String account) {
		return mobileUserDao.getMobileUserByName(account);
	}
	
	@Override
	public boolean checkUserLogin(String account, String password){
		
		if (null != account && null != password && "" != account && "" != password){
			MobileUsers user =  this.getMobileUserByName(account);
			if (null != user){
				return password.equals(user.getPassword());
			}
		}
		return false;
	}
   
}