package cn.wechatmt.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.pagination.PageUtil;
import cn.wechatmt.common.service.impl.BaseService;
import cn.wechatmt.demo.dao.IProductCategoryDao;
import cn.wechatmt.demo.model.MobileProductCategory;
import cn.wechatmt.demo.model.UserModel;
import cn.wechatmt.demo.service.IProductCategoryService;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends BaseService<MobileProductCategory, Integer> implements IProductCategoryService{

	 private IProductCategoryDao productCategoryDao;

	    @Autowired
	    @Qualifier("productCategoryDao")
	    @Override
	    public void setBaseDao(IBaseDao<MobileProductCategory, Integer> productCategoryDao) {
	        this.baseDao = productCategoryDao;
	        this.productCategoryDao = (IProductCategoryDao) productCategoryDao;
	    }

        @Override
        public Page<MobileProductCategory> pre(int id, int pn, int pageSize, int parentCategoryId) {
            return PageUtil.getPage(productCategoryDao.getCount(parentCategoryId),
                    pn, productCategoryDao.pre(id, pn, pageSize, parentCategoryId), pageSize);
        }

        @Override
        public Page<MobileProductCategory> next(int id, int pn, int pageSize, int parentCategoryId) {
            return PageUtil.getPage(productCategoryDao.getCount(parentCategoryId),
                    pn, productCategoryDao.next(id, pn, pageSize, parentCategoryId), pageSize);
        }


}
