package lk.ijse.dep11.sms.api;

import lk.ijse.dep11.sms.service.StudentService;
import lk.ijse.dep11.sms.to.StudentTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "api/v1/students")
public class StudentHttpController {

    @Autowired
    private final StudentService studentService;

    public StudentHttpController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentTO> getStudents(){
        return studentService.getStudents();
    }

}
