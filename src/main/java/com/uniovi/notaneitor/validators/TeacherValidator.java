package com.uniovi.notaneitor.validators;
import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class TeacherValidator implements Validator {
    @Autowired
    private TeacherService teacherService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Teacher.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Teacher teacher = (Teacher) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "Error.empty");

        if (teacher.getDni().length() < 9 | teacher.getDni().length() >= 10) {
            errors.rejectValue("dni", "Error.addTeacher.dni.length");}

        if (!Character.isAlphabetic(teacher.getDni().charAt(teacher.getDni().length()-1))) {
            errors.rejectValue("dni", "Error.addTeacher.dni.number");}

        if (teacherService.getTeacherByDni(teacher.getDni()) != null) {
            errors.rejectValue("dni", "Error.addTeacher.dni.duplicate");}
    }
}