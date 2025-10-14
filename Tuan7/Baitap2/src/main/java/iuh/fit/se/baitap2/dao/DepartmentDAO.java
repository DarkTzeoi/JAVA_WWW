package iuh.fit.se.baitap2.dao;

import iuh.fit.se.baitap2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Long> {
    Department findDepartmentByDeptName(String deptName);
}
