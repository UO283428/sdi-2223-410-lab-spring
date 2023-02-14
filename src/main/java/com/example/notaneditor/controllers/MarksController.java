package com.example.notaneditor.controllers;

import com.example.notaneditor.entities.Mark;
import com.example.notaneditor.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;


    @RequestMapping("/mark/list")
    public String getList() {
        return marksService.getMarks().toString();
    }
    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "OK";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        return "OK";
    }
}
