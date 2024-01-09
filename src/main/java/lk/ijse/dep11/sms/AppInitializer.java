package lk.ijse.dep11.sms;

import lk.ijse.dep11.sms.to.StudentTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class,args);
    }
    @GetMapping
    public List<StudentTO> hello(){
        return List.of(
                new StudentTO(1L,"Kasun","P@gmail.com", LocalDate.of(2000, Month.JANUARY,5),21)
        );
    }
}
