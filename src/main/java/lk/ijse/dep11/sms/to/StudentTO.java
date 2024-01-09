package lk.ijse.dep11.sms.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public StudentTO(String name, String email, LocalDate dob, Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}
