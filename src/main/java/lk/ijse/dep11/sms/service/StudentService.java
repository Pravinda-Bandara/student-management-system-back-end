package lk.ijse.dep11.sms.service;

import lk.ijse.dep11.sms.repository.StudentRepository;
import lk.ijse.dep11.sms.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (exist) {
            studentRepository.deleteById(studentId);
        } else {
            throw new IllegalArgumentException("Student with ID " + studentId + " not found");
        }
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(()->new IllegalStateException(
                        "student with id dose not exist"
                ));
        if (name!=null && name.length() >0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if (email!=null && email.length() >0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
