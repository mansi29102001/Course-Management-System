package coursename;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class studentprofile {

	JFrame frame3;
	private JTextField age;
	private JTextField parentsname;
	private JTextField cityname;
	private JTextField statename;
	private JLabel statename2;
	private JLabel cityname2;
	private JLabel parentsname2;
	private JLabel coursename2;
	private JComboBox coursename;
	private JLabel age2;
	private JLabel uploadadhar;
	private JLabel adhar3;
	private JTextField dob3;
	private JLabel dob4;
	private JLabel gender_validation;
	private JComboBox gendername;
	public File id1;
	public String t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentprofile window = new studentprofile();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static boolean isValiddob(String dob) {
		String regex = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dob);
		return matcher.matches();
				
	}
	


	/**
	 * Create the application.
	 */
	public studentprofile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setFont(new Font("Sitka Display", Font.PLAIN, 18));
		frame3.getContentPane().setBackground(Color.WHITE);
		frame3.setBounds(100, 100, 1920, 1080);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (138).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(1063, 130, 385, 374);
		frame3.getContentPane().add(image1lable);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(544, 10, 385, 50);
		frame3.getContentPane().add(lblNewLabel);
		
		final JLabel studentimage = new JLabel("");
		studentimage.setBounds(42, 102, 169, 207);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		studentimage.setBorder(blackline);
		frame3.getContentPane().add(studentimage);
		
		JButton registerstudent = new JButton("Register");
		registerstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				
				if( gendername.getSelectedItem().toString().equals("Select your choice") && dob3.getText().trim().isEmpty() && uploadadhar.getText().trim().isEmpty() && coursename.getSelectedItem().toString().equals("Select your choice") && age.getText().trim().isEmpty() && parentsname.getText().trim().isEmpty() && cityname.getText().trim().isEmpty() && statename.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(age.getText().trim().isEmpty()) {
					age2.setText("*This field is required ");flag=1;
				}
				if(parentsname.getText().trim().isEmpty()) {
					parentsname2.setText("*This field is required ");flag=1;
				}
				if(gendername.getSelectedItem().toString().equals("Select your choice")) {
					gender_validation.setText("*This field is required ");flag=1;
				}
				if(cityname.getText().trim().isEmpty()) {
					cityname2.setText("*This field is required ");flag=1;
				}
				if(statename.getText().trim().isEmpty()) {
					statename2.setText("*This field is required ");flag=1;
				}
				if(coursename.getSelectedItem().toString().equals("Select your choice")) {
					coursename2.setText("*This field is required");flag=1;
				}
				if(uploadadhar.getText().trim().isEmpty()) {
					adhar3.setText("*This field is required ");flag=1;
				}
				if(dob3.getText().trim().isEmpty()) {
					dob4.setText("*This field is required ");flag=1;
				}
				else {
					if(!isValiddob(dob3.getText())) {
						dob4.setText("*Enter a valid Date of birth");flag=1;
					}
					
				}
				
				if (flag==0) {
					String dateofbirth=dob3.getText();
					String Age=age.getText();
					String PN=parentsname.getText();
					String Gender=gendername.getSelectedItem().toString();
					String City=cityname.getText();
					String State=statename.getText();
					String Coursename=coursename.getSelectedItem().toString();
					
					try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
	                    String query = "INSERT INTO studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	                    PreparedStatement statement=connection.prepareStatement(query);
	                    FileInputStream fis=new FileInputStream(t);
	                    FileInputStream adhar=new FileInputStream(id1);
						statement.setString(1,registerpage.firstname);
						statement.setString(2,registerpage.lastname);
						statement.setString(3,registerpage.Email);
						statement.setString(4,registerpage.mobile);
						statement.setString(5,registerpage.Password);
						statement.setString(6,registerpage.registeras);
						statement.setBinaryStream(7,fis);
						statement.setString(8,dateofbirth);
						statement.setString(9,Gender);
						statement.setString(10,Age);
						statement.setString(11,Coursename);
						statement.setString(12,PN);
						statement.setString(13,City);
						statement.setString(14,State);
						statement.setBinaryStream(15,adhar);
						statement.setString(16,"No");
						statement.executeUpdate();
						JOptionPane.showMessageDialog(null,"Registered Successfully!!");
	                    connection.close();
	                   
	                    registrationsuccessful nw =new registrationsuccessful();
					    nw.frame4.setVisible(true);
					    frame3.dispose();
	                    
					    
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				}
			}
		});
		registerstudent.setFont(new Font("Sitka Display", Font.BOLD, 25));
		registerstudent.setBackground(new Color(0, 51, 102));
		registerstudent.setForeground(new Color(255, 255, 255));
		registerstudent.setBounds(594, 712, 150, 45);
		frame3.getContentPane().add(registerstudent);
		
		JLabel lblNewLabel_2 = new JLabel("Gender :");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_2.setBounds(42, 697, 118, 30);
		frame3.getContentPane().add(lblNewLabel_2);
		
	
	    
	    JLabel lblNewLabel_3 = new JLabel("DOB :");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_3.setBounds(42, 497, 85, 30);
		frame3.getContentPane().add(lblNewLabel_3);
		
		JButton browse = new JButton("Browse");
		browse.setForeground(Color.WHITE);
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
		        file.setCurrentDirectory(new File(System.getProperty("user.home")));
		      //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              studentimage.setIcon(ResizeImage(path));
		              t=path;
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
			}
			
			private Icon ResizeImage(String ImagePath) {
				// TODO Auto-generated method stub
				ImageIcon MyImage = new ImageIcon(ImagePath);
		        Image img = MyImage.getImage();
		        Image newImg = img.getScaledInstance(studentimage.getWidth(), studentimage.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
				
			}
		});
		browse.setBackground(Color.WHITE);
		browse.setBackground(Color.decode("#4b6584"));
		browse.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		browse.setBounds(76, 340, 100, 30);
		frame3.getContentPane().add(browse);
		
		JLabel lblNewLabel_1 = new JLabel("* Profile Background *");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(502, 130, 380, 40);
		frame3.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Age :");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_4.setBounds(502, 251, 169, 35);
		frame3.getContentPane().add(lblNewLabel_4);
		
		age = new JTextField();
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		age.setBounds(712, 251, 170, 35);
		frame3.getContentPane().add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Course Name:");
		lblNewLabel_5.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_5.setBounds(502, 348, 169, 35);
		frame3.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Parents Name :");
		lblNewLabel_5_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_5_1.setBounds(502, 438, 169, 35);
		frame3.getContentPane().add(lblNewLabel_5_1);
		
		parentsname = new JTextField();
		parentsname.setHorizontalAlignment(SwingConstants.CENTER);
		parentsname.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		parentsname.setColumns(10);
		parentsname.setBounds(712, 438, 170, 35);
		frame3.getContentPane().add(parentsname);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("City Name :");
		lblNewLabel_5_1_2_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_5_1_2_1.setBounds(502, 526, 169, 35);
		frame3.getContentPane().add(lblNewLabel_5_1_2_1);
		
		cityname = new JTextField();
		cityname.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		cityname.setHorizontalAlignment(SwingConstants.CENTER);
		cityname.setColumns(10);
		cityname.setBounds(712, 526, 170, 35);
		frame3.getContentPane().add(cityname);
		
		statename = new JTextField();
		statename.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		statename.setHorizontalAlignment(SwingConstants.CENTER);
		statename.setColumns(10);
		statename.setBounds(712, 614, 170, 35);
		frame3.getContentPane().add(statename);
		
		JLabel lblNewLabel_5_1_2_1_1 = new JLabel("State Name :");
		lblNewLabel_5_1_2_1_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_5_1_2_1_1.setBounds(502, 614, 169, 35);
		frame3.getContentPane().add(lblNewLabel_5_1_2_1_1);
		
		coursename = new JComboBox();
		coursename.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		coursename.addItem("Select your choice");
		coursename.addItem("BSC");
		coursename.addItem("MSC");
		coursename.addItem("B-TECH");
		coursename.addItem("BCA");
		coursename.addItem("MCA");
		coursename.addItem("BE");
		coursename.addItem("M-TECH");
		coursename.setBackground(Color.WHITE);
		coursename.setBounds(712, 338, 170, 35);
		frame3.getContentPane().add(coursename);
		
		uploadadhar = new JLabel("");
		uploadadhar.setFont(new Font("Sitka Display", Font.PLAIN, 10));
		Border blackline1 = BorderFactory.createLineBorder(Color.black);
		uploadadhar.setBorder(blackline1);
		uploadadhar.setBounds(1103, 595, 300, 61);
		frame3.getContentPane().add(uploadadhar);
		
		JLabel lblNewLabel_13 = new JLabel("jpg, gif ,png only");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.RED);
		lblNewLabel_13.setFont(new Font("Sitka Display", Font.PLAIN, 19));
		lblNewLabel_13.setBounds(1356, 559, 133, 25);
		frame3.getContentPane().add(lblNewLabel_13);
		
		JButton btnid = new JButton("Browse ID");
		btnid.setForeground(Color.WHITE);
		btnid.setBackground(Color.WHITE);
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frame3);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    uploadadhar.setText("Selected file: " + selectedFile.getName());
				    id1 = new File(selectedFile.getAbsolutePath());
				}
			}
		});
		btnid.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		btnid.setBounds(1189, 666, 125, 30);
		btnid.setBackground(Color.decode("#4b6584"));
		frame3.getContentPane().add(btnid);
		
		JLabel lblNewLabel_10 = new JLabel("Upload ID (ADHAR )");
		lblNewLabel_10.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_10.setBounds(1141, 556, 235, 30);
		frame3.getContentPane().add(lblNewLabel_10);
		
		age2 = new JLabel("");
		age2.setHorizontalAlignment(SwingConstants.CENTER);
		age2.setForeground(Color.RED);
		age2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		age2.setBounds(712, 299, 170, 20);
		frame3.getContentPane().add(age2);
		
		coursename2 = new JLabel("");
		coursename2.setHorizontalAlignment(SwingConstants.CENTER);
		coursename2.setForeground(Color.RED);
		coursename2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		coursename2.setBounds(712, 393, 170, 20);
		frame3.getContentPane().add(coursename2);
		
		parentsname2 = new JLabel("");
		parentsname2.setHorizontalAlignment(SwingConstants.CENTER);
		parentsname2.setForeground(Color.RED);
		parentsname2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		parentsname2.setBounds(712, 484, 170, 20);
		frame3.getContentPane().add(parentsname2);
		
		cityname2 = new JLabel("");
		cityname2.setHorizontalAlignment(SwingConstants.CENTER);
		cityname2.setForeground(Color.RED);
		cityname2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cityname2.setBounds(712, 565, 170, 20);
		frame3.getContentPane().add(cityname2);
		
		statename2 = new JLabel("");
		statename2.setForeground(Color.RED);
		statename2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		statename2.setBounds(717, 662, 165, 20);
		frame3.getContentPane().add(statename2);
		
		adhar3 = new JLabel("");
		adhar3.setHorizontalAlignment(SwingConstants.CENTER);
		adhar3.setForeground(Color.RED);
		adhar3.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		adhar3.setBounds(1103, 706, 300, 21);
		frame3.getContentPane().add(adhar3);
		
		dob3 = new JTextField();
		dob3.setHorizontalAlignment(SwingConstants.CENTER);
		dob3.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		dob3.setColumns(10);
		dob3.setBounds(42, 537, 190, 38);
		frame3.getContentPane().add(dob3);
		
		JLabel lblNewLabel_6 = new JLabel("DD/MM/YY");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(42, 594, 190, 25);
		frame3.getContentPane().add(lblNewLabel_6);
		
		dob4 = new JLabel("");
		dob4.setHorizontalAlignment(SwingConstants.CENTER);
		dob4.setForeground(Color.RED);
		dob4.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		dob4.setBounds(42, 629, 190, 20);
		frame3.getContentPane().add(dob4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setFont(new Font("Sitka Display", Font.BOLD, 20));
		textArea.setBounds(42, 380, 169, 33);
		frame3.getContentPane().add(textArea);
		textArea.setText(registerpage.firstname);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		textArea_1.setBounds(42, 418, 169, 33);
		frame3.getContentPane().add(textArea_1);
		textArea_1.setText(registerpage.lastname);
		
		gender_validation = new JLabel("");
		gender_validation.setForeground(Color.RED);
		gender_validation.setHorizontalAlignment(SwingConstants.CENTER);
		gender_validation.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		gender_validation.setBounds(42, 737, 296, 20);
		frame3.getContentPane().add(gender_validation);
		
		gendername = new JComboBox();
		gendername.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		gendername.setBounds(161, 697, 177, 30);
		frame3.getContentPane().add(gendername);
		gendername.addItem("Select your choice");
		gendername.addItem("Male");
		gendername.addItem("Female");
		gendername.addItem("Others");
		
		JLabel lblNewLabel_7 = new JLabel("*Make sure all information is correct to avoid delay in approving form.");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(409, 767, 529, 25);
		frame3.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Browse appropriate image");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(42, 319, 169, 20);
		frame3.getContentPane().add(lblNewLabel_8);
	
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				registerpage nw =new registerpage();
				nw.frame1.setVisible(true);
				frame3.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame3.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_33 = new JLabel("Back");
		lblNewLabel_33.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_33.setBounds(46, 36, 45, 20);
		frame3.getContentPane().add(lblNewLabel_33);
	   
	}
}
