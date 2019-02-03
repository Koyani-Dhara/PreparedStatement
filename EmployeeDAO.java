import java.util.List;

public interface EmployeeDAO {
	
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/studentmgt";
	final String DBUSER ="root";
	final String DBPASSWORD ="";
	public Boolean createEmployee(Employee employee);
	public Employee getEmployee(String id);
	public Boolean deleteEmployee(String id);
	public Boolean update(Employee employee);
	public  List<Employee> getAllEmployee();

}
