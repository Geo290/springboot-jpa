package com.springjpaintro.demo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.springjpaintro.demo.entity.Teacher;

public interface TeacherRepository extends ListCrudRepository<Teacher, Long> {
    
}
