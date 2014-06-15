package cn.wechatmt.demo.dao.hibernate4;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.wechatmt.common.dao.hibernate4.BaseHibernateDao;
import cn.wechatmt.demo.dao.IMobileUserDao;
import cn.wechatmt.demo.model.MobileUsers;

@Repository("mobileUserDao")
public class MobileUserDaoImpl extends BaseHibernateDao<MobileUsers, Integer> implements IMobileUserDao {

    /*
     * String
     * hql="from Admin as admin where admin.aname=:name";//使用命名参数，推荐使用，易读。 Query
     * query=s.createQuery(hql); query.setString("name", name);
     * 
     * List<Admin> list=query.list();
     */
    @Override
    public MobileUsers getMobileUserByName(String account) {
        String nativeSql = "From MobileUsers where account=:account";
        Query query = getSession().createQuery(nativeSql);

        query.setString("account", account);
        @SuppressWarnings("unchecked")
        List<MobileUsers> usersList = query.list();
        if (null != usersList) {
            return usersList.get(0);
        }
        return null;
    }

}
