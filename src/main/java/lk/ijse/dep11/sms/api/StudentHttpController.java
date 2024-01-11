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

    @GetMapping(produces = "application/json")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "{studentId}",consumes = "application/json")
    public void updateStudent(  @PathVariable("studentId") Long studentId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
}
