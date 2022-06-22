import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class query {
	
		private static final String db_driver = "com.mysql.cj.jdbc.Driver";
		private static final String db_url = "jdbc:mysql://localhost:3306/ems";
		private static final String db_username = "root";
		private static final String db_password = "@Jan142009!@";
			
	
	query(String newFName, String newLName, String newAddy, String newDep){

			Connection conn = null;
		
			newFName.toString();
			
			try {
				Class.forName(db_driver);
				conn = DriverManager.getConnection(db_url, db_username,db_password);
				
				if(conn != null) {
					System.out.println("Successfully connected.");
				
					String query1 = "INSERT INTO employeeData1 (FirstName,LastName,Department,Address)"
										+ "VALUES(?,?,?,?)";
					
					PreparedStatement pstmt = conn.prepareStatement(query1);
					
					pstmt.setString(1, newFName);
					pstmt.setString(2, newLName);
					pstmt.setString(3, newDep);
					pstmt.setString(4, newAddy);
					
					pstmt.executeUpdate();
					
					
				}
				else{
					   System.out.println("Failed to connect.");
					}
				
			
				}
			catch (Exception e){
				e.printStackTrace();
			}
		}

		
	
	
		
}
	
	

