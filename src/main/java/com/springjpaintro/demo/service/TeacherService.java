package com.springjpaintro.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.springjpaintro.demo.entity.Teacher;
import com.springjpaintro.demo.repository.TeacherRepository;

import java.util.Optional;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepo;

    public Teacher saveTeacher(String name, String subject, String password) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSubject(subject);
        teacher.setPassword(password);
        return teacherRepo.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public Optional<Teacher> findTeacherById(@NonNull Long id) {
        return Optional.ofNullable(
                teacherRepo
                        .findById(id)
                        .orElse(null));
    }

    public Optional<Teacher> findAnUpdateTeacher(@NonNull Long id, Map<String, Object> updates) {
        Optional<Teacher> teacherOpt = findTeacherById(id);
        if (teacherOpt.isEmpty()) {
            return Optional.empty();
        }
        Teacher teacher =gt teacherOpt.get();
        if (updates.containsKey("name")) {
            teacher.setName((String) updates.get("name"));
        }
        if (updates.containsKey("subject")) {
            teacher.setSubject((String) updates.get("subject"));
        }

        return Optional.ofNullable(
                teacherRepo.save(teacher));
    }

    public void findAndDeleteTeacher(@NonNull Long id) {
        teacherRepo.deleteById(id);
    }

}
