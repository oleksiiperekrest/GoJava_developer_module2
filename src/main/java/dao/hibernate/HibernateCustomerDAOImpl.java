package dao.hibernate;

import dao.CustomerDAO;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Customer getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = session.createQuery("from Customer ").list();
        transaction.commit();
        session.close();
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        deleteById(customer.getId());
        save(customer);
    }

    @Override
    public void delete(Customer customer) {
        deleteById(customer.getId());

    }

    @Override
    public void deleteById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        transaction.commit();
        session.close();
    }
}
