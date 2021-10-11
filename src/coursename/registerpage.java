package coursename;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class registerpage {

	JFrame frame1;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField email;
	private JTextField mobile_no;
	private JPasswordField confirm_password;
	private JPasswordField password;
	private JLabel fnre;
	private JLabel lnre;
	private JLabel emailre;
	private JComboBox registeras2;
	private JLabel registeras_validation;
	public static String firstname,lastname,mobile,Email,Password,registeras;
	private JLabel mobilere;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerpage window = new registerpage();
					window.frame1.setVisible(true);
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
	public registerpage() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.WHITE);
		frame1.setBackground(new Color(255, 255, 255));
		frame1.setBounds(100, 100, 1920, 1080);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel image2lable = new JLabel();
		image2lable.setBackground(new Color(255, 255, 255));
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (107).png"));
		image2lable.setIcon(img);
		image2lable.setBounds(858, 151, 517, 455);
		frame1.getContentPane().add(image2lable);
		
		JLabel registerpage = new JLabel(" REGISTERATION");
		registerpage.setForeground(Color.decode("#6F1E51"));
		registerpage.setHorizontalAlignment(SwingConstants.CENTER);
		registerpage.setFont(new Font("Segoe UI", Font.BOLD, 32));
		registerpage.setBounds(582, 29, 389, 61);
		frame1.getContentPane().add(registerpage);
		
		JLabel lalel = new JLabel("Thank you for joining us! Please register by completing the information below. ");
		lalel.setForeground(new Color(153, 0, 204));
		lalel.setHorizontalAlignment(SwingConstants.CENTER);
		lalel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lalel.setBounds(411, 100, 788, 39);
		frame1.getContentPane().add(lalel);
		
		final JLabel lblfirstname = new JLabel("First Name");
		lblfirstname.setForeground(new Color(0, 0, 0));
		lblfirstname.setHorizontalAlignment(SwingConstants.LEFT);
		lblfirstname.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblfirstname.setBounds(265, 246, 120, 30);
		frame1.getContentPane().add(lblfirstname);
		
		final JLabel lbllastname = new JLabel("Last Name");
		lbllastname.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbllastname.setBounds(531, 246, 120, 30);
		frame1.getContentPane().add(lbllastname);
		
		first_name = new JTextField();
		first_name.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		first_name.setHorizontalAlignment(SwingConstants.CENTER);
		first_name.setBounds(265, 286, 184, 45);
		frame1.getContentPane().add(first_name);
		first_name.setColumns(10);
		
		last_name = new JTextField();
		last_name.setHorizontalAlignment(SwingConstants.CENTER);
		last_name.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		last_name.setBounds(531, 286, 194, 45);
		frame1.getContentPane().add(last_name);
		last_name.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmail.setBounds(265, 364, 120, 30);
		frame1.getContentPane().add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMobileNumber.setBounds(531, 364, 173, 30);
		frame1.getContentPane().add(lblMobileNumber);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		email.setBounds(265, 415, 184, 45);
		frame1.getContentPane().add(email);
		email.setColumns(10);
		
		mobile_no = new JTextField();
		mobile_no.setHorizontalAlignment(SwingConstants.CENTER);
		mobile_no.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		mobile_no.setBounds(531, 415, 194, 45);
		frame1.getContentPane().add(mobile_no);
		mobile_no.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPassword.setBounds(265, 493, 120, 30);
		frame1.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblConfirmPassword.setBounds(529, 493, 196, 30);
		frame1.getContentPane().add(lblConfirmPassword);
		
		JButton next = new JButton("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				
				
				if (mobile_no.getText().trim().isEmpty() &&first_name.getText().trim().isEmpty() && last_name.getText().trim().isEmpty() && email.getText().trim().isEmpty() &&  registeras2.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");
				}
				if(first_name.getText().trim().isEmpty()) {
					fnre.setText("*Firstname is required ");
				}
				if(last_name.getText().trim().isEmpty()) {
					lnre.setText("*Lastname is required ");
				}
				if(email.getText().trim().isEmpty()) {
					emailre.setText("*E-mail is required ");
				}
				if(registeras2.getSelectedItem().toString().equals("Select your choice")) {
					registeras_validation.setText("*This field is required");
				}
				if(mobile_no.getText().trim().isEmpty()) {
					mobilere.setText("*Mobile no is required ");
				}
				
				
				
				else {
					firstname=first_name.getText();
					lastname=last_name.getText();
					Email = email.getText();
				    mobile = mobile_no.getText();
					int len = mobile.length();
					Password = password.getText();
					registeras= registeras2.getSelectedItem().toString();
					String CPassword = confirm_password.getText();
				 String msg = "" + firstname;
	                msg += " \n";
	               
	                
	                if (len != 10) {
	                    JOptionPane.showMessageDialog(null, "Enter a valid mobile number");
	                }
	                else {
	                	if(!isValidEmailId(Email)) {
		                	JOptionPane.showMessageDialog(null,"Invalid Email");
		                }
						else {
							if (!Password.equals(CPassword)) {
								JOptionPane.showMessageDialog(null, "Password Mismatch");
							}
							else {
								if (registeras2.getSelectedItem().toString().equals("Instructor")) {
									instructer nw =new instructer();
								    nw.frame2.setVisible(true);
								    frame1.dispose();
								}
								
								else if (registeras2.getSelectedItem().toString().equals("Student")) {
									studentprofile nw =new studentprofile();
								    nw.frame3.setVisible(true);
								    frame1.dispose();
								}
							}
							
							
						}
	                }
	
					}
				
				
				}
		});
		next.setForeground(new Color(255, 255, 255));
		next.setBackground(new Color(0, 51, 102));
		next.setFont(new Font("Segoe UI", Font.BOLD, 22));
		next.setBounds(1008, 638, 285, 51);
		frame1.getContentPane().add(next);
		
		registeras2 = new JComboBox(); 
		registeras2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		registeras2.addItem("Select your choice");
		registeras2.addItem("Instructor");
		registeras2.addItem("Student");
		registeras2.setBounds(454, 638, 209, 39);
		frame1.getContentPane().add(registeras2);
		
		JLabel registeras = new JLabel("Register As");
		registeras.setHorizontalAlignment(SwingConstants.CENTER);
		registeras.setForeground(Color.BLACK);
		registeras.setFont(new Font("Segoe UI", Font.BOLD, 20));
		registeras.setBounds(312, 638, 120, 39);
		frame1.getContentPane().add(registeras);
		
		confirm_password = new JPasswordField();
		confirm_password.setHorizontalAlignment(SwingConstants.CENTER);
		confirm_password.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		confirm_password.setBounds(531, 544, 194, 45);
		frame1.getContentPane().add(confirm_password);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		password.setBounds(265, 544, 184, 45);
		frame1.getContentPane().add(password);
		
		fnre = new JLabel();
		fnre.setHorizontalAlignment(SwingConstants.CENTER);
		fnre.setForeground(Color.RED);
		fnre.setFont(new Font("Sitka Display", Font.BOLD, 14));
		fnre.setBounds(265, 341, 184, 17);
		frame1.getContentPane().add(fnre);
		
	
		
		lnre = new JLabel();
		lnre.setForeground(Color.RED);
		lnre.setFont(new Font("Sitka Display", Font.BOLD, 14));
		lnre.setHorizontalAlignment(SwingConstants.CENTER);
		lnre.setBounds(531, 341, 194, 17);
		frame1.getContentPane().add(lnre);
		
		
		emailre = new JLabel();
		emailre.setHorizontalAlignment(SwingConstants.CENTER);
		emailre.setForeground(Color.RED);
		emailre.setFont(new Font("Sitka Display", Font.BOLD, 14));
		emailre.setBounds(265, 470, 184, 17);
		frame1.getContentPane().add(emailre);
		
		registeras_validation = new JLabel();
		registeras_validation.setFont(new Font("Sitka Display", Font.BOLD, 14));
		registeras_validation.setForeground(Color.RED);
		registeras_validation.setHorizontalAlignment(SwingConstants.CENTER);
		registeras_validation.setBounds(454, 687, 209, 17);
		frame1.getContentPane().add(registeras_validation);
		
		mobilere = new JLabel();
		mobilere.setHorizontalAlignment(SwingConstants.CENTER);
		mobilere.setForeground(Color.RED);
		mobilere.setFont(new Font("Sitka Display", Font.BOLD, 14));
		mobilere.setBounds(531, 470, 194, 17);
		frame1.getContentPane().add(mobilere);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				loginsignup nw =new loginsignup();
				nw.frame.setVisible(true);
				frame1.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame1.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_34 = new JLabel("Back");
		lblNewLabel_34.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_34.setBounds(46, 36, 45, 20);
		frame1.getContentPane().add(lblNewLabel_34);
		
	}
}
