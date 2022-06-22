import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class loginWin implements ActionListener {
	
	//Frame
	JFrame logWindow = new JFrame();

	
	//Labels
	JLabel userInfoLabel = new JLabel("Enter Username");
	JLabel passInfoLabel = new JLabel("Enter Password");
	JLabel welcomeMsg = new JLabel("Welcome!");
	JLabel noLogin = new JLabel("");
	
	//Buttons
	JButton logButton = new JButton("Login");
	JButton regButton = new JButton("Register");
	
	
	//TextEntry
	JTextField userInput = new JTextField();
	JPasswordField passInput = new JPasswordField();
	
	
	
	HashMap<String,String> logInfo = new HashMap<String,String>();
	
	loginWin(HashMap<String,String> loginInfo1){
		logInfo = loginInfo1;
		
		JLabel title = new JLabel("Employee Management System V1");
		title.setFont(new Font(null, Font.BOLD, 18));
		title.setBounds(30, 50, 350, 100);
		
		userInfoLabel.setBounds(50, 150, 150, 25);
		userInput.setBounds(200, 150, 150 , 25);
		
		passInfoLabel.setBounds(50, 200, 150, 25);
		passInput.setBounds(200, 200, 150,25);
		
		logButton.setBounds(100, 300, 100, 30);
		logButton.setFocusable(false);
		logButton.addActionListener(this);
		
		regButton.setBounds(200, 300, 100, 30);
		regButton.setFocusable(false);
		regButton.addActionListener(this);
		
		logWindow.add(userInfoLabel);
		logWindow.add(userInput);
		logWindow.add(passInfoLabel);
		logWindow.add(passInput);
		logWindow.add(logButton);
		logWindow.add(regButton);
		logWindow.add(title);
		logWindow.add(noLogin);
		
		logWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logWindow.setSize(400,400);
		logWindow.setLayout(null);
		logWindow.setVisible(true);
		
		
		
	}
	
	@Override

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==regButton) {
			regWindow reg1 = new regWindow();
		}
		
		
		if(e.getSource()==logButton) {
			String username1 = userInput.getText();
			String password1 = String.valueOf(passInput.getPassword());
			
			if(logInfo.containsKey(username1)) {
				if(logInfo.get(username1).equals(password1)) {
					boolean loggedIn = true;
					homeWindow home1 = new homeWindow(loggedIn);
					logWindow.dispose();
				
				}
				else {
					noLogin.setText("Incorrect Password");
					noLogin.setBounds(100,25,250,25);
					noLogin.setFont(new Font(null, Font.BOLD, 20));
			
					
					}
				}
			else {
				noLogin.setText("Incorrect Username");
				System.out.print("Incorrect Username");
				noLogin.setBounds(100,25,250,25);
				noLogin.setFont(new Font(null, Font.BOLD, 20));
					}
						
		}
	}

}
