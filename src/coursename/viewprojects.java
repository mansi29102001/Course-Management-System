package coursename;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class viewprojects {

	JFrame frame23;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JLabel lbltitle;
	private JLabel lblsubject;
	private JLabel lblemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewprojects window = new viewprojects();
					window.frame23.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewprojects() {
		initialize();
	}
	public void combo() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT E_mailID from studentinfo where approve=?");
			pstmt.setString(1, "Yes");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String str=rs.getString("E_mailID");
				comboBox_2.addItem(str);
			}
			connection.close();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	public void combo2() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT specialization from instructorinfo where approve=?");
			pstmt.setString(1, "Yes");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String str=rs.getString("specialization");
				comboBox.addItem(str);
			}
			connection.close();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame23 = new JFrame();
		frame23.getContentPane().setBackground(Color.WHITE);
		frame23.setBounds(100, 100, 1920, 1080);
		frame23.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame23.getContentPane().setLayout(null);
		
		final JLabel projectimage = new JLabel("");
		projectimage.setBounds(965, 233, 448, 496);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		projectimage.setBorder(blackline);
		frame23.getContentPane().add(projectimage);
		
		JLabel lblNewLabel_3 = new JLabel("PROJECT ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.decode("#6F1E51"));
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 36));
		lblNewLabel_3.setBounds(544, 23, 500, 45);
		frame23.getContentPane().add(lblNewLabel_3);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		textArea.setBounds(269, 395, 448, 245);
		frame23.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Summary :");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel.setBounds(38, 487, 226, 40);
		frame23.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setBounds(241, 88, 192, 40);
		frame23.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Student Email :");
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setBounds(818, 88, 226, 40);
		frame23.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_1 = new JLabel("Project Image");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_1.setBounds(1089, 756, 192, 45);
		frame23.getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox.addItem("Select your choice");
		combo2();
		comboBox.setBounds(443, 91, 260, 36);
		frame23.getContentPane().add(comboBox);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_2.addItem("Select your choice");
		combo();
		comboBox_2.setBounds(1042, 91, 260, 36);
		frame23.getContentPane().add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_1.addItem("Select your choice");
		comboBox_1.setBounds(784, 172, 260, 36);
		frame23.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Project Title:");
		lblNewLabel_4_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_4_1_1.setBounds(589, 169, 192, 40);
		frame23.getContentPane().add(lblNewLabel_4_1_1);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#4b6584"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=null;
				if(instructorpage.email!=null) {
					email=instructorpage.email;
				}
				else if(loginsignup.Email!=null) {
					email=loginsignup.Email;
				}
				if(email!=null) {
					try {
						String ComboBox=comboBox.getSelectedItem().toString();
						String ComboBox_2=comboBox_2.getSelectedItem().toString();
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
						PreparedStatement pstmt;
						pstmt=connection.prepareStatement("select Title from project where StudentEmail=? and InstructorEmail=? and Subjects=?");
						pstmt.setString(1, ComboBox_2);
						pstmt.setString(2, email);
						pstmt.setString(3, ComboBox);
						ResultSet rs=pstmt.executeQuery();
						while(rs.next()) {
							String str=rs.getString("Title");
							comboBox_1.addItem(str);
						}
						connection.close();
					}catch(Exception exception) {
						exception.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 23));
		btnNewButton.setBounds(1312, 89, 101, 40);
		frame23.getContentPane().add(btnNewButton);
		
		JButton btnDone = new JButton("Display Project");
		btnDone.setForeground(Color.WHITE);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(comboBox.getSelectedItem().toString().equals("Select your choice") && comboBox_1.getSelectedItem().toString().equals("Select your choice") && comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(comboBox.getSelectedItem().toString().equals("Select your choice")) {
					lblsubject.setText("*This field is required");flag=1;
				}
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice")) {
					lbltitle.setText("*This field is required");flag=1;
				}
				if(comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					lblemail.setText("*This field is required");flag=1;
				}
				if(flag==0) {
					String email=null;
					if(instructorpage.email!=null) {
						email=instructorpage.email;
					}
					else if(loginsignup.Email!=null) {
						email=loginsignup.Email;
					}
					if(email!=null) {
						try {
							String ComboBox=comboBox.getSelectedItem().toString();
							String ComboBox_2=comboBox_2.getSelectedItem().toString();
							String ComboBox_1=comboBox_1.getSelectedItem().toString();
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
							PreparedStatement pstmt;
							pstmt=connection.prepareStatement("select * from project where StudentEmail=? and InstructorEmail=? and Subjects=? and Title=?");
							pstmt.setString(1, ComboBox_2);
							pstmt.setString(2, email);
							pstmt.setString(3, ComboBox);
							pstmt.setString(4, ComboBox_1);
							ResultSet rs=pstmt.executeQuery();
							if(rs.next()) {
								textArea.setText(rs.getString("Summary"));
								byte[] img = rs.getBytes("Image");
								ImageIcon image = new ImageIcon(img);
			                    Image im = image.getImage();
			                    Image myImg = im.getScaledInstance(projectimage.getWidth(), projectimage.getHeight(),Image.SCALE_SMOOTH);
			                    ImageIcon newImage = new ImageIcon(myImg);
			                    projectimage.setIcon(newImage);
							}
							connection.close();
						}catch(Exception exception) {
							exception.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Sorry, an error occured");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured");
				}
				
			}
		});
		btnDone.setFont(new Font("Sitka Display", Font.BOLD, 23));
		btnDone.setBackground(new Color(0, 51, 102));
		btnDone.setBounds(695, 218, 208, 40);
		frame23.getContentPane().add(btnDone);
		
		lblsubject = new JLabel("");
		lblsubject.setBackground(Color.WHITE);
		lblsubject.setForeground(Color.RED);
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblsubject.setBounds(443, 134, 260, 25);
		frame23.getContentPane().add(lblsubject);
		
		lbltitle = new JLabel("");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(Color.RED);
		lbltitle.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lbltitle.setBounds(1042, 183, 260, 25);
		frame23.getContentPane().add(lbltitle);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblemail.setBounds(1042, 137, 260, 25);
		frame23.getContentPane().add(lblemail);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				instructorform nw =new instructorform();
				nw.frame14.setVisible(true);
				frame23.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame23.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_33 = new JLabel("Back");
		lblNewLabel_33.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_33.setBounds(46, 36, 45, 20);
		frame23.getContentPane().add(lblNewLabel_33);
	   
	}
}