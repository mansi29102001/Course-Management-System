package coursename;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class studenttextfield {

	JFrame frame10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studenttextfield window = new studenttextfield();
					window.frame10.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studenttextfield() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame10 = new JFrame();
		frame10.getContentPane().setBackground(Color.WHITE);
		frame10.getContentPane().setLayout(null);
		frame10.setBounds(100, 100, 1920, 1080);
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentapprove nw =new studentapprove();
				nw.frame8.setVisible(true);
				frame10.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame10.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_33 = new JLabel("Back");
		lblNewLabel_33.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_33.setBounds(46, 36, 45, 20);
		frame10.getContentPane().add(lblNewLabel_33);
	   
		
		final JLabel imagestudent = new JLabel("");
		Border blackline = BorderFactory.createLineBorder(Color.black);
		imagestudent.setBorder(blackline);
		imagestudent.setBackground(Color.WHITE);
		imagestudent.setHorizontalAlignment(SwingConstants.CENTER);
		imagestudent.setBounds(728, 137, 169, 207);
		frame10.getContentPane().add(imagestudent);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel.setBounds(674, 368, 133, 35);
		frame10.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_1.setBounds(674, 413, 133, 35);
		frame10.getContentPane().add(lblNewLabel_1);
		
		final JTextArea studentFN = new JTextArea();
		studentFN.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		studentFN.setBackground(SystemColor.inactiveCaptionBorder);
		studentFN.setBounds(830, 369, 120, 35);
		frame10.getContentPane().add(studentFN);
		
		final JTextArea studentLN = new JTextArea();
		studentLN.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		studentLN.setBackground(SystemColor.inactiveCaptionBorder);
		studentLN.setBounds(828, 414, 122, 35);
		frame10.getContentPane().add(studentLN);
		
		JLabel lblNewLabel_2 = new JLabel("Profile Background");
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 27));
		lblNewLabel_2.setBounds(1173, 343, 272, 35);
		frame10.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_3.setBounds(1114, 436, 150, 35);
		frame10.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Parents Name");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_4.setBounds(1114, 519, 150, 35);
		frame10.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("City Name");
		lblNewLabel_5.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_5.setBounds(1114, 596, 150, 35);
		frame10.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("State Name");
		lblNewLabel_6.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_6.setBounds(1114, 684, 150, 35);
		frame10.getContentPane().add(lblNewLabel_6);
		
		final JTextArea studentcourse = new JTextArea();
		studentcourse.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentcourse.setBackground(SystemColor.inactiveCaptionBorder);
		studentcourse.setBounds(1305, 436, 150, 35);
		frame10.getContentPane().add(studentcourse);
		
		final JTextArea studentpn = new JTextArea();
		studentpn.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentpn.setBackground(SystemColor.inactiveCaptionBorder);
		studentpn.setBounds(1305, 521, 150, 35);
		frame10.getContentPane().add(studentpn);
		
		final JTextArea studentcity = new JTextArea();
		studentcity.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentcity.setBackground(SystemColor.inactiveCaptionBorder);
		studentcity.setBounds(1305, 598, 150, 35);
		frame10.getContentPane().add(studentcity);
		
		final JTextArea studentstate = new JTextArea();
		studentstate.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentstate.setBackground(SystemColor.inactiveCaptionBorder);
		studentstate.setBounds(1305, 688, 150, 35);
		frame10.getContentPane().add(studentstate);
		
		JLabel lblNewLabel_7 = new JLabel("E-Mail");
		lblNewLabel_7.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_7.setBounds(172, 432, 142, 35);
		frame10.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No");
		lblNewLabel_8.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_8.setBounds(172, 521, 142, 35);
		frame10.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date Of Birth");
		lblNewLabel_9.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_9.setBounds(172, 604, 142, 35);
		frame10.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Gender");
		lblNewLabel_10.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_10.setBounds(172, 684, 142, 35);
		frame10.getContentPane().add(lblNewLabel_10);
		
		final JTextArea studentemail = new JTextArea();
		studentemail.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		studentemail.setBackground(SystemColor.inactiveCaptionBorder);
		studentemail.setBounds(324, 436, 150, 35);
		frame10.getContentPane().add(studentemail);
		
		final JTextArea studentmobile = new JTextArea();
		studentmobile.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentmobile.setBackground(SystemColor.inactiveCaptionBorder);
		studentmobile.setBounds(324, 521, 150, 35);
		frame10.getContentPane().add(studentmobile);
		
		final JTextArea studentdob = new JTextArea();
		studentdob.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentdob.setBackground(SystemColor.inactiveCaptionBorder);
		studentdob.setBounds(324, 604, 150, 35);
		frame10.getContentPane().add(studentdob);
		
		final JTextArea studentgender = new JTextArea();
		studentgender.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		studentgender.setBackground(SystemColor.inactiveCaptionBorder);
		studentgender.setBounds(324, 688, 150, 35);
		frame10.getContentPane().add(studentgender);
		
		final JLabel lblNewLabel_11 = new JLabel("Personal Information");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(new Color(128, 0, 128));
		lblNewLabel_11.setFont(new Font("Sitka Display", Font.BOLD, 27));
		lblNewLabel_11.setBounds(175, 343, 299, 35);
		frame10.getContentPane().add(lblNewLabel_11);
		
		JButton approve2 = new JButton("Approve");
		approve2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("UPDATE studentinfo set approve= ? WHERE "+"(E_mailID=?)");
					pstmt.setString(1, "Yes");
					pstmt.setString(2, studentapprove.email);
					pstmt.executeUpdate(); 
					JOptionPane.showMessageDialog(null, "Application Approved Successfully !!");
					adminlogin nw = new adminlogin();
					nw.frame5.setVisible(true);
					frame10.dispose();
					
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		approve2.setForeground(Color.WHITE);
		approve2.setBackground(new Color(0, 51, 102));
		approve2.setFont(new Font("Sitka Display", Font.BOLD, 23));
		approve2.setBounds(728, 751, 169, 35);
		frame10.getContentPane().add(approve2);
		
		JLabel lblNewLabel_12 = new JLabel("Students's Application");
		lblNewLabel_12.setForeground(Color.decode("#6F1E51"));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_12.setBounds(623, 21, 408, 40);
		frame10.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Sitka Display", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(674, 458, 133, 35);
		frame10.getContentPane().add(lblNewLabel_1_1);
		
		final JTextArea studentage = new JTextArea();
		studentage.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		studentage.setBackground(SystemColor.inactiveCaptionBorder);
		studentage.setBounds(828, 459, 122, 35);
		frame10.getContentPane().add(studentage);
		
		JButton btnNewButton = new JButton("Show Details");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM studentinfo WHERE "+"(E_mailID=?)");
					pstmt.setString(1, studentapprove.email);
					ResultSet rs=pstmt.executeQuery(); 
					while(rs.next()) {
						studentFN.setText(rs.getString("first_name"));
						studentLN.setText(rs.getString("last_name"));
						studentage.setText(rs.getString("age"));
						studentemail.setText(rs.getString("E_mailID"));
						studentmobile.setText(rs.getString("Mobile_no"));
						studentgender.setText(rs.getString("Gender"));
					    studentpn.setText(rs.getString("parents_name"));
						studentcourse.setText(rs.getString("course_name"));
						studentstate.setText(rs.getString("state_name"));
						studentcity.setText(rs.getString("city_name"));
						studentdob.setText(rs.getString("Date_of_birth"));		
						byte[] img = rs.getBytes("photo");
						ImageIcon image = new ImageIcon(img);
	                    Image im = image.getImage();
	                    Image myImg = im.getScaledInstance(imagestudent.getWidth(), imagestudent.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    imagestudent.setIcon(newImage);
					}
					connection.close();
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 23));
		btnNewButton.setBackground(Color.decode("#eb3b5a"));
		btnNewButton.setBounds(728, 79, 169, 35);
		frame10.getContentPane().add(btnNewButton);
	}

}
