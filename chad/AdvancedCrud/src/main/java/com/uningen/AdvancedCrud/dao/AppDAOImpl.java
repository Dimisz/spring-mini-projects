package com.uningen.AdvancedCrud.dao;

import com.uningen.AdvancedCrud.entity.Instructor;
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
}
