package cn.wechatmt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.wechatmt.common.dao.IBaseDao;
import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.pagination.PageUtil;
import cn.wechatmt.common.service.impl.BaseService;
import cn.wechatmt.demo.dao.IProductDao;
import cn.wechatmt.demo.model.MobileProductConfig;
import cn.wechatmt.demo.service.IProductsService;

@Service("productService")
public class ProductsServiceImpl extends BaseService<MobileProductConfig, Integer> implements IProductsService{

	 private IProductDao productDao;

	    @Autowired
	    @Qualifier("productDao")
	    @Override
	    public void setBaseDao(IBaseDao<MobileProductConfig, Integer> productDao) {
	        this.baseDao = productDao;
	        this.productDao = (IProductDao) productDao;
	    }

        @Override
        public Page<MobileProductConfig> listByCategory(int id, int pn, int pageSize, int categoryId) {
            return PageUtil.getPage(productDao.getCount(categoryId),
                    pn, productDao.listByCategoryId(id, pn, pageSize, categoryId), pageSize);
        }

}
