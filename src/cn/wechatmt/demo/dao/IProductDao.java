package cn.wechatmt.demo.dao;

import java.util.List;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.demo.model.MobileProductConfig;

public interface IProductDao extends IBaseDao<MobileProductConfig, Integer>{

    public int getCount(int categoryId);
    public List<MobileProductConfig> listByCategoryId(int id, int pn, int pageSize, int categoryId);
}
