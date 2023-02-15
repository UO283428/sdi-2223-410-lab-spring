package com.uniovi.notaneditor.controllers;

import com.uniovi.notaneditor.entities.Teacher;
import com.uniovi.notaneditor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired //Inyectar el servicio
    private TeacherService teacherService;


    @RequestMapping("/teacher/list")
    public String getList(Model model) {
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "teacher/list";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        return "teacher/details";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/list";
    }
}