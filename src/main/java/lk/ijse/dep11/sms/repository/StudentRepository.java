package lk.ijse.dep11.sms.repository;

import lk.ijse.dep11.sms.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
