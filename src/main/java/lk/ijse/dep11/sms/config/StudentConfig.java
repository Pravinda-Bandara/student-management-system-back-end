package lk.ijse.dep11.sms.config;

import lk.ijse.dep11.sms.repository.StudentRepository;
import lk.ijse.dep11.sms.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student pravinda = new Student(
                    "Pravinda",
                    "P@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));

            Student kasun = new Student(

                    "Kasun",
                    "K@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5));
            repository.saveAll(List.of(pravinda,kasun));
        };
    }
}
