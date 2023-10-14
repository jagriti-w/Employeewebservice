import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e.salary FROM Employee e WHERE e.salary = (SELECT MAX(salary) FROM Employee)")
    String getHighestSalaryOfEmployees();
	
	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> getEmployeesByNameSearch(@Param("name") String name);
	
	@Query("SELECT e.name FROM Employee e ORDER BY e.salary DESC")
    List<String> getTop10HighestEarningEmployeeNames();
}
    
}