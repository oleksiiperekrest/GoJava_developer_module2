package dao.hibernate;

import dao.ProjectDAO;
import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateProjectDAOImpl implements ProjectDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Project getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Project> projectList = session.createQuery("from Project ").list();
        transaction.commit();
        session.close();
        return projectList;
    }

    @Override
    public void save(Project project) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Project project) {
        deleteById(project.getId());
        save(project);
    }

    @Override
    public void delete(Project project) {
        deleteById(project.getId());
    }

    @Override
    public void deleteById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Project project = session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
        session.close();
    }
}
