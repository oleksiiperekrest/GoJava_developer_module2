package dao.hibernate;

import dao.DeveloperDAO;
import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDeveloperDAOImpl implements DeveloperDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Developer getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Developer> developersList = session.createQuery("from Developer ").list();
        transaction.commit();
        session.close();
        return developersList;
    }

    @Override
    public void save(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Developer developer) {
        deleteById(developer.getId());
        save(developer);
    }

    @Override
    public void delete(Developer developer) {
        deleteById(developer.getId());
    }

    @Override
    public void deleteById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}
