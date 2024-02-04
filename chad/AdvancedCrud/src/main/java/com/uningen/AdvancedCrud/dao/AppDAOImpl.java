package com.uningen.AdvancedCrud.dao;

import com.uningen.AdvancedCrud.entity.Instructor;
import com.uningen.AdvancedCrud.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    // inject entity manager using constructor injection
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


}
