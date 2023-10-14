import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
    @Autowired
    public  EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
	
	@Override
    public Employee getEmployeeById(int id) 
    {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent())
            employee = result.get();
        else
            throw new RuntimeException("Employee id not found - " + id);
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) 
    {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) 
    {
        employeeRepository.deleteById(id);
    }
	
	@Override
    public void deleteEmployee(int id) 
    {
        employeeRepository.deleteById(id);
    }
	
	@Override
	public String getHighestSalaryOfEmployees(){
		return employeeRepository.getHighestSalaryOfEmployees();
	}
	
	@Override
	public List<Employee> getEmployeesByNameSearch(String name){
		List<Employee> result = employeeRepository.getEmployeesByNameSearch(name);
		return result;
	}
	
	@Override
	public List<Employee> getTop10HighestEarningEmployeeNames(){
		List<Employee> result = employeeRepository.getTop10HighestEarningEmployeeNames();
		return result;
	}
}
