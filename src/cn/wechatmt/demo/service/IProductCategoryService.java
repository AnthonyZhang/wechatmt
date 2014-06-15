package cn.wechatmt.demo.service;

import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.service.IBaseService;
import cn.wechatmt.demo.model.MobileProductCategory;

public interface IProductCategoryService extends IBaseService<MobileProductCategory, Integer> {
    public Page<MobileProductCategory> pre(int id, int pn, int pageSize, int parentCategoryId);
    public Page<MobileProductCategory> next(int id, int pn, int pageSize, int parentCategoryId);
}
