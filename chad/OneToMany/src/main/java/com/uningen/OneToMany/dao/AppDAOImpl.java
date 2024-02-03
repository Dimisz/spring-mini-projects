package com.uningen.OneToMany.dao;

import com.uningen.OneToMany.entities.Course;
import com.uningen.OneToMany.entities.Instructor;
import com.uningen.OneToMany.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }


    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // instructor not found
        if(instructor == null){
            System.out.println("Instructor with id: " + id +
                    " was not found");
        }
        // delete the instructor
        else {
            System.out.println("Instructor found. Deleting...");
            // get the courses
            List<Course> courses = instructor.getCourses();
            // break association with the instructor
            for(Course course: courses){
                course.setInstructor(null);
            }

            entityManager.remove(instructor);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        if(instructorDetail == null){
            System.out.println("No instructor details with id [" + id + "] found");
        }
        else {
            // delete only details while keeping the instructor
            // remove the association ELSE WILL NOT DELETE
            instructorDetail.getInstructor().setInstructorDetail(null);

            entityManager.remove(instructorDetail);
            System.out.println("Instructor detail with id: [" +
                    id + "] deleted.");
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );
        query.setParameter("data", id);

        // execute the query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        Instructor instructor = null;
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :data", Instructor.class
        );
        try {
            query.setParameter("data", id);
            instructor = query.getSingleResult();
        }
        catch(EmptyResultDataAccessException emptyResultExeption){
            System.out.println("Empty result returned for instructor with id: " + id + ".");
        }
        catch(NoResultException noResult){
            System.out.println("No result returned for instructor with id: " + id + ".");
        }
        catch(Exception ex){
            System.out.println("Something went wrong:");
            System.out.println(ex);
        }

        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        // retrieve the course
        Course course = entityManager.find(Course.class, id);
        if(course == null){
            System.out.println("Course with id: " + id + " was not found");
        }
        else {
            // delete the course
            String courseTitle = course.getTitle();
            entityManager.remove(course);
            System.out.println("The '" + courseTitle + "' with id: " + id + " has been removed");
        }
    }
}
