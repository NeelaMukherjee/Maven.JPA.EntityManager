package services;

import entities.Artist;
import entities.CD;
import entities.Student;
import entities.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

public class StudentService {
    EntityManager em = null;
    EntityTransaction tx = null;

    public StudentService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }
    public Student createStudent(String first_name, String last_name, Set<Subject> subjects){

        Student student = new Student();
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setSubjects(subjects);

        tx.begin();
        em.persist(student);
        tx.commit();

        return student;
    }
    public Student createStudent(Student student){
        tx.begin();
        em.persist(student);
        tx.commit();
        return student;
    }

    public Student findStudent(Long id) {
        return em.find(Student.class, id);
    }

    public void removeStudent(Long id){
        Student student = em.find(Student.class, id);
        if(student != null){
            tx.begin();
            em.remove(student);
            tx.commit();
        }
    }

    public void removeStudent(Student student){
        Student student1ToBeDeleted = em.merge(student);
        tx.begin();
        em.remove(student1ToBeDeleted);
        tx.commit();

    }
}
