package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyleConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import com.toedter.calendar.JCalendar;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class instructer {

	JFrame frame2;
	private JTextField languages;
	private JLabel education2;
	private JLabel course2;
	private JLabel specialization2;
	private JLabel experience2;
	private JComboBox education;
	private JComboBox course;
	private JComboBox applyingfor;
	private JComboBox experience;
	private JLabel languages2;
	private JLabel adhar2;
	private JLabel adhar;
	private JTextField DOB;
	private JLabel dob1;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton other;
	private JLabel gender_validation;
	private JComboBox gender;
	public String s;
	public File id2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructer window = new instructer();
					window.frame2.setVisible(true);
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
	public instructer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(Color.WHITE);
		frame2.setBounds(100, 100, 1920, 1080);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (141).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(1034, 80, 468, 453);
		frame2.getContentPane().add(image1lable);
		
		final JLabel instructorimage = new JLabel("");
		Border blackline = BorderFactory.createLineBorder(Color.black);
		instructorimage.setBorder(blackline);
		instructorimage.setBackground(Color.WHITE);
		instructorimage.setHorizontalAlignment(SwingConstants.CENTER);
		instructorimage.setBounds(52, 80, 169, 207);
		frame2.getContentPane().add(instructorimage);
		
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
		              instructorimage.setIcon(ResizeImage(path));
		              s=path;
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
		        Image newImg = img.getScaledInstance(instructorimage.getWidth(), instructorimage.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
				
			}
		});
		browse.setBackground(Color.decode("#4b6584"));
		browse.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		browse.setBounds(89, 322, 100, 30);
		frame2.getContentPane().add(browse);
		
		JLabel lblNewLabel_1 = new JLabel("DOB :");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_1.setBounds(52, 482, 85, 35);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender :");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_2.setBounds(54, 664, 99, 35);
		frame2.getContentPane().add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Spoken Languages :");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_3.setBounds(490, 614, 217, 35);
		frame2.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("* Profile Background *");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_5.setBounds(490, 134, 431, 45);
		frame2.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Education     :");
		lblNewLabel_6.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_6.setBounds(490, 249, 217, 35);
		frame2.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Course         :");
		lblNewLabel_7.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_7.setBounds(490, 344, 217, 35);
		frame2.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Applying for :");
		lblNewLabel_8.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_8.setBounds(490, 433, 219, 35);
		frame2.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Experience   :");
		lblNewLabel_9.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_9.setBounds(490, 526, 217, 35);
		frame2.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Upload ID (ADHAR )");
		lblNewLabel_10.setFont(new Font("Sitka Display", Font.BOLD, 25));
		lblNewLabel_10.setBounds(1131, 566, 232, 30);
		frame2.getContentPane().add(lblNewLabel_10);
		
		languages = new JTextField();
		languages.setHorizontalAlignment(SwingConstants.CENTER);
		languages.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		languages.setBounds(704, 611, 217, 40);
		frame2.getContentPane().add(languages);
		languages.setColumns(10);
		
		JButton registerinstuctor = new JButton("Register");
		registerinstuctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				
				if ((gender.getSelectedItem().toString().equals("Select your choice")) && DOB.getText().trim().isEmpty() && adhar.getText().trim().isEmpty() && languages.getText().trim().isEmpty() && education.getSelectedItem().toString().equals("Select your choice") && course.getSelectedItem().toString().equals("Select your choice") && applyingfor.getSelectedItem().toString().equals("Select your choice") && experience.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
					
				}
				if(education.getSelectedItem().toString().equals("Select your choice")) {
					education2.setText("*This field is required ");flag=1;
				}
				if(gender.getSelectedItem().toString().equals("Select your choice")) {
					gender_validation.setText("*This field is required");flag=1;
				}
				if(course.getSelectedItem().toString().equals("Select your choice")) {
					course2.setText("*This field  is required ");flag=1;
				}
				if(applyingfor.getSelectedItem().toString().equals("Select your choice")) {
					specialization2.setText("*This field  is required ");flag=1;
				}
				if(experience.getSelectedItem().toString().equals("Select your choice")) {
					experience2.setText("*This field is required");flag=1;
				}
				if(languages.getText().trim().isEmpty()) {
					languages2.setText("*This field is required ");flag=1;
				}
				if(adhar.getText().trim().isEmpty()) {
					adhar2.setText("*This field is required ");flag=1;
				}
				if(DOB.getText().trim().isEmpty()) {
					dob1.setText("*This field is required ");flag=1;
				}
				else {
					if(!isValiddob(DOB.getText())) {
						dob1.setText("*Enter a valid Date of birth");flag=1;
					}
					
				}
				if(flag==0) {
					
					String dateofbirth=DOB.getText();
					String Education=education.getSelectedItem().toString();
					String Course=course.getSelectedItem().toString();
					String Specialization=applyingfor.getSelectedItem().toString();
					String Experience=experience.getSelectedItem().toString();
					String Languages=languages.getText();
					String Gender=gender.getSelectedItem().toString();
					
					 try {
		                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
		                    String query = "INSERT INTO instructorinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		                    PreparedStatement statement=connection.prepareStatement(query);
		                    FileInputStream fis=new FileInputStream(s);
		                    FileInputStream adhar=new FileInputStream(id2);
							statement.setString(1,registerpage.firstname);
							statement.setString(2,registerpage.lastname);
							statement.setString(3,registerpage.Email);
							statement.setString(4,registerpage.mobile);
							statement.setString(5,registerpage.Password);
							statement.setString(6,registerpage.registeras);
							statement.setBinaryStream(7,fis);
							statement.setString(8,dateofbirth);
							statement.setString(9,Gender);
							statement.setString(10,Education);
							statement.setString(11,Course);
							statement.setString(12,Specialization);
							statement.setString(13,Experience);
							statement.setString(14,Languages);
							statement.setBinaryStream(15,adhar);
							statement.setString(16,"No");
							statement.executeUpdate();
							JOptionPane.showMessageDialog(null,"Registered Successfully!!");
		                    connection.close();
		                    
		                    registrationsuccessful nw =new registrationsuccessful();
						    nw.frame4.setVisible(true);
						    frame2.dispose();
		                    
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				}
				
			}

		});
		registerinstuctor.setBackground(new Color(0, 51, 102));
		registerinstuctor.setForeground(new Color(255, 255, 255));
		registerinstuctor.setFont(new Font("Sitka Display", Font.BOLD, 25));
		registerinstuctor.setBounds(629, 710, 150, 45);
		frame2.getContentPane().add(registerinstuctor);
		
		JLabel lblNewLabel_13 = new JLabel("jpg, gif ,png only");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.RED);
		lblNewLabel_13.setFont(new Font("Sitka Display", Font.PLAIN, 19));
		lblNewLabel_13.setBounds(1352, 569, 133, 25);
		frame2.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Instructor Details");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setForeground(Color.decode("#6F1E51"));
		lblNewLabel_14.setBackground(new Color(255, 255, 255));
		lblNewLabel_14.setFont(new Font("Sitka Display", Font.BOLD, 45));
		lblNewLabel_14.setBounds(571, 10, 350, 50);
		frame2.getContentPane().add(lblNewLabel_14);
		
		education = new JComboBox();
		education.setBackground(Color.WHITE);
		education.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		education.setBounds(709, 249, 212, 35);
		education.addItem("Select your choice");
		education.addItem("Graduation");
		education.addItem("Post-Graduation");
		education.addItem("PHD");
		education.addItem("Diploma");
		frame2.getContentPane().add(education);
		
		course = new JComboBox();
		course.setBackground(Color.WHITE);
		course.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		course.setBounds(711, 344, 210, 35);
		course.addItem("Select your choice");
		course.addItem("BSC");
		course.addItem("MSC");
		course.addItem("B-TECH");
		course.addItem("BCA");
		course.addItem("MCA");
		course.addItem("BE");
		course.addItem("M-TECH");
		frame2.getContentPane().add(course);
		
		applyingfor = new JComboBox();
		applyingfor.setBackground(Color.WHITE);
		applyingfor.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		applyingfor.addItem("Select your choice");
		applyingfor.addItem("Computer");
		applyingfor.addItem("Physics");
		applyingfor.addItem("Mechanics");
		applyingfor.addItem("Iot");
		applyingfor.addItem("Mathematics");
		applyingfor.addItem("Chemistry");
		applyingfor.addItem("Botany");
		applyingfor.addItem("Biology");
		applyingfor.addItem("Electronics");
		applyingfor.addItem("History");
		applyingfor.addItem("Political");
		applyingfor.addItem("Geography");
		applyingfor.addItem("Economics");
		applyingfor.setBounds(711, 433, 210, 35);
		frame2.getContentPane().add(applyingfor);
		
		experience = new JComboBox();
		experience.setBackground(Color.WHITE);
		experience.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		experience.addItem("Select your choice");
		experience.addItem("Fresher");
		experience.addItem("Less than 5 years");
		experience.addItem("Less than 10 years");
		experience.addItem("More than 10 years");
		experience.setBounds(709, 526, 212, 35);
		frame2.getContentPane().add(experience);
		
		adhar = new JLabel("");
		Border blackline1 = BorderFactory.createLineBorder(Color.black);
		adhar.setBorder(blackline1);
		adhar.setBounds(1141, 606, 310, 61);
		frame2.getContentPane().add(adhar);
		
		JButton btnid = new JButton("Browse ID");
		btnid.setForeground(Color.WHITE);
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frame2);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    adhar.setText("Selected file: " + selectedFile.getName());
				    id2 = new File(selectedFile.getAbsolutePath());
				}
			}
		});
		btnid.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		btnid.setBackground(Color.decode("#4b6584"));
		btnid.setBounds(1238, 678, 125, 30);
		frame2.getContentPane().add(btnid);
		
		education2 = new JLabel("");
		education2.setHorizontalAlignment(SwingConstants.CENTER);
		education2.setForeground(Color.RED);
		education2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		education2.setBounds(709, 294, 212, 20);
		frame2.getContentPane().add(education2);
		
		course2 = new JLabel("");
		course2.setHorizontalAlignment(SwingConstants.CENTER);
		course2.setForeground(Color.RED);
		course2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		course2.setBounds(709, 389, 212, 20);
		frame2.getContentPane().add(course2);
		
		specialization2 = new JLabel("");
		specialization2.setHorizontalAlignment(SwingConstants.CENTER);
		specialization2.setForeground(Color.RED);
		specialization2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		specialization2.setBounds(709, 477, 212, 20);
		frame2.getContentPane().add(specialization2);
		
		experience2 = new JLabel("");
		experience2.setHorizontalAlignment(SwingConstants.CENTER);
		experience2.setForeground(Color.RED);
		experience2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		experience2.setBounds(709, 576, 212, 20);
		frame2.getContentPane().add(experience2);
		
		languages2 = new JLabel("");
		languages2.setHorizontalAlignment(SwingConstants.CENTER);
		languages2.setForeground(Color.RED);
		languages2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		languages2.setBounds(704, 664, 217, 20);
		frame2.getContentPane().add(languages2);
		
		adhar2 = new JLabel("");
		adhar2.setForeground(Color.RED);
		adhar2.setHorizontalAlignment(SwingConstants.CENTER);
		adhar2.setFont(new Font("Sitka Display", Font.PLAIN, 13));
		adhar2.setBounds(1170, 718, 310, 21);
		frame2.getContentPane().add(adhar2);
		
		DOB = new JTextField();
		DOB.setHorizontalAlignment(SwingConstants.CENTER);
		DOB.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		DOB.setBounds(53, 524, 167, 38);
		frame2.getContentPane().add(DOB);
		DOB.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DD/MM/YY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 569, 157, 25);
		frame2.getContentPane().add(lblNewLabel);
		
		dob1 = new JLabel("");
		dob1.setHorizontalAlignment(SwingConstants.CENTER);
		dob1.setForeground(Color.RED);
		dob1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		dob1.setBounds(53, 593, 180, 21);
		frame2.getContentPane().add(dob1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setFont(new Font("Sitka Display", Font.BOLD, 20));
		textArea.setBounds(52, 362, 170, 33);
		frame2.getContentPane().add(textArea);
		textArea.setText(registerpage.firstname);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		textArea_1.setBounds(52, 404, 170, 33);
		frame2.getContentPane().add(textArea_1);
		textArea_1.setText(registerpage.lastname);
		
		gender_validation = new JLabel("");
		gender_validation.setForeground(Color.RED);
		gender_validation.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		gender_validation.setHorizontalAlignment(SwingConstants.CENTER);
		gender_validation.setBounds(53, 707, 310, 20);
		frame2.getContentPane().add(gender_validation);
		
		gender = new JComboBox();
		gender.setBackground(Color.WHITE);
		gender.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		gender.setBounds(163, 664, 200, 35);
		frame2.getContentPane().add(gender);
		gender.addItem("Select your choice");
		gender.addItem("Male");
		gender.addItem("Female");
		gender.addItem("Others");
		
		JLabel lblNewLabel_7_1 = new JLabel("*Make sure all information is correct to avoid delay in approving form.");
		lblNewLabel_7_1.setForeground(Color.RED);
		lblNewLabel_7_1.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblNewLabel_7_1.setBounds(442, 765, 529, 25);
		frame2.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Browse appropriate image");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.RED);
		lblNewLabel_8_1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(52, 292, 169, 20);
		frame2.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				registerpage nw =new registerpage();
				nw.frame1.setVisible(true);
				frame2.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame2.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_34 = new JLabel("Back");
		lblNewLabel_34.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_34.setBounds(46, 36, 45, 20);
		frame2.getContentPane().add(lblNewLabel_34);
		
	}
}
