import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class homeWindow {
	
	private static final String db_driver = "com.mysql.cj.jdbc.Driver";
	private static final String db_url = "jdbc:mysql://localhost:3306/ems";
	private static final String db_username = "root";
	private static final String db_password = "Password";
	
	JFrame homeFrame = new JFrame();
	JLabel title = new JLabel("Employee Management System V1");
	
	JTable dispHome = new JTable();
	String[] columnNames = {"First Name", "Last Name", "Department", "Address"};
	DefaultTableModel tableMod = new DefaultTableModel(columnNames, 0);
	
	homeWindow(boolean loggedIn){
		Connection conn = null;
		
		homeFrame.setSize(800,800);
		title.setFont(new Font(null, Font.BOLD, 18));
		title.setBounds(30, 50, 350, 100);
		
		if(loggedIn ==true) {
			
			try {
				Class.forName(db_driver);
				conn = DriverManager.getConnection(db_url, db_username,db_password);
				
				if(conn != null) {
					System.out.println("Successfully connected.");
				
					String query1 = "SELECT * FROM employeeData1";
					
					Statement sql = conn.createStatement();
					ResultSet rs1 = sql.executeQuery(query1);
					
					while(rs1.next()) {
						String FName = rs1.getString("FirstName");
						String LName = rs1.getString("LastName");
						String dep1 = rs1.getString("Department");
						String addy1 = rs1.getString("Address");
						
						String[] data = { FName, LName, dep1, addy1 };
						tableMod.addRow(data);
						
						System.out.format("%s, %s, %s, %s\n", FName, LName,dep1,addy1); 
						
						
					}
					dispHome.setModel(tableMod);
					
					rs1.close();
				}
				else{
					   System.out.println("Failed to connect.");
					}
				
			
				}
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
		homeFrame.add(dispHome);
		homeFrame.setVisible(true);
		
	}

}
