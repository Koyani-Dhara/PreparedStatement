import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection connection;
	//private ResultSet resultSet;
	//private String query;
	
	EmployeeDAOImpl() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL,DBUSER,DBPASSWORD);
		
		
	}

	@Override
	public Boolean createEmployee(Employee employee) {
		
		
		try {
			//PreparedStatement stat=connection.prepareStatement("Update student SET fname=?, lname=?, age=? WHERE id=?");  
			PreparedStatement stat=connection.prepareStatement("insert into student values (?,?,?,?)");
			stat.setString(1,"160010116015");
			stat.setString(2,"Foram");
			stat.setString(3,"Gajera");
			stat.setInt(4,20);
			
			stat.execute();
			//int i=stat.executeUpdate();
			
			System.out.println("Employee Created.");
		} catch (Exception e) {
			
			return false;
		}
		return true;
		
	}
		public Boolean deleteEmployee(String  id) {
		
	
		try {
			PreparedStatement stat=connection.prepareStatement("delete from student where id=?");  
			stat.setString(1,"160010116015");  
			  
			stat.execute();
			System.out.println("Deleted");
		} catch (SQLException e) {
			return false;
			
		}
		return true;
	}

		public Employee getEmployee(String id) {
			//query ="select * from Employee_tbl where empId = '"+empId+"'";
			Employee employee=new Employee();
			try {
				PreparedStatement stmt=connection.prepareStatement("select * from student");  
				ResultSet rs=stmt.executeQuery();  
				while(rs.next()){  
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));  
				
					employee.setId(rs.getString(1));
					employee.setFname(rs.getString(2));
					employee.setLname(rs.getString(3));
					employee.setAge(rs.getInt(4));
				
				} 
				
				
				
				return employee;
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			return new Employee();
			

		}

		@Override
		public Boolean update(Employee employee) {
			
			try {
				PreparedStatement stmt=connection.prepareStatement("update student set fname=?, lname=?, age=? where id=?");  
				
				stmt.setString(1,"Jalak");
				stmt.setString(2,"Gajera");
				stmt.setInt(3,20);
				stmt.setString(4,"160010116015");
				  
			 
				int i=stmt.executeUpdate();
				System.out.println(i + "records updated"); 
			} catch (SQLException e) {
				return false;
			}
			return true;
		}
		public List<Employee> getAllEmployee()  {
			
		//query =	"select * from student";
			
			
			List<Employee> emplist=new ArrayList<Employee>();
			try {
				PreparedStatement stmt=connection.prepareStatement("select * from student");
				ResultSet rs =stmt.executeQuery();
				
				while(rs.next()) {
					
					Employee employee=new Employee();
					employee.setId(rs.getString(1));
					employee.setFname(rs.getString(2));
					employee.setLname(rs.getString(3));
					employee.setAge(rs.getInt(4));
					emplist.add(employee);
				}
			} catch (SQLException e) {
				return null;
			}
			
			return emplist;
			
			
		
		}
}
