package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class allqueries {

	JFrame frame19;
	private JTable table;
	private JButton btnNewButton_1;
	private JLabel lblAllQueries;
	private JLabel lblemail;
	private JComboBox comboBox_1;
	private JLabel lblsubject;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allqueries window = new allqueries();
					window.frame19.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public allqueries() {
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
		frame19 = new JFrame();
		frame19.getContentPane().setBackground(Color.WHITE);
		frame19.setBounds(100, 100, 1920, 1080);
		frame19.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame19.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Subject :");
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_4.setBounds(252, 131, 226, 40);
		frame19.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Student Email :");
		lblNewLabel_4_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblNewLabel_4_1.setBounds(745, 131, 226, 40);
		frame19.getContentPane().add(lblNewLabel_4_1);
		
		lblsubject = new JLabel("");
		lblsubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubject.setForeground(Color.RED);
		lblsubject.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblsubject.setBounds(409, 182, 260, 25);
		frame19.getContentPane().add(lblsubject);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_1.addItem("Select your choice");
		combo();
		comboBox_1.setBounds(981, 132, 260, 40);
		frame19.getContentPane().add(comboBox_1);
		
		lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.CENTER);
		lblemail.setForeground(Color.RED);
		lblemail.setFont(new Font("Sitka Display", Font.PLAIN, 18));
		lblemail.setBounds(981, 182, 260, 25);
		frame19.getContentPane().add(lblemail);
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 51, 102));
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
							pstmt=connection.prepareStatement("SELECT Question,Answer FROM queries where StudentEmail=? and InstructorEmail=? and Subjects=?");
							pstmt.setString(1, ComboBox_1);
							pstmt.setString(2, email);
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
		btnNewButton.setBounds(1251, 131, 132, 40);
		frame19.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(354, 222, 913, 494);
		frame19.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.decode("#f7f1e3"));
		table.setRowHeight(35);
		table.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		
		JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.decode("#cf6a87"));
	    tableHeader.setFont(new Font("Sitka Display", Font.BOLD, 22));
	    tableHeader.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instructorform nw=new instructorform();
				nw.frame14.setVisible(true);
				frame19.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 102));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnNewButton_1.setBounds(655, 663, 113, 36);
		frame19.getContentPane().add(btnNewButton_1);
		
		lblAllQueries = new JLabel("All Queries");
		lblAllQueries.setForeground(Color.decode("#6F1E51"));
		lblAllQueries.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllQueries.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblAllQueries.setBounds(706, 22, 241, 51);
		frame19.getContentPane().add(lblAllQueries);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox_2.addItem("Select your choice");
		combo2();
		comboBox_2.setBounds(409, 132, 260, 40);
		frame19.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				instructorform nw =new instructorform();
				nw.frame14.setVisible(true);
				frame19.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame19.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame19.getContentPane().add(lblNewLabel_3);

		
		
	}
}
