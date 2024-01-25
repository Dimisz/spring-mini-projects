package com.uningen.AdvancedCrud.dao;

import com.uningen.AdvancedCrud.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
}
