package iuh.fit.se.baitap1.impl;

import iuh.fit.se.baitap1.dao.EmployeeDAO;
import iuh.fit.se.baitap1.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void update(Employee employee) {

    }

    @Override
    public List<Employee> getAll() {
        String sql = "Select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee getById(int id) {
        String sql = """
                Select * from employee where id = ?
                """;
        return jdbcTemplate.queryForObject(
                sql, new BeanPropertyRowMapper<>(Employee.class), id
        );
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee(name, role) VALUES (?, ?)";
        jdbcTemplate.update(sql,employee.getName(), employee.getRole());
    }
}
