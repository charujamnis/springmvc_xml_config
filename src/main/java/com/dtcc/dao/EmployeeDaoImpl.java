package com.dtcc.dao;

import com.dtcc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public EmployeeDaoImpl() {
    }

    @Override
    public List<Employee> getEmployees() {
        //HQL Query
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Employee");
        List<Employee> listEmployees=query.getResultList();
       /* System.out.println("after list");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Employee > cq = cb.createQuery(Employee.class);
        Root< Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        System.out.println("first employee is "+query.getResultList().get(0));*/
        return listEmployees;

    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public Employee getEmployee(Long theId) {
        Session session=sessionFactory.getCurrentSession();
        Employee theEmployee=session.get(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void deleteEmployee(Long theId) {
        Session currentSession =sessionFactory.getCurrentSession();
        Employee theEmployee=currentSession.get(Employee.class,theId);
        currentSession.delete(theEmployee);
    }
}
