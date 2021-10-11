package coursename;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminlogin {

	JFrame frame5;
	private JLabel approvalvalidation;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin window = new adminlogin();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	


	/**
	 * Create the application.
	 */
	public adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.setBackground(Color.WHITE);
		frame5.getContentPane().setBackground(Color.WHITE);
		frame5.setBounds(100, 100, 1920, 1080);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrator Panel");
		lblNewLabel.setForeground(Color.decode("#6F1E51"));
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(687, 61, 438, 50);
		frame5.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Form Approval");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_1.setForeground(Color.decode("#F79F1F"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1067, 298, 241, 35);
		frame5.getContentPane().add(lblNewLabel_1);
		
		
		JButton next2 = new JButton("NEXT");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Select your Choice")) {
					approvalvalidation.setText("This field is required");
				}
				else if(comboBox.getSelectedItem().toString().equals("Instructor")) {
					instructorapprove nw =new instructorapprove();
				    nw.frame7.setVisible(true);
				    frame5.dispose();	
				}
				else if(comboBox.getSelectedItem().toString().equals("Student")) {
					studentapprove nw =new studentapprove();
				    nw.frame8.setVisible(true);
				    frame5.dispose();	
				}
			}
		});
		next2.setForeground(new Color(255, 255, 255));
		next2.setBackground(new Color(0, 51, 102));
		next2.setFont(new Font("Sitka Display", Font.BOLD, 28));
		next2.setBounds(837, 671, 120, 40);
		frame5.getContentPane().add(next2);
		
		JLabel lblNewLabel_2 = new JLabel("(Select any one of following to approve their forms) ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.decode("#e55039"));
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(837, 351, 693, 30);
		frame5.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel21 = new JLabel();
		ImageIcon img= new ImageIcon(this.getClass().getResource("/Screenshot (166).png"));
		lblNewLabel21.setIcon(img);
		lblNewLabel21.setBounds(297, 134, 604, 486);
		frame5.getContentPane().add(lblNewLabel21);
		
		approvalvalidation = new JLabel("");
		approvalvalidation.setForeground(Color.RED);
		approvalvalidation.setHorizontalAlignment(SwingConstants.CENTER);
		approvalvalidation.setFont(new Font("Sitka Display", Font.PLAIN, 23));
		approvalvalidation.setBounds(895, 470, 619, 30);
		frame5.getContentPane().add(approvalvalidation);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Sitka Display", Font.PLAIN, 25));
		comboBox.setBounds(1067, 413, 253, 35);
		frame5.getContentPane().add(comboBox);
		comboBox.addItem("Select your choice");
		comboBox.addItem("Instructor");
		comboBox.addItem("Student");
		
		JLabel lblNewLabel212 = new JLabel();
		lblNewLabel212.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				welcomeadmin nw =new welcomeadmin();
				nw.frame11.setVisible(true);
				frame5.dispose();
			}
		});
		ImageIcon img50= new ImageIcon(this.getClass().getResource("/backbutton.png"));
		lblNewLabel212.setIcon(img50);
		lblNewLabel212.setBounds(10, 10, 38, 64);
		frame5.getContentPane().add(lblNewLabel212);
		
		JLabel lblNewLabel_3 = new JLabel("Back");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 20));
		lblNewLabel_3.setBounds(46, 36, 45, 20);
		frame5.getContentPane().add(lblNewLabel_3);

	}
}
