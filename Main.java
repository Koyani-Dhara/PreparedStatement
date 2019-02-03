import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Employee employee=new Employee();
			
		
		EmployeeDAOImpl employeDAOImpl=new EmployeeDAOImpl();
		
		//employeDAOImpl.createEmployee(employee);
		//employeDAOImpl.deleteEmployee("160010116015");
		//System.out.println(employeDAOImpl.getEmployee("160010116022"));
		
		employeDAOImpl.update(employee);
		
		//System.out.println(employeDAOImpl.getAllEmployee());
		
		

	}

}
