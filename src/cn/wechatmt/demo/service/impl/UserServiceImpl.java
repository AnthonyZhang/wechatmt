package cn.wechatmt.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.pagination.PageUtil;
import cn.wechatmt.common.service.impl.BaseService;
import cn.wechatmt.demo.dao.IUserDao;
import cn.wechatmt.demo.model.UserModel;
import cn.wechatmt.demo.model.UserQueryModel;
import cn.wechatmt.demo.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseService<UserModel, Integer> implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private IUserDao userDao;

    @Autowired
    @Qualifier("userDao")
    @Override
    public void setBaseDao(IBaseDao<UserModel, Integer> userDao) {
        this.baseDao = userDao;
        this.userDao = (IUserDao) userDao;
    }
    


    @Override
    public Page<UserModel> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userDao.countQuery(command) ,pn, userDao.query(pn, pageSize, command), pageSize);
    }

   
}