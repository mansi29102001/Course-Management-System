package coursename;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class loginsignup {

	JFrame frame;
	private JLabel lblNewLabel;
	private JTextField emaillogin;
	private JPasswordField passwordlogin;
	private JLabel lblemaillogin;
	private JLabel lblpasswordlogin;
	private JLabel lblloginas_login;
	public static String firstname;
	public static String lastname;
	public static String Email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginsignup window = new loginsignup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static boolean isValidEmailId(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

	/**
	 * Create the application.
	 */
	public loginsignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Sitka Display", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (104).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(190, 240, 385, 374);
		frame.getContentPane().add(image1lable);
		
		JLabel welcome = new JLabel("WELCOME BACK!!");
		welcome.setForeground(new Color(255, 204, 0));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Segoe UI", Font.BOLD, 35));
		welcome.setBounds(588, 122, 330, 43);
		frame.getContentPane().add(welcome);
		
		JLabel email = new JLabel("E-MAIL ID     :");
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Segoe UI", Font.BOLD, 23));
		email.setBounds(672, 296, 172, 45);
		frame.getContentPane().add(email);
		
		emaillogin = new JTextField();
		emaillogin.setHorizontalAlignment(SwingConstants.CENTER);
		emaillogin.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		emaillogin.setBounds(906, 303, 198, 45);
		frame.getContentPane().add(emaillogin);
		emaillogin.setColumns(10);
		
		JLabel password = new JLabel(" PASSWORD   :");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setFont(new Font("Segoe UI", Font.BOLD, 23));
		password.setBounds(672, 401, 172, 45);
		frame.getContentPane().add(password);
		
		JLabel logintocontinue = new JLabel("Login to continue");
		logintocontinue.setFont(new Font("Segoe UI", Font.BOLD, 23));
		logintocontinue.setForeground(new Color(0, 51, 102));
		logintocontinue.setBounds(656, 175, 208, 32);
		frame.getContentPane().add(logintocontinue);
		
		JLabel loginas = new JLabel(" LOGIN AS      :");
		loginas.setFont(new Font("Segoe UI", Font.BOLD, 23));
		loginas.setBounds(672, 495, 172, 45);
		
		frame.getContentPane().add(loginas);
		
		final JComboBox loginas_login = new JComboBox();
		loginas_login.setBackground(new Color(255, 255, 255));
		loginas_login.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		loginas_login.addItem("Select your choice");
		loginas_login.addItem("Administrator");
		loginas_login.addItem("Instructor");
		loginas_login.addItem("Student");
		loginas_login.setBounds(906, 507, 198, 35);
		frame.getContentPane().add(loginas_login);
		
		JLabel newuser = new JLabel("New User??");
		newuser.setFont(new Font("Segoe UI", Font.BOLD, 22));
		newuser.setBounds(1027, 55, 132, 20);
		frame.getContentPane().add(newuser);
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerpage nw =new registerpage();
				nw.frame1.setVisible(true);
				frame.dispose();
			}
		});
		signup.setFont(new Font("Segoe UI", Font.BOLD, 22));
		signup.setBackground(new Color(0, 51, 102));
		signup.setForeground(new Color(255, 255, 255));
		signup.setBounds(1167, 48, 121, 32);
		frame.getContentPane().add(signup);
		
		JButton LOGIN = new JButton("LOGIN");
		LOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (emaillogin.getText().trim().isEmpty() && passwordlogin.getText().trim().isEmpty() &&  loginas_login.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");
				}
				if(emaillogin.getText().trim().isEmpty()) {
					lblemaillogin.setText("*E-mail is required ");
				}
				if(passwordlogin.getText().trim().isEmpty()) {
					lblpasswordlogin.setText("*Password is required ");
				}
				if(loginas_login.getSelectedItem().toString().equals("Select your choice")) {
					lblloginas_login.setText("*This field is required");
				}
				else {
					String emailid = emaillogin.getText();
					String Password = passwordlogin.getText();
					String Loginas = loginas_login.getSelectedItem().toString();
					
					if(!isValidEmailId(emailid)) {
	                	JOptionPane.showMessageDialog(null,"Invalid Email");
	                }
					if(loginas_login.getSelectedItem().toString().equals("Administrator") && emaillogin.getText().equals("admin@gmail.com") && passwordlogin.getText().equals("admin123")){
						welcomeadmin nw =new welcomeadmin();
					    nw.frame11.setVisible(true);
					    frame.dispose();
					}
					if(loginas_login.getSelectedItem().toString().equals("Instructor")){
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
							PreparedStatement pstmt, pstmt2;
							ResultSet rs,rs2;
							pstmt=connection.prepareStatement("SELECT * FROM instructorinfo WHERE " + "(E_mailID = ?) "  + "and (pass_word = ?) " );
							pstmt.setString(1, emailid);
							pstmt.setString(2, Password);
							rs=pstmt.executeQuery();
							if(rs.next()) {
								JOptionPane.showMessageDialog(null, "Login Successfull !!");
								pstmt2=connection.prepareStatement("SELECT * FROM instructorinfo WHERE E_mailID=?");
								pstmt2.setString(1, emailid);
								rs2=pstmt2.executeQuery();
								if(rs2.next()) {
									String approve=rs.getString("approve");
									firstname=rs.getString("first_name");
									lastname=rs.getString("last_name");
									Email=rs.getString("E_mailID");
									if(approve.equals("Yes")) {
										instructorform nw=new instructorform();
										nw.frame14.setVisible(true);
										frame.dispose();
									}
									else {
										JOptionPane.showMessageDialog(null, "Form Not Approved, Try again later");
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Wrong Email or password");
							}
						}catch (Exception exception) {
		                    exception.printStackTrace();
		                }
					}
					
					if(loginas_login.getSelectedItem().toString().equals("Student")){
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
							PreparedStatement pstmt,pstmt2;
							ResultSet rs,rs2;
							pstmt=connection.prepareStatement("SELECT * FROM studentinfo WHERE " + "(E_mailID = ?) "  + "and (pass_word = ?) " );
							pstmt.setString(1, emailid);
							pstmt.setString(2, Password);
							rs=pstmt.executeQuery();
							if(rs.next()) {
								JOptionPane.showMessageDialog(null, "Login Successfull !!");
								pstmt2=connection.prepareStatement("SELECT * FROM studentinfo WHERE E_mailID=?");
								pstmt2.setString(1, emailid);
								rs2=pstmt2.executeQuery();
								if(rs2.next()) {
									String approve=rs.getString("approve");
									firstname=rs.getString("first_name");
									lastname=rs.getString("last_name");
									Email=rs.getString("E_mailID");
									if(approve.equals("Yes")) {
										studentform nw=new studentform();
										nw.frame15.setVisible(true);
										frame.dispose();
									}
									else {
										JOptionPane.showMessageDialog(null, "Form Not Approved, Try again later");
									}
									
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Wrong Email or password");
							}
							connection.close();
						}catch (Exception exception) {
		                    exception.printStackTrace();
		                }
					}
				}
			}
		});
		LOGIN.setForeground(new Color(255, 255, 255));
		LOGIN.setBackground(new Color(0, 51, 102));
		LOGIN.setFont(new Font("Segoe UI", Font.BOLD, 22));
		LOGIN.setBounds(814, 640, 121, 43);
		frame.getContentPane().add(LOGIN);
		
		passwordlogin = new JPasswordField();
		passwordlogin.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		passwordlogin.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlogin.setBounds(906, 401, 198, 45);
		frame.getContentPane().add(passwordlogin);
		
		lblemaillogin = new JLabel("");
		lblemaillogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblemaillogin.setForeground(Color.RED);
		lblemaillogin.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblemaillogin.setBounds(906, 358, 198, 20);
		frame.getContentPane().add(lblemaillogin);
		
		lblpasswordlogin = new JLabel("");
		lblpasswordlogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblpasswordlogin.setForeground(Color.RED);
		lblpasswordlogin.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblpasswordlogin.setBounds(906, 456, 198, 20);
		frame.getContentPane().add(lblpasswordlogin);
		
		lblloginas_login = new JLabel("");
		lblloginas_login.setForeground(Color.RED);
		lblloginas_login.setHorizontalAlignment(SwingConstants.CENTER);
		lblloginas_login.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblloginas_login.setBounds(906, 552, 198, 20);
		frame.getContentPane().add(lblloginas_login);
		
		
		
	}
}
