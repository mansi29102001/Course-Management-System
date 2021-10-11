package coursename;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class instructortextfield {

	JFrame frame9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructortextfield window = new instructortextfield();
					window.frame9.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public instructortextfield() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame9 = new JFrame();
		frame9.getContentPane().setBackground(Color.WHITE);
		frame9.getContentPane().setLayout(null);
		frame9.setBounds(100, 100, 1920, 1080);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel imageinstructor = new JLabel("");
		Border blackline = BorderFactory.createLineBorder(Color.black);
		imageinstructor.setBorder(blackline);
		imageinstructor.setBackground(Color.WHITE);
		imageinstructor.setHorizontalAlignment(SwingConstants.CENTER);
		imageinstructor.setBounds(728, 149, 169, 207);
		frame9.getContentPane().add(imageinstructor);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel.setBounds(674, 397, 133, 35);
		frame9.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_1.setBounds(674, 458, 133, 35);
		frame9.getContentPane().add(lblNewLabel_1);
		
		final JTextArea instructorFN = new JTextArea();
		instructorFN.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		instructorFN.setBackground(SystemColor.inactiveCaptionBorder);
		instructorFN.setBounds(830, 398, 120, 35);
		frame9.getContentPane().add(instructorFN);
		
		final JTextArea instructorLN = new JTextArea();
		instructorLN.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		instructorLN.setBackground(SystemColor.inactiveCaptionBorder);
		instructorLN.setBounds(830, 459, 122, 35);
		frame9.getContentPane().add(instructorLN);
		
		JLabel lblNewLabel_2 = new JLabel("Profile Background");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 27));
		lblNewLabel_2.setBounds(1131, 343, 324, 35);
		frame9.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Education");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_3.setBounds(1114, 434, 150, 35);
		frame9.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_4.setBounds(1114, 519, 150, 35);
		frame9.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Applying For");
		lblNewLabel_5.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_5.setBounds(1114, 594, 150, 35);
		frame9.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Experience");
		lblNewLabel_6.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_6.setBounds(1114, 684, 150, 35);
		frame9.getContentPane().add(lblNewLabel_6);
		
		final JTextArea instructoreducation = new JTextArea();
		instructoreducation.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructoreducation.setBackground(SystemColor.inactiveCaptionBorder);
		instructoreducation.setBounds(1305, 436, 150, 35);
		frame9.getContentPane().add(instructoreducation);
		
		final JTextArea instructorcourse = new JTextArea();
		instructorcourse.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructorcourse.setBackground(SystemColor.inactiveCaptionBorder);
		instructorcourse.setBounds(1305, 521, 150, 35);
		frame9.getContentPane().add(instructorcourse);
		
		final JTextArea instructorspecialization = new JTextArea();
		instructorspecialization.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructorspecialization.setBackground(SystemColor.inactiveCaptionBorder);
		instructorspecialization.setBounds(1305, 598, 150, 35);
		frame9.getContentPane().add(instructorspecialization);
		
		final JTextArea instructorexperience = new JTextArea();
		instructorexperience.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructorexperience.setBackground(SystemColor.inactiveCaptionBorder);
		instructorexperience.setBounds(1305, 688, 150, 35);
		frame9.getContentPane().add(instructorexperience);
		
		JLabel lblNewLabel_7 = new JLabel("E-Mail");
		lblNewLabel_7.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_7.setBounds(172, 432, 142, 35);
		frame9.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No");
		lblNewLabel_8.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_8.setBounds(172, 521, 142, 35);
		frame9.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date Of Birth");
		lblNewLabel_9.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_9.setBounds(172, 604, 142, 35);
		frame9.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender");
		lblNewLabel_10.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_10.setBounds(172, 684, 142, 35);
		frame9.getContentPane().add(lblNewLabel_10);
		
		final JTextArea instructoremail = new JTextArea();
		instructoremail.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		instructoremail.setBackground(SystemColor.inactiveCaptionBorder);
		instructoremail.setBounds(324, 436, 150, 35);
		frame9.getContentPane().add(instructoremail);
		
		final JTextArea instructormobile = new JTextArea();
		instructormobile.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructormobile.setBackground(SystemColor.inactiveCaptionBorder);
		instructormobile.setBounds(324, 521, 150, 35);
		frame9.getContentPane().add(instructormobile);
		
		final JTextArea instructordob = new JTextArea();
		instructordob.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructordob.setBackground(SystemColor.inactiveCaptionBorder);
		instructordob.setBounds(324, 604, 150, 35);
		frame9.getContentPane().add(instructordob);
		
		final JTextArea instructorgender = new JTextArea();
		instructorgender.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructorgender.setBackground(SystemColor.inactiveCaptionBorder);
		instructorgender.setBounds(324, 688, 150, 35);
		frame9.getContentPane().add(instructorgender);
		
		JLabel lblNewLabel_11 = new JLabel("Personal Information");
		lblNewLabel_11.setForeground(new Color(128, 0, 128));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Sitka Display", Font.BOLD, 27));
		lblNewLabel_11.setBounds(175, 343, 299, 35);
		frame9.getContentPane().add(lblNewLabel_11);
		
		JButton approve1 = new JButton("Approve");
		approve1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("UPDATE instructorinfo set approve= ? WHERE "+"(E_mailID=?)");
					pstmt.setString(1, "Yes");
					pstmt.setString(2, instructorapprove.email);
					pstmt.executeUpdate(); 
					JOptionPane.showMessageDialog(null, "Application Approved Successfully !!");
					adminlogin nw = new adminlogin();
					nw.frame5.setVisible(true);
					frame9.dispose();
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		approve1.setForeground(Color.WHITE);
		approve1.setBackground(new Color(0, 51, 102));
		approve1.setFont(new Font("Sitka Display", Font.BOLD, 23));
		approve1.setBounds(728, 751, 169, 35);
		frame9.getContentPane().add(approve1);
		
		JLabel lblNewLabel_12 = new JLabel("Instructor's Application");
		lblNewLabel_12.setForeground(Color.decode("#6F1E51"));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_12.setBounds(623, 21, 408, 40);
		frame9.getContentPane().add(lblNewLabel_12);
		
		final JTextArea instructorlanguages = new JTextArea();
		instructorlanguages.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		instructorlanguages.setBackground(SystemColor.inactiveCaptionBorder);
		instructorlanguages.setBounds(792, 519, 214, 35);
		frame9.getContentPane().add(instructorlanguages);
		
		JLabel lblNewLabel_1_1 = new JLabel("Languages :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(644, 519, 133, 35);
		frame9.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Show Details");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM instructorinfo WHERE "+"(E_mailID=?)");
					pstmt.setString(1, instructorapprove.email);
					ResultSet rs=pstmt.executeQuery(); 
					while(rs.next()) {
						instructorFN.setText(rs.getString("first_name"));
						instructorLN.setText(rs.getString("last_name"));
						instructorlanguages.setText(rs.getString("languagespoken"));
						instructoremail.setText(rs.getString("E_mailID"));
						instructormobile.setText(rs.getString("Mobile_no"));
						instructorgender.setText(rs.getString("Gender"));
						instructoreducation.setText(rs.getString("education"));
						instructorcourse.setText(rs.getString("course"));
						instructorspecialization.setText(rs.getString("specialization"));
						instructorexperience.setText(rs.getString("experience"));
						instructordob.setText(rs.getString("Date_of_birth"));	
						byte[] img = rs.getBytes("photo");
						ImageIcon image = new ImageIcon(img);
	                    Image im = image.getImage();
	                    Image myImg = im.getScaledInstance(imageinstructor.getWidth(), imageinstructor.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    imageinstructor.setIcon(newImage);
					}
					connection.close();
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 23));
		btnNewButton.setBackground(Color.decode("#eb3b5a"));
		btnNewButton.setBounds(728, 82, 169, 35);
		frame9.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				instructorapprove nw =new instructorapprove();
				nw.frame7.setVisible(true);
				frame9.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame9.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_34 = new JLabel("Back");
		lblNewLabel_34.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_34.setBounds(46, 36, 45, 20);
		frame9.getContentPane().add(lblNewLabel_34);
		
	}
}
