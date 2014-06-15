package cn.wechatmt.demo.dao.hibernate4;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.wechatmt.common.dao.hibernate4.BaseHibernateDao;
import cn.wechatmt.common.dao.util.ConditionQuery;
import cn.wechatmt.common.dao.util.OrderBy;
import cn.wechatmt.demo.dao.IProductDao;
import cn.wechatmt.demo.model.MobileProductConfig;

@Repository("productDao")
public class ProductDaoImpl extends BaseHibernateDao<MobileProductConfig, Integer> implements IProductDao{

    @Override
    public int getCount(int categoryId) {
        ConditionQuery condition = new ConditionQuery();
        condition.add(Restrictions.eq("parentCategoryId", categoryId));
        return getCount(condition);
    }

    @Override
    public List<MobileProductConfig> listByCategoryId(int id, int pn, int pageSize, int categoryId) {
        ConditionQuery condition = new ConditionQuery();
        condition.add(Restrictions.eq("parentCategoryId", categoryId));
        OrderBy orderBy = new OrderBy();
        orderBy.add(Order.asc("id"));
        return list(condition, orderBy, pn, pageSize);
    }

}
