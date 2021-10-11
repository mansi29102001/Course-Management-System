package coursename;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class allqueries2 {

	JFrame frame22;
	private JTable table;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JLabel lblemail;
	private JLabel lblsubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allqueries2 window = new allqueries2();
					window.frame22.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public allqueries2() {
		initialize();
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame22 = new JFrame();
		frame22.getContentPane().setBackground(Color.WHITE);
		frame22.setBounds(100, 100, 1920, 1080);
		frame22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame22.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice") & comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					JOptionPane.showMessageDialog(null, "Please fill all the information");flag=1;
				}
				if(comboBox_1.getSelectedItem().toString().equals("Select your choice")) {
					lblemail.setText("*This field is required");flag=1;
				}
				if(comboBox_2.getSelectedItem().toString().equals("Select your choice")) {
					lblsubject.setText("*This field is required");flag=1;
				}
				if(flag==0) {
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
							PreparedStatement pstmt;
							pstmt=connection.prepareStatement("SELECT Question,Answer FROM queries where StudentEmail=? and InstructorEmail=? and Subjects=?");
							pstmt.setString(1, email);
							pstmt.setString(2, ComboBox_1);
							pstmt.setString(3, ComboBox_2);
							ResultSet rs=pstmt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
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
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setBounds(1245, 131, 132, 40);
		frame22.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 222, 913, 494);
		frame22.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.decode("#f7f1e3"));
		table.setRowHeight(35);
		table.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		
		JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.decode("#cf6a87"));
	    tableHeader.setFont(new Font("Sitka Display", Font.BOLD, 22));
	    tableHeader.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblAllQueries = new JLabel("All Queries");
		lblAllQueries.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllQueries.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblAllQueries.setForeground(Color.decode("#6F1E51"));
		lblAllQueries.setBounds(634, 22, 241, 51);
		frame22.getContentPane().add(lblAllQueries);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_4.setBounds(219, 131, 132, 40);
		frame22.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Instructor Email :");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblNewLabel_4_1.setBounds(723, 132, 226, 40);
		frame22.getContentPane().add(lblNewLabel_4_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_2.addItem("Select your choice");
		combo2();
		comboBox_2.setBounds(362, 132, 260, 40);
		frame22.getContentPane().add(comboBox_2);
		
		lblsubject = new JLabel("");
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setForeground(Color.RED);
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblsubject.setBounds(362, 182, 260, 25);
		frame22.getContentPane().add(lblsubject);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_1.addItem("Select your choice");
		combo();
		comboBox_1.setBounds(975, 132, 260, 40);
		frame22.getContentPane().add(comboBox_1);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblemail.setBounds(975, 182, 260, 25);
		frame22.getContentPane().add(lblemail);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentform nw =new studentform();
				nw.frame15.setVisible(true);
				frame22.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame22.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame22.getContentPane().add(lblNewLabel_3);

	}
}
