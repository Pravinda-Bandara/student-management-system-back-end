package lk.ijse.dep11.sms.api;

import lk.ijse.dep11.sms.service.StudentService;
import lk.ijse.dep11.sms.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

}
