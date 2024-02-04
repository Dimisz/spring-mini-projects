package com.uningen.AdvancedCrud.dao;

import com.uningen.AdvancedCrud.entity.Instructor;
import com.uningen.AdvancedCrud.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
