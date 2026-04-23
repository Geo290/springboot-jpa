package com.springjpaintro.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpaintro.demo.entity.Teacher;

@Repository
public interface TeacherRepository2 extends JpaRepository<Teacher, UUID> {
    Optional<Teacher> findByName(String name);
}
