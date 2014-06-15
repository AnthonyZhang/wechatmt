package cn.wechatmt.demo.dao;

import java.util.List;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.demo.model.MobileProductCategory;

public interface IProductCategoryDao extends IBaseDao<MobileProductCategory, Integer> {

    public List<MobileProductCategory> getCategoryByLevel(int categoryLevel);

    /**
     * Query MobileProductCategorys by parent category id
     * 
     * @param parentCategoryId
     * @return List of MobileProductCategory
     */
    public List<MobileProductCategory> getCategoryByParentCategoryId(int parentCategoryId);
    
    public List<MobileProductCategory> pre(int id, int pn, int pageSize, int parentCategoryId);
    public List<MobileProductCategory> next(int id, int pn, int pageSize, int parentCategoryId);
    public int getCount(int parentCategoryId);

}
