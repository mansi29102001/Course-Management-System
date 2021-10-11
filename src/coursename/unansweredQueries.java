package coursename;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class unansweredQueries {

	JFrame frame18;
	private JComboBox comboBox_2;
	private JLabel lblsubject;
	private JComboBox comboBox;
	private JLabel lbltitle;
	private JComboBox comboBox_1;
	private JLabel lblemail;
	private JLabel lblans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unansweredQueries window = new unansweredQueries();
					window.frame18.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public unansweredQueries() {
		initialize();
	}public void combo() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT E_mailID from studentinfo where approve=?");
			pstmt.setString(1, "Yes");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String str=rs.getString("E_mailID");
				comboBox_1.addItem(str);
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
				comboBox_2.addItem(str);
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
		frame18 = new JFrame();
		frame18.getContentPane().setBackground(Color.WHITE);
		frame18.setBounds(100, 100, 1920, 1080);
		frame18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame18.getContentPane().setLayout(null);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (155).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(934, 245, 596, 446);
		frame18.getContentPane().add(image1lable);
		
		JLabel lblNewLabel = new JLabel("Unanswered Queries");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setBounds(615, 36, 378, 59);
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		frame18.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question: ");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(72, 417, 140, 41);
		frame18.getContentPane().add(lblNewLabel_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setBounds(274, 375, 512, 111);
		frame18.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Answer:");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setBounds(72, 578, 140, 41);
		frame18.getContentPane().add(lblNewLabel_2);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setText((String) null);
		textArea_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setBounds(274, 548, 512, 111);
		frame18.getContentPane().add(textArea_1);
	
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String ans=textArea_1.getText();
				if(ans.length()==0) {
					lblans.setText("*This field is required");flag=1;
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
							pstmt=connection.prepareStatement("UPDATE queries set Answer=? where InstructorEmail=? and StudentEmail=? and Question=? and Subjects=? and queryTitle=?");
							pstmt.setString(1, ans);
							pstmt.setString(2, email);
							pstmt.setString(3, ComboBox_1);
							pstmt.setString(4, textArea.getText());
							pstmt.setString(5, ComboBox_2);
							pstmt.setString(6, ComboBox);
							pstmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "Answer send!!");
							connection.close();
							int result=JOptionPane.showConfirmDialog(null,"Do you want to answer more queries?", "Your response",
						               JOptionPane.YES_NO_OPTION,
						               JOptionPane.QUESTION_MESSAGE);
							if(result==JOptionPane.YES_OPTION) {
								unansweredQueries nw=new unansweredQueries();
								nw.frame18.setVisible(true);
								frame18.dispose();
							}
							else if(result==JOptionPane.NO_OPTION) {
								instructorform nw=new instructorform();
								nw.frame14.setVisible(true);
								frame18.dispose();
							}
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
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton.setBounds(716, 740, 113, 36);
		frame18.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4.setBounds(72, 143, 226, 40);
		frame18.getContentPane().add(lblNewLabel_4);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_2.addItem("Select your choice");
		combo2();
		comboBox_2.setBounds(274, 144, 260, 40);
		frame18.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Student Email :");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4_1.setBounds(767, 143, 226, 40);
		frame18.getContentPane().add(lblNewLabel_4_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_1.addItem("Select your choice");
		combo();
		comboBox_1.setBounds(1017, 144, 260, 40);
		frame18.getContentPane().add(comboBox_1);
		
		lblsubject = new JLabel("");
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setForeground(Color.RED);
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblsubject.setBounds(274, 187, 260, 25);
		frame18.getContentPane().add(lblsubject);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblemail.setBounds(1017, 187, 260, 25);
		frame18.getContentPane().add(lblemail);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Query Title :");
		lblNewLabel_4_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		lblNewLabel_4_1_1.setBounds(72, 222, 226, 40);
		frame18.getContentPane().add(lblNewLabel_4_1_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox.addItem("Select your choice");
		comboBox.setBounds(274, 223, 260, 40);
		frame18.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(comboBox.getSelectedItem().toString().equals("Select your choice") && comboBox_1.getSelectedItem().toString().equals("Select your choice") && comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					lblsubject.setText("*This field is required");flag=1;
				}
				if(comboBox.getSelectedItem().toString().equals("Select your choice")) {
					lbltitle.setText("*This field is required");flag=1;
				}
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice")) {
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
							pstmt=connection.prepareStatement("select Question from queries where StudentEmail=? and InstructorEmail=? and Subjects=? and queryTitle=?");
							pstmt.setString(1, ComboBox_1);
							pstmt.setString(2, email);
							pstmt.setString(3, ComboBox_2);
							pstmt.setString(4, ComboBox);
							ResultSet rs=pstmt.executeQuery();
							if(rs.next()) {
								textArea.setText(rs.getString("Question"));
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
		btnNewButton_1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		btnNewButton_1.setBackground(Color.decode("#4b6584"));
		btnNewButton_1.setBounds(564, 222, 132, 40);
		frame18.getContentPane().add(btnNewButton_1);
		
		lbltitle = new JLabel("");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(Color.RED);
		lbltitle.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lbltitle.setBounds(274, 273, 260, 25);
		frame18.getContentPane().add(lbltitle);
		
		lblans = new JLabel("");
		lblans.setHorizontalAlignment(SwingConstants.CENTER);
		lblans.setForeground(Color.RED);
		lblans.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		lblans.setBounds(222, 613, 512, 18);
		frame18.getContentPane().add(lblans);
		
		JButton btnNewButton_2 = new JButton("Apply");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
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
						String ComboBox_1=comboBox_1.getSelectedItem().toString();
						String ComboBox_2=comboBox_2.getSelectedItem().toString();
						 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
						PreparedStatement pstmt;
						pstmt=connection.prepareStatement("select * from queries where StudentEmail=? and InstructorEmail=? and Subjects=?");
						pstmt.setString(1, ComboBox_1);
						pstmt.setString(2, email);
						pstmt.setString(3, ComboBox_2);
						
						
						ResultSet rs=pstmt.executeQuery();
						while(rs.next()) {
							String str=rs.getString("queryTitle");
							if(rs.getString("Answer")==null) {
								comboBox.addItem(str);
							}
							
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
		btnNewButton_2.setFont(new Font("Sitka Display", Font.BOLD, 25));
		btnNewButton_2.setBackground(Color.decode("#4b6584"));
		btnNewButton_2.setBounds(1301, 144, 113, 40);
		frame18.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				instructorform nw =new instructorform();
				nw.frame14.setVisible(true);
				frame18.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame18.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_33 = new JLabel("Back");
		lblNewLabel_33.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_33.setBounds(46, 36, 45, 20);
		frame18.getContentPane().add(lblNewLabel_33);
	   
		
	}
	
}
