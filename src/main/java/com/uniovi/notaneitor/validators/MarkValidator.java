package com.uniovi.notaneitor.validators;
import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class MarkValidator implements Validator {
    @Autowired
    private MarksService marksService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Teacher.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");

        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.addMark.score");}

        if (mark.getDescription().length() < 20) {
            errors.rejectValue("description", "Error.addMark.description.length");}
    }
}