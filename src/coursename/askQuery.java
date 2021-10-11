package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class askQuery {

	JFrame frame21;
	private JComboBox comboBox_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JComboBox comboBox_2;
	private JLabel lblsubject;
	private JLabel lblemail;
	private JLabel lbltitle;
	private JLabel lblques;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					askQuery window = new askQuery();
					window.frame21.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void combo() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			PreparedStatement pstmt;
			pstmt=connection.prepareStatement("SELECT E_mailID from instructorinfo where approve=?");
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
	 * Create the application.
	 */
	public askQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame21 = new JFrame();
		frame21.getContentPane().setBackground(Color.WHITE);
		frame21.setBounds(100, 100, 1920, 1080);
		frame21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame21.getContentPane().setLayout(null);
		
		JLabel image1lable = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (163).png"));
		image1lable.setIcon(img);
		image1lable.setBounds(931, 130, 572, 583);
		frame21.getContentPane().add(image1lable);
		
		JLabel lblNewLabel = new JLabel("Ask a Query");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 42));
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setBounds(682, 18, 247, 51);
		frame21.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Question:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(107, 441, 233, 51);
		frame21.getContentPane().add(lblNewLabel_1);
		
		textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		textArea.setBackground(SystemColor.inactiveCaptionBorder);
		textArea.setBounds(264, 502, 577, 170);
		frame21.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flag=0;
				String str=textArea.getText();
				String str2=textArea_1.getText();
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice") & comboBox_2.getSelectedItem().toString().equals("Select your choice") && str.length()==0 && str2.length()==0) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice")) {
					lblemail.setText("*This field is required");flag=1;
				}
				if(comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					lblsubject.setText("*This field is required");flag=1;
				}
				if(str2.length()==0) {
					lbltitle.setText("*This field is required");flag=1;
				}
				if(str.length()==0) {
					lblques.setText("*This field is required");flag=1;
				}
				if(flag==0) {
					String query=textArea.getText();
					String email=null;
					if(studentpage.email!=null) {
						email=studentpage.email;
					}
					else if(loginsignup.Email!=null) {
						email=loginsignup.Email;
					}
					if(email!=null) {
						String ComboBox_1=comboBox_1.getSelectedItem().toString();
						String ComboBox_2=comboBox_2.getSelectedItem().toString();
						try {
							
							  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
			                    String query1 = "INSERT INTO queries(StudentEmail,InstructorEmail,Subjects,queryTitle,Question) values(?,?,?,?,?)";
			                    PreparedStatement statement=connection.prepareStatement(query1);
			            
			                    statement.setString(1,email);
			                    statement.setString(2,ComboBox_1);
			                    statement.setString(3,ComboBox_2);
			                    statement.setString(4,textArea_1.getText());
			                    statement.setString(5,textArea.getText());
			                   
			                    statement.executeUpdate();
								JOptionPane.showMessageDialog(null,"Query send successfully!!");
								int result=JOptionPane.showConfirmDialog(null,"Do you want to ask another query??","Your response",JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
								if(result==JOptionPane.YES_OPTION) {
									askQuery nw=new askQuery();
									nw.frame21.setVisible(true);
									frame21.dispose();	
								}
								else if(result==JOptionPane.NO_OPTION) {
									studentform nw=new studentform();
									nw.frame15.setVisible(true);
									frame21.dispose();	
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
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnNewButton.setBounds(516, 718, 113, 36);
		frame21.getContentPane().add(btnNewButton);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_2.setBounds(369, 159, 260, 35);
		comboBox_2.addItem("Select your choice");
		combo2();
		frame21.getContentPane().add(comboBox_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_1.setBounds(369, 243, 260, 35);
		comboBox_1.addItem("Select your choice");
		combo();
		frame21.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_4.setBounds(114, 155, 226, 40);
		frame21.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Instructor Email :");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_4_1.setBounds(114, 239, 226, 40);
		frame21.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Query Title:");
		lblNewLabel_4_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_4_1_1.setBounds(114, 329, 226, 40);
		frame21.getContentPane().add(lblNewLabel_4_1_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setToolTipText("");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setBounds(369, 335, 260, 40);
		frame21.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentform nw =new studentform();
				nw.frame15.setVisible(true);
				frame21.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame21.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame21.getContentPane().add(lblNewLabel_3);
		
		lblsubject = new JLabel("");
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setForeground(Color.RED);
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblsubject.setBackground(Color.WHITE);
		lblsubject.setBounds(369, 204, 260, 25);
		frame21.getContentPane().add(lblsubject);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblemail.setBackground(Color.WHITE);
		lblemail.setBounds(369, 288, 260, 25);
		frame21.getContentPane().add(lblemail);
		
		lbltitle = new JLabel("");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setForeground(Color.RED);
		lbltitle.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lbltitle.setBackground(Color.WHITE);
		lbltitle.setBounds(369, 385, 260, 25);
		frame21.getContentPane().add(lbltitle);
		
		lblques = new JLabel("");
		lblques.setHorizontalAlignment(SwingConstants.CENTER);
		lblques.setForeground(Color.RED);
		lblques.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblques.setBackground(Color.WHITE);
		lblques.setBounds(265, 688, 576, 25);
		frame21.getContentPane().add(lblques);

	}
}
