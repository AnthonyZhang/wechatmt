package cn.wechatmt.demo.service;

import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.service.IBaseService;
import cn.wechatmt.demo.model.UserModel;
import cn.wechatmt.demo.model.UserQueryModel;

public interface IUserService extends IBaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
