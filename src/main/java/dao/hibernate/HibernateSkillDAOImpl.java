package dao.hibernate;

import dao.SkillDAO;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateSkillDAOImpl implements SkillDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Skill getById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Skill> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Skill> skillList = session.createQuery("from Skill ").list();
        transaction.commit();
        session.close();
        return skillList;
    }

    @Override
    public void save(Skill skill) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Skill skill) {
        deleteById(skill.getId());
        save(skill);
    }

    @Override
    public void delete(Skill skill) {
        deleteById(skill.getId());
    }

    @Override
    public void deleteById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();
    }
}
