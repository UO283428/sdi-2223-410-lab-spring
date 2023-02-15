package com.uniovi.notaneditor.services;

import com.uniovi.notaneditor.entities.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherService {

    private List<Teacher> teacherList = new LinkedList<>();
    @PostConstruct
    public void init() {
        teacherList.add(new Teacher(1L, "1111", "name1", "surname1", "cat1"));
        teacherList.add(new Teacher(2L, "2222", "name2", "surname2", "cat2"));
    }

    public List<Teacher> getTeachers() {
        return List.copyOf(teacherList);
    }

    public Teacher getTeacher(Long id) {
        return teacherList.stream()
                .filter(teacher -> teacher.getId().equals(id)).findFirst().get();
    }
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }
    public void deleteTeacher(Long id) {
        teacherList.removeIf(teacher -> teacher.getId().equals(id));
    }
}