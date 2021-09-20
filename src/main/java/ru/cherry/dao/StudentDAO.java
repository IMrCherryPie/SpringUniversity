package ru.cherry.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.cherry.models.Student;

import java.util.List;

@Component
public class StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Student> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Student show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Transactional
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Transactional
    public void update(int id, Student updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Student personToBeUpdated = session.get(Student.class, id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Student.class, id));
    }
}