package dao.hibernate;

import dao.CompanyDAO;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateCompanyDAOImpl implements CompanyDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Company getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Company> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Company> companyList = session.createQuery("from Company ").list();
        transaction.commit();
        session.close();
        return companyList;
    }

    @Override
    public void save(Company company) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Company company) {
        deleteById(company.getId());
        save(company);
    }

    @Override
    public void delete(Company company) {
        deleteById(company.getId());
    }

    @Override
    public void deleteById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = session.get(Company.class, id);
        session.delete(company);
        transaction.commit();
        session.close();
    }
}
