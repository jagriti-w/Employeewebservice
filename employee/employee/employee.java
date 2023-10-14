package SpringBoot.SpringDataJPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "salary")
    private String salary;
	
	@Column(name = "age")
    private String age;
	
	@ConditionalJsonIgnore(onMethods = HttpMethod.POST)
	@Column(name = "profile_image")
    private String profile_image = "";

    public Employee() {
    }

    public Employee(String name, String salary, String age, String profile_image) {
        this.name = name;
        this.salary = salary;
        this.age = age;
		this.profile_image = profile_image;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setFirstName(String Name) {
        this.firstName = firstName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
	
	public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
	
	public  void setProfileImage(String profile_image) {
        this.profile_image = profile_image;
    }

	public String getProfileImage(){
		return profile_image;
	}
	
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ",profile_image= "+ profile_image + '}';
    }
    
}