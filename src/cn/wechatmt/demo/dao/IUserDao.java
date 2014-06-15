package cn.wechatmt.demo.dao;

import java.util.List;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.demo.model.UserModel;
import cn.wechatmt.demo.model.UserQueryModel;


public interface IUserDao extends IBaseDao<UserModel, Integer> {
    
    List<UserModel> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
