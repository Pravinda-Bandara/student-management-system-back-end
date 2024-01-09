package lk.ijse.dep11.sms.service;

import lk.ijse.dep11.sms.to.StudentTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
/*@Component*/
@Service
public class StudentService {
    public List<StudentTO> getStudents(){
        return List.of(
                new StudentTO(1L,"Kasun","P@gmail.com", LocalDate.of(2000, Month.JANUARY,5),21)
        );
    }
}
