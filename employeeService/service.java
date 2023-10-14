import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    
    public Employee getEmployeeById(int theId);
    
    public void createEmployee(Employee theEmployee);
    
    public void deleteEmployee(int theId);
	
	public List<String> getTop10HighestEarningEmployeeNames();
	
	public String getHighestSalaryOfEmployees(); 
	
	public List<Employee> getEmployeesByNameSearch(String name);
}