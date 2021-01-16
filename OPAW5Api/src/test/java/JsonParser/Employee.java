package JsonParser;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder(value = {
		"name",
		"id",
		"salary",
		"designation"
})
public class Employee {

	private String name , designation;
	private int id , salary;
	
	public Employee(String name, String designation, int id, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.id = id;
		this.salary = salary;
	}
	public Employee()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + ", id=" + id + ", salary=" + salary + "]";
	}
}
