package test.Dao.Hibernate.Service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import test.Dao.Hibernate.Entities.LinesEntities;

import java.util.List;

public class LineService {

    private Session session;

    public void setSession(Session session){
        this.session = session;
    }

    public List<LinesEntities> getAllLines(){
        Criteria criteria = session.createCriteria(LinesEntities.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }



}
