package iuh.fit.se.baitap2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;
    private String deptName;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.EAGER
    )
    private Set<Employee> employees;
}
