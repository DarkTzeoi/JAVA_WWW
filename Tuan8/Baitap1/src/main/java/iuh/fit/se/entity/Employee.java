package iuh.fit.se.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Last name khong duoc phep rong!!!")
    private String lastName;
    @NotEmpty(message = "First name khong duoc phep rong!!!")
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Ngay sinh khong duoc de trong!!!")
    @Past(message = "Ngay sinh phai la ngay trong qua khu!!!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email khong duoc de trong!!!")
    @Email(message = "Dinh dang email khong hop le!!!")
    private String email;

    @Pattern(regexp = "^(0)\\d{9}$", message = "So dien thoai khong hop le!!!")
    private String phoneNumber;
}
