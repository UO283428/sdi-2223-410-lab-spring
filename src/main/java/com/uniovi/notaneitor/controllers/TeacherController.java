package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.TeacherService;
import com.uniovi.notaneitor.validators.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired //Inyectar el servicio
    private TeacherService teacherService;

    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping("/professor/list")
    public String getList(Model model) {
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "professor/list";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setTeacher(@Validated Teacher teacher, BindingResult result) {
        teacherValidator.validate(teacher, result);
        if (result.hasErrors()){
            return "/professor/add";
        }

        teacherService.addTeacher(teacher);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/add")
    public String getTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "professor/add";
    }


    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/professor/list";
    }

    @RequestMapping(value = "/professor/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("teacher", teacherService.getTeacher(id));
        return "professor/edit";
    }

    @RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/professor/details/"+ teacher.getId();
    }
}