package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
    public Teacher getTeacherByDni(String dni) {return teacherRepository.findByDni(dni);
    }
}