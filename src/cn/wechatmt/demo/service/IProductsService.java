package cn.wechatmt.demo.service;

import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.service.IBaseService;
import cn.wechatmt.demo.model.MobileProductConfig;

public interface IProductsService extends IBaseService<MobileProductConfig, Integer> {
    public Page<MobileProductConfig> listByCategory(int id, int pn, int pageSize, int categoryId);
}
