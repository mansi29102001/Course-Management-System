package coursename;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class studentapprove {

	 JFrame frame8;
	 private JTable table;
	 public static String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentapprove window = new studentapprove();
					window.frame8.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public studentapprove() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame8 = new JFrame();
		frame8.getContentPane().setBackground(Color.WHITE);
		frame8.setBounds(100, 100, 1920, 1080);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String firstname=model.getValueAt(index, 0).toString();
				String lastname=model.getValueAt(index, 1).toString();
				email=model.getValueAt(index, 2).toString();
				
				studenttextfield nw=new studenttextfield();
				nw.frame10.setVisible(true);
			    frame8.dispose();
			}
		});
		scrollPane.setBounds(403, 280, 818, 490);
		frame8.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.decode("#f7f1e3"));
		table.setRowHeight(35);
		table.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		
		JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.decode("#cf6a87"));
	    tableHeader.setFont(new Font("Sitka Display", Font.BOLD, 22));
	    tableHeader.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton displayform2 = new JButton("Display Forms");
		displayform2.setBackground(new Color(0, 51, 102));
		displayform2.setForeground(Color.WHITE);
		displayform2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Vivaj@m09");
					PreparedStatement pstmt;
					pstmt=connection.prepareStatement("SELECT first_name,last_name,E_mailID FROM studentinfo WHERE " + "(approve = ?) " );
					pstmt.setString(1, "No");
					ResultSet rs=pstmt.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		displayform2.setFont(new Font("Sitka Display", Font.BOLD, 28));
		displayform2.setBounds(692, 203, 239, 40);
		frame8.getContentPane().add(displayform2);
		
		JLabel lblNewLabel = new JLabel("Student's Applications");
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(596, 107, 450, 45);
		frame8.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				adminlogin nw =new adminlogin();
				nw.frame5.setVisible(true);
				frame8.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame8.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame8.getContentPane().add(lblNewLabel_3);
		
	}
}
