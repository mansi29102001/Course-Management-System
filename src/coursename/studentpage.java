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

public class studentpage {

	JFrame frame12;
	private JTable table;
	public static String firstname;
	public static String lastname;
	public static String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentpage window = new studentpage();
					window.frame12.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame12 = new JFrame();
		frame12.getContentPane().setBackground(Color.WHITE);
		frame12.setBackground(Color.WHITE);
		frame12.setBounds(100, 100, 1920, 1080);
		frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame12.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Of Student's");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setBounds(596, 107, 450, 45);
		frame12.getContentPane().add(lblNewLabel);
		
		JButton details1 = new JButton("Display List");
		details1.setForeground(Color.WHITE);
		details1.setBackground(Color.decode("#dff9fb"));
		details1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt=connection.prepareStatement("SELECT first_name,last_name,E_mailID FROM studentinfo WHERE approve=?");
					pstmt.setString(1, "Yes");
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					connection.close();
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		details1.setFont(new Font("Sitka Display", Font.BOLD, 28));
		details1.setBackground(new Color(0, 51, 102));
		details1.setBounds(692, 185, 239, 40);
		frame12.getContentPane().add(details1);
		
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
					
					studentform nw=new studentform();
					nw.frame15.setVisible(true);
					frame12.dispose();

				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		scrollPane.setBounds(399, 258, 818, 490);
		frame12.getContentPane().add(scrollPane);
		
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
				frame12.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame12.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame12.getContentPane().add(lblNewLabel_3);
		
	}
}
