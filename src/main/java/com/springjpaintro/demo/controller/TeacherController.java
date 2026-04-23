package com.springjpaintro.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.springjpaintro.demo.entity.Teacher;
import com.springjpaintro.demo.service.TeacherService;

import java.util.Optional;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        String teacherName = teacher.getName();
        String teacherSubject = teacher.getSubject();
        String teacherPass = teacher.getPassword();
        System.out.println(teacherName + " " + teacherSubject + " " + teacherPass);
        return teacherService.saveTeacher(teacherName, teacherSubject, teacherPass);
    }

    @GetMapping("/get-all")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Teacher> findTeacherById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PatchMapping("/patch-info/{id}")
    public Optional<Teacher> findAndPatchTeacer(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return teacherService.findAnUpdateTeacher(id, updates);
    }

    @PutMapping("/update-info/{id}")
    public Optional<Teacher> findAndUpdateTeacher(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return teacherService.findAnUpdateTeacher(id, updates);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> findAndDeleteTeacher(@PathVariable Long id) {
        teacherService.findAndDeleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
