package cn.wechatmt.demo.dao.hibernate4;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.wechatmt.common.dao.hibernate4.BaseHibernateDao;
import cn.wechatmt.common.dao.util.ConditionQuery;
import cn.wechatmt.common.dao.util.OrderBy;
import cn.wechatmt.common.model.AbstractModel;
import cn.wechatmt.common.pagination.PageUtil;
import cn.wechatmt.demo.dao.IProductCategoryDao;
import cn.wechatmt.demo.model.MobileProductCategory;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends BaseHibernateDao<MobileProductCategory, Integer> implements IProductCategoryDao {

    @Override
    public List<MobileProductCategory> getCategoryByLevel(int categoryLevel) {
        return null;
    }

    @Override
    public List<MobileProductCategory> getCategoryByParentCategoryId(int parentCategoryId) {
        // Defined query SQL
        String HQLSql = "From MobileProductCategory where parentCategoryId=:parentCategoryId";
        Query query = getSession().createQuery(HQLSql);

        // Set parameter
        query.setInteger("parentCategoryId", parentCategoryId);

        // Execute query
        @SuppressWarnings("unchecked")
        List<MobileProductCategory> categoryList = query.list();

        return categoryList;
    }
    
    //select top 10 * from table1 where id not in(select top 开始的位置 id from table1)
    //inal String nativeSQL, final int pn, final int pageSize, final Object... paramlist
   /* public List<Book> pagedList(int pageBegin, int pageSize){  
        Query query = getSession().createQuery("from Book");  
        query.setFirstResult(pageBegin);  
        query.setMaxResults(pageSize);  
        return query.list();  
       }  */
    
    @Override
    public List<MobileProductCategory> pre(int id, int pn, int pageSize, int parentCategoryId) {
        /*String HQL_OPTIMIZE_PRE_LIST_ALL = "from MobileProductCategory where id < ? and parentCategoryId=?  order by id asc";
        String HQL_LIST_ALL = "from MobileProductCategory where parentCategoryId=? order by id desc";
        // 倒序，重排
        List<MobileProductCategory> result = list(HQL_OPTIMIZE_PRE_LIST_ALL, 1, pageSize, id, parentCategoryId);
        Collections.reverse(result);*/
        ConditionQuery condition = new ConditionQuery();
        condition.add(Restrictions.eq("parentCategoryId", parentCategoryId));
        OrderBy orderBy = new OrderBy();
        orderBy.add(Order.asc("id"));
        return list(condition, orderBy, pn, pageSize);
    }
    @Override
    public List<MobileProductCategory> next(int id, int pn, int pageSize, int parentCategoryId) {
        /*String HQL_LIST_ALL = "from MobileProductCategory where parentCategoryId=? order by id desc";
        String HQL_OPTIMIZE_NEXT_LIST_ALL = "from MobileProductCategory where id > ? and parentCategoryId=? order by id desc";
        return list(HQL_OPTIMIZE_NEXT_LIST_ALL, 1, pageSize, id, parentCategoryId);*/
        ConditionQuery condition = new ConditionQuery();
        condition.add(Restrictions.eq("parentCategoryId", parentCategoryId));
        OrderBy orderBy = new OrderBy();
        orderBy.add(Order.asc("id"));
        return list(condition, orderBy, pn, pageSize);
    }
    
    
    public List<MobileProductCategory> listAll(int id, int pn, int pageSize, int parentCategoryId) {
        String HQL_LIST_ALL = "from MobileProductCategory where parentCategoryId=? order by id desc";
        String HQL_OPTIMIZE_NEXT_LIST_ALL = "from MobileProductCategory where parentCategoryId=? order by id desc";
        if (id == 0) {
            return list(HQL_LIST_ALL, pn, pageSize);
        }
        return list(HQL_OPTIMIZE_NEXT_LIST_ALL, 1, pageSize, id);
    }
    @Override
    public int getCount(int parentCategoryId) {
        /*String HQL_COUNT_ALL = " select count(*) from MobileProductCategory where parentCategoryId=?";
        Query query = getSession().createQuery(HQL_COUNT_ALL);  
        query.setInteger(0, parentCategoryId);
        return ((Long)query.uniqueResult()).intValue(); */
        ConditionQuery condition = new ConditionQuery();
        condition.add(Restrictions.eq("parentCategoryId", parentCategoryId));
        return getCount(condition);
    }

}
