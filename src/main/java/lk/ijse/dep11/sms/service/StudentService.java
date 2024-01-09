package lk.ijse.dep11.sms.service;

import lk.ijse.dep11.sms.repository.StudentRepository;
import lk.ijse.dep11.sms.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/*@Component*/
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student)  {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            try {
                throw new IllegalAccessException("email taken");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        studentRepository.save(student);
        System.out.println(student);
    }
}
