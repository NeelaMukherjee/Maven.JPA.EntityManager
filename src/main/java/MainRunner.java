import entities.Artist;
import entities.CD;
import entities.Student;
import entities.Subject;
import services.CDService;
import services.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class MainRunner {

    public static void main(String ...args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDService service = new CDService(em);

        Set<Artist> artists = new HashSet<Artist>();
        artists.add(new Artist("Hemanta", "Mukherjee", "Harmonium"));
        artists.add(new Artist("Manna", "Dey", "Flute"));



        CD cd = service.createCD(new CD("Rabindrasangeet", "Released: September 24, 1991", 1991, artists));

        System.out.println("CD Persistend : " + cd);

        cd  = service.findCD(cd.getId());

        System.out.println("Found CD : " + cd);

        System.out.println("Artists : " + cd.getArtists());

        service.removeCD(cd);

        System.out.println("Removed CD : " + cd);

        StudentService studentervice = new StudentService(em);

        Set<Subject> subjects = new HashSet<Subject>();
        Subject subject = new Subject();
        subject.setSubjectName("SpringBoot");
        subjects.add(subject);

        Subject subject1 = new Subject();
        subject1.setSubjectName("CoreJava");
        subjects.add(subject1);

        Student student = new Student();
        student.setFirst_name("Adrish");
        student.setLast_name("Das");
        student.setSubjects(subjects);

        Student createdStudent = studentervice.createStudent(student);


        student = new Student();
        student.setFirst_name("Abhishek");
        student.setLast_name("Das");
        student.setSubjects(subjects);

        createdStudent = studentervice.createStudent(student);

        System.out.println("Student Persisted : " + student.getId());

        student = studentervice.findStudent(createdStudent.getId());
        System.out.println("Student Found    : " + student.getId());


    }


}
