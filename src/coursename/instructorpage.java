package coursename;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class instructorpage {

	JFrame frame13;
	private JTable table;
	public static String email;
	public static String firstname;
	public static String lastname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructorpage window = new instructorpage();
					window.frame13.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public instructorpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame13 = new JFrame();
		frame13.getContentPane().setBackground(Color.WHITE);
		frame13.setBounds(100, 100, 1920, 1080);
		frame13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame13.getContentPane().setLayout(null);
		
		JLabel lblListOfInstructors = new JLabel("List Of Instructor's");
		lblListOfInstructors.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfInstructors.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblListOfInstructors.setForeground(Color.decode("#6F1E51"));
		lblListOfInstructors.setBounds(596, 107, 450, 45);
		frame13.getContentPane().add(lblListOfInstructors);
		
		JButton details2 = new JButton("Display List");
		details2.setForeground(Color.WHITE);
		details2.setBackground(new Color(0, 51, 102));
		details2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("SELECT first_name,last_name,E_mailID FROM instructorinfo WHERE approve=?");
					pstmt.setString(1, "Yes");
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					connection.close();
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		details2.setFont(new Font("Sitka Display", Font.BOLD, 28));
		details2.setBounds(692, 185, 239, 40);
		frame13.getContentPane().add(details2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int index=table.getSelectedRow();
					TableModel model=table.getModel();
					firstname=model.getValueAt(index, 0).toString();
					lastname=model.getValueAt(index, 1).toString();
					email=model.getValueAt(index, 2).toString();
					
					instructorform nw=new instructorform();
					nw.frame14.setVisible(true);
					frame13.dispose();

				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		scrollPane.setBounds(399, 258, 818, 490);
		frame13.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.decode("#f7f1e3"));
		table.setRowHeight(35);
		table.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		
		JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.decode("#cf6a87"));
	    tableHeader.setFont(new Font("Sitka Display", Font.BOLD, 22));
	    tableHeader.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				welcomeadmin nw =new welcomeadmin();
				nw.frame11.setVisible(true);
				frame13.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame13.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_34 = new JLabel("Back");
		lblNewLabel_34.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_34.setBounds(46, 36, 45, 20);
		frame13.getContentPane().add(lblNewLabel_34);
		}
	
}
