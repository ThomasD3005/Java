
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class regWindow implements ActionListener {
	
	JFrame regWin = new JFrame();
	JLabel reglabel = new JLabel("Registration");
		//Labels
		JLabel fname = new JLabel("Enter First Name");
		JLabel lname = new JLabel("Enter Last Name");
		JLabel addressEmp = new JLabel("Enter Employee Address");
		JLabel department = new JLabel("Enter Employee Department");
		JLabel newUser = new JLabel("Enter Username");
		JLabel newPass = new JLabel("Enter Password");
		
		
		//JTextField
		JTextField fNameInp = new JTextField();
		JTextField lNameInp = new JTextField();
		JTextField addyInp = new JTextField();
		JTextField depInp = new JTextField();
		JTextField newUserInp = new JTextField();
		JTextField newPassInp = new JTextField();
		
		//Buttons
		JButton submitButton = new JButton("Submit");
		
		
	regWindow(){
		
		submitButton.addActionListener(this);

		
		//layout
		reglabel.setFont(new Font(null, Font.BOLD, 20));
		reglabel.setBounds(183, 25, 200, 25);
		
		fname.setBounds(25,50,150,25);
		fNameInp.setBounds(25,75,150,25);
		
		lname.setBounds(25,100,150,25);
		lNameInp.setBounds(25,125,150,25);
		
		addressEmp.setBounds(25,150,200,25);
		addyInp.setBounds(25,175,300,25);
		
		department.setBounds(25,200,200,25);
		depInp.setBounds(25,225,150,25);
		
		newUser.setBounds(25,250,150,25);
		newUserInp.setBounds(25,275,200,25);
		
		newPass.setBounds(25,300,150,25);
		newPassInp.setBounds(25,325,200,25);
		
		submitButton.setBounds(190,370,125,30);
		
		
		//add to frame 
		regWin.add(reglabel);
		
		regWin.add(fname);
		regWin.add(fNameInp);
		
		regWin.add(lname);
		regWin.add(lNameInp);
		
		regWin.add(addressEmp);
		regWin.add(addyInp);
		
		regWin.add(department);
		regWin.add(depInp);
		
		regWin.add(newUser);
		regWin.add(newUserInp);
		
		regWin.add(newPass);
		regWin.add(newPassInp);
		
		regWin.add(submitButton);
		
			
		regWin.setSize(500,450);
		regWin.setLayout(null);
		regWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regWin.setVisible(true);
			
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submitButton) {
			
			String[] newarr = new String[6];
			newarr[0] = fNameInp.getText().toString();
			newarr[1] = lNameInp.getText().toString();
			newarr[2] = addyInp.getText().toString();
			newarr[3] = depInp.getText().toString();
			newarr[4] = newUserInp.getText().toString();
			newarr[5] = newPassInp.getText().toString();
			
			String newFName = newarr[0];
			String newLName = newarr[1];
			String newAddy = newarr[2];
			String newDep = newarr[3];
			
			query newQuery = new query(newFName, newLName, newAddy,newDep);
			
			
		}
		
		
	}
	

	
}
