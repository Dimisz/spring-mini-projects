package com.uningen.OneToMany.dao;

import com.uningen.OneToMany.entities.Instructor;
import com.uningen.OneToMany.entities.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
