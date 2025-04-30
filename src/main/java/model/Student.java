package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentId;
    private String fullName;
    private User user;
    private String dateOfBirth;
    private String gender;
}
