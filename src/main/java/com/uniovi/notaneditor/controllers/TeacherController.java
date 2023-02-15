package com.uniovi.notaneditor.controllers;

import com.uniovi.notaneditor.entities.Teacher;
import com.uniovi.notaneditor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired //Inyectar el servicio
    private TeacherService teacherService;


    @RequestMapping("/teacher/list")
    public String getList(Model model) {
        List<Teacher> teacherList  = teacherService.getTeachers();
        return teacherList.toString();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "Added";
    }

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
       Teacher t = teacherService.getTeacher(id);
        return t.toString();
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "deleted";
    }
}